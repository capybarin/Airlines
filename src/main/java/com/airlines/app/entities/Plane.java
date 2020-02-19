package com.airlines.app.entities;

public class Plane {
    private String id;
    private String name;
    private String type;
    private String company;
    private int seats;
    private String busy;
    private String from;
    private String to;
    private int price;
    private String date;

    public Plane(String id, String name, String type, String company, int seats, String busy, String from, String to, int price, String date) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.company = company;
        this.seats = seats;
        this.busy = busy;
        this.from = from;
        this.to = to;
        this.price = price;
        this.date = date;
    }

    public Plane(String name, String type, String company, int seats, String busy, String from, String to, int price, String date) {
        this.name = name;
        this.type = type;
        this.company = company;
        this.seats = seats;
        this.busy = busy;
        this.from = from;
        this.to = to;
        this.price = price;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getBusy() {
        return busy;
    }

    public void setBusy(String busy) {
        this.busy = busy;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", company='" + company + '\'' +
                ", seats=" + seats +
                ", busy='" + busy + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }
}
