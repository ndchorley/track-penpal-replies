package com.xyphias.trackpenpalreplies;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.SQLException;
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
        return List.of();
    }

    @Override
    public void add(Letter letter) {}

    private final SQLiteDataSource dataSource;
}
