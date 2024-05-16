package org.example.data;

public class ProjectPrice {
    private int id;
    private int clientId;
    private java.sql.Date startDate;
    private java.sql.Date finishDate;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public java.sql.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.sql.Date startDate) {
        this.startDate = startDate;
    }

    public java.sql.Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(java.sql.Date finishDate) {
        this.finishDate = finishDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
