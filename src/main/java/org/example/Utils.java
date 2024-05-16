package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Utils {
    public static void executeSqlScript(Connection connection, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder sb = new StringBuilder();
            Statement statement = connection.createStatement();


            while ((line = reader.readLine()) != null) {
                sb.append(line.trim());
                if (line.endsWith(";")) {
                    statement.execute(sb.toString());
                    sb.setLength(0);
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
