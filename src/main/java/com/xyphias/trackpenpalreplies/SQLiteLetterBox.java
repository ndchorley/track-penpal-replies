package com.xyphias.trackpenpalreplies;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SQLiteLetterBox implements LetterBox {
    public SQLiteLetterBox(String dBFile) {
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

            if (!resultSet.next()) return List.of();
            
            String name = resultSet.getString("from_penpal");
            LocalDate receivedOn =
                    LocalDate.parse(resultSet.getString("received_on"));
            
            return List.of(new Letter(new Penpal(name), receivedOn));
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

    private final SQLiteDataSource dataSource;
}
