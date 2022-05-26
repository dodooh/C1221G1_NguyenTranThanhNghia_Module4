package com.codegym.model;

public class Declaration {
    private String name;
    private Integer yearOfBirth;
    private Integer gender;
    private String nation;
    private String nationalId;
    private String transport;
    private String transportNumber;
    private Integer seat;
    private Integer startDay;
    private Integer startMonth;
    private Integer startYear;
    private Integer endDay;
    private Integer endMonth;
    private Integer endYear;
    private String gotoCity;

    public Declaration() {
    }

    public Declaration(String name, Integer yearOfBirth, Integer gender, String nation, String nationalId, String transport,
        String transportNumber, Integer seat, Integer startDay, Integer startMonth, Integer startYear, Integer endDay, Integer endMonth,
        Integer endYear, String gotoCity) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nation = nation;
        this.nationalId = nationalId;
        this.transport = transport;
        this.transportNumber = transportNumber;
        this.seat = seat;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.gotoCity = gotoCity;

    }

    public Declaration(Declaration declaration) {

        this.name = declaration.getName();
        this.yearOfBirth = declaration.getYearOfBirth();
        this.gender = declaration.getGender();
        this.nation = declaration.getNation();
        this.nationalId = declaration.getNationalId();
        this.transport = declaration.getTransport();
        this.transportNumber = declaration.getTransportNumber();
        this.seat = declaration.getSeat();
        this.startDay = declaration.getStartDay();
        this.startMonth = declaration.getStartMonth();
        this.startYear = declaration.getStartYear();
        this.endDay = declaration.getEndDay();
        this.endMonth = declaration.getEndMonth();
        this.endYear = declaration.getEndYear();
        this.gotoCity = declaration.getGotoCity();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getTransportNumber() {
        return transportNumber;
    }

    public void setTransportNumber(String transportNumber) {
        this.transportNumber = transportNumber;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getStartDay() {
        return startDay;
    }

    public void setStartDay(Integer startDay) {
        this.startDay = startDay;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndDay() {
        return endDay;
    }

    public void setEndDay(Integer endDay) {
        this.endDay = endDay;
    }

    public Integer getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Integer endMonth) {
        this.endMonth = endMonth;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public String getGotoCity() {
        return gotoCity;
    }

    public void setGotoCity(String gotoCity) {
        this.gotoCity = gotoCity;
    }
}
