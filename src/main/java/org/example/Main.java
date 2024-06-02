package org.example;

import org.example.data.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        DatabaseInitService.main(args);
        ClientService service  = new ClientService();
        try {
//            service.create("John Deer");
//            String name = service.getById(4);
//            System.out.println(name);
//            service.setName(4, "Digital Slang");
//            service.delete(7);
            List<Client> clients = service.getAll();
            for (Client client : clients) {
                System.out.println(client.getName());
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}