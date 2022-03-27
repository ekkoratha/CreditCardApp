package com.ps.creditcardapp.controller;

import com.ps.creditcardapp.entity.Card;
import com.ps.creditcardapp.exceptions.CardNotFoundException;
import com.ps.creditcardapp.repository.CardRepository;
import com.ps.creditcardapp.utils.Validator;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {
    private final CardRepository repository;

    public CardController(CardRepository repository) {
        this.repository = repository;
    }

    @ApiOperation(value = "This method is used to get all card details.")
    @GetMapping("/GetAll")
    List<Card> all() {
        Iterable<Card> result = repository.findAll();

        return (List<Card>)result;
    }

    // in the requirements document the rest endpoint was "Get All" so added this one as well.
    @ApiOperation(value = "This method is used to get all card details.")
    @GetMapping("/Get All")
    List<Card> getAll() {
        return all();
    }

    @ApiOperation(value = "This method is used to create new card.")
    @PostMapping(path="/Add", consumes = MediaType.APPLICATION_JSON_VALUE)
    String newCard(@RequestBody Card newCard) {
        if(Validator.isValidLuhnNumber(newCard.getNumber())) {
            repository.save(newCard);
            return "New Card "+newCard.getId()+" added successfully.";
        }
        return "Card Number "+newCard.getNumber()+" invalid. Please check and try again.";
    }


    @ApiOperation(value = "This method is used to get card by \"id\".")
    @GetMapping("/cards/{id}")
    Card getCardById(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CardNotFoundException(id));
    }

    @ApiOperation(value = "This method is used to updated card details by \"id\".")
    @PutMapping("/cards/{id}")
    Card replaceCard(@RequestBody Card newCard, @PathVariable Long id) {

        return repository.findById(id)
                .map(card -> {
                    card.setName(newCard.getName());
                    card.setNumber(newCard.getNumber());
                    return repository.save(card);
                })
                .orElseGet(() -> {
                    newCard.setId(id);
                    return repository.save(newCard);
                });
    }

    @ApiOperation(value = "This method is used to delete card details by \"id\".")
    @DeleteMapping("/cards/{id}")
    String deleteCard(@PathVariable Long id) {
        // if incorrect id then throw an exception
        repository.findById(id)
                .orElseThrow(() -> new CardNotFoundException(id));

        repository.deleteById(id);

        return "Card id: "+ id + " deleted successfully";
    }
}
