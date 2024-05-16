package org.example;

import java.sql.Connection;
import static org.example.Utils.executeSqlScript;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Connection connection = Database.getInstance().getConnection();
        executeSqlScript(connection, "SQL/populate_db.sql");
    }
}
