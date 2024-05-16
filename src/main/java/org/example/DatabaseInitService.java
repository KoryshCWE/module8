package org.example;

import java.sql.Connection;
import static org.example.Utils.executeSqlScript;

public class DatabaseInitService {
    public static void main(String[] args) {
        Connection connection = Database.getInstance().getConnection();
        executeSqlScript(connection, "SQL/init_db.sql");
    }
}

