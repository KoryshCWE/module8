package org.example;

import org.example.data.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    long create(String name) throws SQLException {
        if ( name == null || name.length() < 3 || name.length() > 50 ) {
            throw new SQLException("the name does not meet required min/maximum symbols");
        }
        String sql = "INSERT INTO client (name) VALUES (?) RETURNING id";
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, name);
        ResultSet resultSet = st.executeQuery();
        resultSet.next();
        return resultSet.getLong(1);
    }
    public String getById(long id) throws SQLException {
        if ( id < 1 ) {
            throw new SQLException("the id must be greater than 0");
        }
        String sql = "select * from client where id = ?";
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        PreparedStatement st = connection.prepareStatement(sql);
        st.setLong(1, id);
        ResultSet resultSet = st.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString("name");
        }else{
            return null;
        }
    }
    public void setName(long id, String name) throws SQLException {
        if (id <= 0) {
            throw new SQLException("the id must be greater than 0");
        }
        if (name == null || name.length() < 3 || name.length() > 50 ) {
            throw new SQLException("the name does not meet required min/maximum symbols");
        }
        String sql = "update client set name = ? where id = ?";
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, name);
        st.setLong(2, id);
        st.executeUpdate();
    }
    public void delete(long id) throws SQLException {
        if (id <= 0) {
            throw new SQLException("the id must be greater than 0");
        }
        String sql = "delete from client where id = ?";
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        PreparedStatement st = connection.prepareStatement(sql);
        st.setLong(1, id);
        st.executeUpdate();
    }
    public List<Client> getAll() throws SQLException {
        String sql = "select * from client";
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        PreparedStatement st = connection.prepareStatement(sql);
        ResultSet resultSet = st.executeQuery();
        List<Client> clients = new ArrayList<>();
        while (resultSet.next()) {
            Client client = new Client();
            client.setId(resultSet.getLong("id"));
            client.setName(resultSet.getString("name"));
            clients.add(client);

        }
        return clients;
    }
}
