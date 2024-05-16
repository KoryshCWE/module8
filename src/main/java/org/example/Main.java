package org.example;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        DatabaseInitService.main(args);

        DatabasePopulateService.main(args);

        DatabaseQueryService.main(args);
    }
}
