package Pract_16;

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

    @ManyToOne
    public Bank bank;

    public Bank getBank() {
        return bank;
    }
}
