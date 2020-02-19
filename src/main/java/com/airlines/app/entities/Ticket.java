package com.airlines.app.entities;

public class Ticket {
    private int id;
    private int idUser;
    private int idPlane;
    private int seat;
    private String date;

    public Ticket(int idUser, int idPlane, int seat, String date) {
        this.idUser = idUser;
        this.idPlane = idPlane;
        this.seat = seat;
        this.date = date;
    }

    public Ticket(int id, int idUser, int idPlane, int seat, String date) {
        this.id = id;
        this.idUser = idUser;
        this.idPlane = idPlane;
        this.seat = seat;
        this.date = date;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idPlane=" + idPlane +
                ", seat=" + seat +
                ", date='" + date + '\'' +
                '}';
    }
}
