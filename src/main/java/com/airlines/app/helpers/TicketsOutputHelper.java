package com.airlines.app.helpers;

public class TicketsOutputHelper {
    private int id;
    private int seat;
    private String dateOfBeg;
    private String dateOfEnd;
    private String terminal;
    private String gate;
    private String userName;
    private String userSurname;
    private String planeName;
    private String planeType;

    public TicketsOutputHelper(int id, int seat, String dateOfBeg, String dateOfEnd, String terminal, String gate, String userName, String userSurname, String planeName, String planeType) {
        this.id = id; //Ticket
        this.seat = seat; //Ticket
        this.dateOfBeg = dateOfBeg; //Ticket
        this.dateOfEnd = dateOfEnd; //Ticket
        this.terminal = terminal; //Ticket
        this.gate = gate; //Ticket
        this.userName = userName; //User
        this.userSurname = userSurname; //User
        this.planeName = planeName; //Plane
        this.planeType = planeType; //Plane
    }

    public int getId() {
        return id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    @Override
    public String toString() {
        return "TicketsOutputHelper{" +
                "id=" + id +
                ", seat=" + seat +
                ", dateOfBeg='" + dateOfBeg + '\'' +
                ", dateOfEnd='" + dateOfEnd + '\'' +
                ", terminal='" + terminal + '\'' +
                ", gate='" + gate + '\'' +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", planeName='" + planeName + '\'' +
                ", planeType='" + planeType + '\'' +
                '}';
    }
}
