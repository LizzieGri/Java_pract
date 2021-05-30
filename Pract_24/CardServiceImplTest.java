package Pract_24;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class CardServiceImplTest {
    @Mock
    private CardRepository cardRepository;

    @Test
    public void getGame() {
        cardRepository=mock(CardRepository.class);
        Card card = new Card();
        card.setCardNumber("2934 6293 6492 3469");
        Card card1 = new Card();
        card1.setCardNumber("0837 1087 3857 2983");
        Mockito.when(cardRepository.findAll()).thenReturn(Arrays.asList(card,card1));
        CardService userService = new CardService(cardRepository);
        Assertions.assertEquals(2, userService.getCards().size());
        Assertions.assertEquals("2934 6293 6492 3469",
                userService.getCards().get(0).getCardNumber());
    }
}
