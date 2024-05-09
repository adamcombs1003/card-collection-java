package com.combs.cards.mongo.cards;

import com.combs.cards.mongo.cards.models.AddCardRequest;
import com.combs.cards.mongo.cards.models.Card;
import com.combs.cards.mongo.cards.models.CardListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CardsController {

    private final CardsRepository cardsRepository;

    CardsController(CardsRepository cardsRepository){
        this.cardsRepository = cardsRepository;
    }

    @GetMapping("/cards")
    public ResponseEntity<CardListResponse> getCards() {
        CardListResponse cards;
        try {
            cards = new CardListResponse(cardsRepository.findAll());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
    
    @PostMapping("/cards/add")
    public ResponseEntity<HttpStatus> addCard(@RequestBody AddCardRequest addCardRequest) {
        try {
            Card card = new Card();
            card.setId(UUID.randomUUID());
            card.setFirstName(addCardRequest.getFirstName());
            card.setLastName(addCardRequest.getLastName());
            card.setYear(addCardRequest.getYear());
            card.setSport(addCardRequest.getSport());
            card.setManufacturer(addCardRequest.getManufacturer());
            card.setPsaValue(addCardRequest.getPsaValue());
            cardsRepository.insert(card);
        } catch(Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/cards/remove")
    public ResponseEntity<HttpStatus> deleteCard(@RequestParam UUID id) {
        try {
            Optional<Card> card = cardsRepository.findById(id);
            if (card.isPresent()){
                cardsRepository.deleteById(id);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/cards/update")
    public ResponseEntity<HttpStatus> putCard(@RequestBody Card card) {
        try {
            cardsRepository.save(card);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
