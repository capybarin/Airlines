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
        this.id = id;
        this.seat = seat;
        this.dateOfBeg = dateOfBeg;
        this.dateOfEnd = dateOfEnd;
        this.terminal = terminal;
        this.gate = gate;
        this.userName = userName;
        this.userSurname = userSurname;
        this.planeName = planeName;
        this.planeType = planeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
