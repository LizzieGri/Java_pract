package Pract_17;

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

    @GetMapping("/filteredByYear")
    public List<Card> getFilteredByCardNumber(){
        return newCard.filterByCardNumber();
    }

    @GetMapping("/filteredByCode")
    public List<Card> getFilteredByCode(){
        return newCard.filterByCode();
    }
}
