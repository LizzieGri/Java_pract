package Pract_24;

import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("BankRepository")
public interface BankRepository extends JpaRepository<Bank, Long> {
    List<Bank> findAllByAddress(String address);
    List<Bank> findAllByName(String name);
    List<Bank> findAllByAddressAndName(String address, String name);
    @NotNull
    List<Bank> findAll();
    void deleteById(UUID id);
}
