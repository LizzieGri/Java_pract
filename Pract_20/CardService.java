package Pract_20;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class CardService {

    @Autowired
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getByCardNumber(String cardNumber) {
        return cardRepository.findAllByCardNumber(cardNumber);
    }

    public List<Card> getByCode(String code) {
        return cardRepository.findAllByCode(code);
    }

    public void deleteCard(UUID id) {
        cardRepository.deleteById(id);
    }
}
