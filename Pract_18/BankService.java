package Pract_18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BankService {

    @Autowired
    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<Bank> getByAddress(String address) {
        return bankRepository.findAllByAddress(address);
    }

    public List<Bank> getByName(String name) {
        return bankRepository.findAllByName(name);
    }

    public void deleteBank(UUID id) {
        bankRepository.deleteById(id);
    }
}
