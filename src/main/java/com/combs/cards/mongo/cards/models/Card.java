package com.combs.cards.mongo.cards.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public class Card {

    @Id
    private String _id;
    private String sport;
    private String year;
    private String manufacturer;
    private String subSet;
    private String firstName;
    private String lastName;
    private BigDecimal psaValue;

    public Card(String _id, String year, String sport, String manufacturer, String subset, String firstName, String lastName, BigDecimal psaValue) {
        this._id = _id;
        this.year = year;
        this.sport = sport;
        this.manufacturer = manufacturer;
        this.subSet = subset;
        this.firstName = firstName;
        this.lastName = lastName;
        this.psaValue = psaValue;
    }

    public Card() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

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

    public String getSubSet() {
        return subSet;
    }

    public void setSubSet(String subSet) {
        this.subSet = subSet;
    }

    public BigDecimal getPsaValue() {
        return psaValue;
    }

    public void setPsaValue(BigDecimal psaValue) {
        this.psaValue = psaValue;
    }
}