package com.combs.cards.mongo.cards.models;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Card {

    @Id
    private UUID id;
    private String sport;
    private String year;
    private String manufacturer;
    private String firstName;
    private String lastName;
    private BigDecimal psaValue;

    public Card(UUID id, String sport, String year, String manufacturer, String firstName, String lastName, BigDecimal psaValue) {
        this.id = id;
        this.sport = sport;
        this.year = year;
        this.manufacturer = manufacturer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.psaValue = psaValue;
    }

    public Card() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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

    public BigDecimal getPsaValue() {
        return psaValue;
    }

    public void setPsaValue(BigDecimal psaValue) {
        this.psaValue = psaValue;
    }
}