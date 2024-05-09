package com.combs.cards.mongo.cards.models;

import java.math.BigDecimal;

public class AddCardRequest {

    private String firstName;
    private String lastName;
    private String year;
    private String sport;
    private String manufacturer;
    private BigDecimal psaValue;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPsaValue() {
        return psaValue;
    }

    public void setPsaValue(BigDecimal psaValue) {
        this.psaValue = psaValue;
    }
}
