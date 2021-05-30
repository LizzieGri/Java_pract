package Pract_15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BankController {
    @Autowired
    private NewBank newBank;

    @PostMapping("/bank")
    public void post(@RequestBody Bank bank) {
        newBank.addBank(bank);
    }

    @GetMapping("/banks")
    public List<Bank> getAll() {
        return newBank.getBanks();
    }



    @DeleteMapping("/bank/{id}")
    public void delete(@PathVariable UUID id) {
        newBank.delete(id);
    }
}
