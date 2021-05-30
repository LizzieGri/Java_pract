package Pract_14;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    @Autowired
    private NewCard newCard;

    @PostMapping("/postCards")
    public void post(@RequestBody Card card) {
        newCard.add(card);
    }

    @GetMapping("/getCards")
    public List<Card> getCards() {
        return newCard.getCards();
    }

    @DeleteMapping("/deleteBank")
    public void deleteCard(@RequestBody Card card) {
        newCard.deleteCard(card);
    }
}
