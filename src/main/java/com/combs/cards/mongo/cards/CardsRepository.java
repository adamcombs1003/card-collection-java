package com.combs.cards.mongo.cards;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.combs.cards.mongo.cards.models.Card;

public interface CardsRepository extends MongoRepository<Card, String> {
    
}
