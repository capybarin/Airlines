package com.airlines.app.helpers;

public class NotDirectRoutesOutputHelper {
    private String name;
    private String type;
    private String company;
    private int seats;
    private String from;
    private String tmpLoc;
    private String to;
    private int price;
    private String date;

    public NotDirectRoutesOutputHelper(String name, String type, String company, int seats, String from, String tmpLoc, String to, int price, String date) {
        this.name = name;
        this.type = type;
        this.company = company;
        this.seats = seats;
        this.from = from;
        this.tmpLoc = tmpLoc;
        this.to = to;
        this.price = price;
        this.date = date;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTmpLoc() {
        return tmpLoc;
    }

    public void setTmpLoc(String tmpLoc) {
        this.tmpLoc = tmpLoc;
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
        return "NotDirectRoutesOutputHelper{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", company='" + company + '\'' +
                ", seats=" + seats +
                ", from='" + from + '\'' +
                ", tmpLoc='" + tmpLoc + '\'' +
                ", to='" + to + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }
}
