package com.combs.cards.mongo.cards.models;

import java.util.List;

public class CardListResponse {

    private List<Card> cardList;

    public CardListResponse(List<Card> cardList) {
        this.cardList = cardList;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}
