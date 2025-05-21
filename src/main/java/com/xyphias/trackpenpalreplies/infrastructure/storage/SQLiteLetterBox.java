package com.xyphias.trackpenpalreplies.infrastructure.storage;

import com.xyphias.trackpenpalreplies.Letter;
import com.xyphias.trackpenpalreplies.LetterBox;
import com.xyphias.trackpenpalreplies.Penpal;
import org.flywaydb.core.Flyway;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SQLiteLetterBox implements LetterBox {
    public static SQLiteLetterBox createFor(String dbFile) {
        String jdbcUrl = "jdbc:sqlite:" + dbFile;

        Flyway
                .configure()
                .dataSource(jdbcUrl, "", "")
                .load()
                .migrate();

        return new SQLiteLetterBox(dbFile);
    }
    
    private SQLiteLetterBox(String dBFile) {
        dataSource = new SQLiteDataSource();

        dataSource.setUrl("jdbc:sqlite:" + dBFile);
    }

    @Override
    public boolean isEmpty() {
        try (Connection connection = dataSource.getConnection()) {
            int letterCount =
                    connection
                            .prepareStatement("SELECT COUNT(*) FROM Letters")
                            .executeQuery()
                            .getInt(1);

            return letterCount == 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Letter> contents() {
        try (Connection connection = dataSource.getConnection()) {
            ResultSet resultSet =
                    connection
                            .prepareStatement("SELECT * FROM Letters")
                            .executeQuery();
            
            List<Letter> letters = new ArrayList<>();

            while (resultSet.next()) {
                String name = resultSet.getString("from_penpal");
                LocalDate receivedOn =
                        LocalDate.parse(resultSet.getString("received_on"));

                letters.add(new Letter(new Penpal(name), receivedOn));
            }
            
            return letters;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Letter letter) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO Letters (from_penpal, received_on) VALUES (?, ?)");

            statement.setString(1, letter.from().name());
            statement.setString(2, letter.receivedOn().format(DateTimeFormatter.ISO_DATE));

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeLetterFrom(Penpal sender) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement("DELETE FROM Letters WHERE from_penpal = (?)");
            
            statement.setString(1, sender.name());
            
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final SQLiteDataSource dataSource;
}
