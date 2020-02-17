package com.airlines.app.entities;

public class Ticket {
    private int id;
    private int idUser;
    private int idPlane;

    public Ticket(int id, int idUser, int idPlane) {
        this.id = id;
        this.idUser = idUser;
        this.idPlane = idPlane;
    }

    public Ticket(int idUser, int idPlane) {
        this.idUser = idUser;
        this.idPlane = idPlane;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idPlane=" + idPlane +
                '}';
    }
}
