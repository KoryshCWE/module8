package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;


public class DatabaseInitService {
    public static void main(String[] args) {
        Flyway flyway = Flyway. configure()
                .dataSource (Database.getInstance().getDs())
                .locations ("db/migration")
        .load ();
        flyway.migrate();

    }
}

