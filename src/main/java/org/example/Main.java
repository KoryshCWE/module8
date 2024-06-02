package org.example;

import org.example.data.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientService service  = new ClientService();
        try {

            List<Client> clients = service.getAll();
            for (Client client : clients) {
                System.out.println(client.getName());
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}