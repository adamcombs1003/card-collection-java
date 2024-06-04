package com.combs.cards.mongo.cards.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public record Card(@Id String _id,
                   String year,
                   String sport,
                   String manufacturer,
                   String subset,
                   String firstName,
                   String lastName,
                   BigDecimal psaValue) {}

