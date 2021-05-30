package Pract_16;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CardController {
    @Autowired
    private NewCard newCard;

    @PostMapping("/card")
    public void post(@RequestBody Card card) {
        newCard.addCard(card);
    }

    @GetMapping("/cards")
    public List<Card> getAll() {
        return newCard.getCards();
    }

    @DeleteMapping("/card/{id}")
    public void delete(@PathVariable UUID id) {
        newCard.deleteManufacture(id);
    }
}
