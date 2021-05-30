package Pract_14;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankController {
    @Autowired
    private NewBank newBank;

    @PostMapping("/postBanks")
    public void post(@RequestBody Bank bank) {
        newBank.add(bank);
    }

    @GetMapping("/getBanks")
    public List<Bank> getBanks() {
        return newBank.getBanks();
    }

    @DeleteMapping("/deleteBank")
    public void deleteBank(@RequestBody Bank bank) {
        newBank.deleteBank(bank);
    }
}
