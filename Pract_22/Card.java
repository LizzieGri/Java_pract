package Pract_22;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Card")
public class Card {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "cardNumber")
    @NotNull
    private String cardNumber;

    @Column(name = "code")
    @NotNull
    private String code;

    public Card(){}

    public Card(String cardNumber, String code) {
        this.cardNumber = cardNumber;
        this.code = code;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCode() {
        return code;
    }
}
