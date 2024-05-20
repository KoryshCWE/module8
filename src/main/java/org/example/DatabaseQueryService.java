package org.example;

import org.example.data.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class DatabaseQueryService {
    public static void main(String[] args) {
        try {
            DatabaseQueryService service = new DatabaseQueryService();
            List<LongestProject> longestProjects = service.findLongestProject();
            longestProjects.forEach(project ->
                    System.out.println("Project ID: " + project.getId() + ", Month Count: " + project.getMonthCount()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Database database = Database.getInstance();

    public List<LongestProject> findLongestProject() throws IOException, SQLException {
        String sql = new String(Files.readAllBytes(Paths.get("SQL/find_longest_project.sql")));
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            List<LongestProject> projects = new ArrayList<>();
            while (resultSet.next()) {
                LongestProject project = new LongestProject();
                project.setId(resultSet.getInt("ID"));
                project.setMonthCount(resultSet.getInt("MONTH_COUNT"));
                projects.add(project);
            }
            return projects;
        }
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() throws IOException {
        String sql = new String(Files.readAllBytes(Paths.get("SQL/find_max_projects_client.sql")));
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            List<MaxProjectCountClient> clients = new ArrayList<>();
            while (resultSet.next()) {
                MaxProjectCountClient client = new MaxProjectCountClient();
                client.setName(resultSet.getString("CLIENT_NAME"));
                client.setProjectCount(resultSet.getInt("PROJECT_COUNT"));
                clients.add(client);
            }
            return clients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws IOException {
        String sql = new String(Files.readAllBytes(Paths.get("SQL/find_max_salary_worker.sql")));

        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            List<MaxSalaryWorker> workers = new ArrayList<>();
            while (resultSet.next()) {
                MaxSalaryWorker worker = new MaxSalaryWorker();
                worker.setName(resultSet.getString("NAME"));
                worker.setSalary(resultSet.getInt("SALARY"));
                workers.add(worker);
            }
            return workers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorker() throws IOException {
        String sql = new String(Files.readAllBytes(Paths.get("SQL/find_youngest_eldest_workers.sql")));

        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            List<YoungestEldestWorkers> workers = new ArrayList<>();
            while (resultSet.next()) {
                YoungestEldestWorkers worker = new YoungestEldestWorkers();
                worker.setName(resultSet.getString("NAME"));
                worker.setBirthday(resultSet.getDate("BIRTHDAY"));
                worker.setType(resultSet.getString("TYPE"));
                workers.add(worker);
            }
            return workers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProjectPrice> printProjectPrices() throws IOException {
        String sql = new String(Files.readAllBytes(Paths.get("SQL/print_project_prices.sql")));

        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            List<ProjectPrice> prices = new ArrayList<>();
            while (resultSet.next()) {
                ProjectPrice price = new ProjectPrice();
                price.setStartDate(resultSet.getDate("START_DATE"));
                price.setFinishDate(resultSet.getDate("FINISH_DATE"));
                price.setClientId(resultSet.getInt("CLIENT_ID"));
                price.setPrice(resultSet.getInt("PRICE"));
                price.setId(resultSet.getInt("ID"));
                prices.add(price);
            }
            return prices;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
