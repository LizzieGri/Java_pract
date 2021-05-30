package Pract_18;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("CardRepository")
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findAllByCardNumber(String cardNumber);
    List<Card> findAllByCode(String code);
    List<Card> findAllByCardNumberAndCode(String cardNumber, String code);
    void deleteById(UUID id);
}
