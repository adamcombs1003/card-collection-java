package com.combs.cards.mongo.cards;

import com.combs.cards.mongo.cards.models.Card;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CardsController {

    private final CardsRepository cardsRepository;

    CardsController(CardsRepository cardsRepository){
        this.cardsRepository = cardsRepository;
    }

    @GetMapping("/cards")
    public ResponseEntity<List<Card>> getCards() {
        List<Card> cards;
        try {
            cards = cardsRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping("/cards/{id}")
    public ResponseEntity<Card> getCard(@PathVariable String id) {
        if (cardsRepository.findById(id).isPresent()) {
            return new ResponseEntity<>(cardsRepository.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/cards/add")
    public ResponseEntity<HttpStatus> addCard(@RequestBody Card addCardRequest) {
        try {
            cardsRepository.insert(addCardRequest);
        } catch(Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/cards/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCard(@PathVariable String id) {
        try {
            if (cardsRepository.findById(id).isPresent()){
                cardsRepository.deleteById(cardsRepository.findById(id).get().get_id());
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/cards/update")
    public ResponseEntity<HttpStatus> putCard(@RequestBody Card updateCardRequest) {
        try {
            if (cardsRepository.findById(updateCardRequest.get_id()).isPresent()){
                cardsRepository.save(updateCardRequest);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
