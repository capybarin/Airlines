package com.airlines.app.entities;

public class Ticket {
    private int id;
    private int idUser;
    private int idPlane;
    private int seat;
    private String dateOfBeg;
    private String dateOfEnd;
    private String terminal;
    private String gate;

    public Ticket(int id, int idUser, int idPlane, int seat, String dateOfBeg, String dateOfEnd, String terminal, String gate) {
        this.id = id;
        this.idUser = idUser;
        this.idPlane = idPlane;
        this.seat = seat;
        this.dateOfBeg = dateOfBeg;
        this.dateOfEnd = dateOfEnd;
        this.terminal = terminal;
        this.gate = gate;
    }

    public Ticket(int idUser, int idPlane, int seat, String dateOfBeg, String dateOfEnd, String terminal, String gate) {
        this.idUser = idUser;
        this.idPlane = idPlane;
        this.seat = seat;
        this.dateOfBeg = dateOfBeg;
        this.dateOfEnd = dateOfEnd;
        this.terminal = terminal;
        this.gate = gate;
    }

    public int getId() {
        return id;
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

    public String getDateOfBeg() {
        return dateOfBeg;
    }

    public void setDateOfBeg(String dateOfBeg) {
        this.dateOfBeg = dateOfBeg;
    }

    public String getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(String dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idPlane=" + idPlane +
                ", seat=" + seat +
                ", dateOfBeg='" + dateOfBeg + '\'' +
                ", dateOfEnd='" + dateOfEnd + '\'' +
                ", terminal='" + terminal + '\'' +
                ", gate='" + gate + '\'' +
                '}';
    }
}
