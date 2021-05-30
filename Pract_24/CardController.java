package Pract_24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class CardController {

    @Autowired
    private CardService cardService;
    private EmailService mail;
    @GetMapping("/cards")
    public List<Card> getAll() {
        mail.SendEmail();
        return cardService.getCards();
    }

    @GetMapping("/getByCardNumber/{cardNumber}")
    public List<Card> getByCardNumber(@PathVariable String cardNumber){
        return cardService.getByCardNumber(cardNumber);
    }

    @GetMapping
    public List<Card> getByCode(@PathVariable String code) {
        return cardService.getByCode(code);
    }

    @DeleteMapping("/card/{id}")
    public void delete(@PathVariable UUID id) {
        cardService.deleteCard(id);
    }
}
