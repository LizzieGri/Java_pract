package Pract_14;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewCard {
    private List<Card> cards;

    public NewCard() {
        cards = new ArrayList<>();
        create();
    }

    private void create() {
        cards.add(new Card("6395 2270 5521 0736", "381"));
        cards.add(new Card("1349 4567 0987 0345", "645"));
    }

    public void add(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void deleteCard(Card card) {
        cards.remove(card);
    }
}
