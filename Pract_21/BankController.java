package Pract_21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class BankController {

    @Autowired
    public BankService bankService;

    @GetMapping("/getByName/{name}")
    public List<Bank> getByName(@PathVariable String name){
        return bankService.getByName(name);
    }

    @GetMapping("/getByAddress/{address}")
    public List<Bank> getByAddress(@PathVariable String address){
        return bankService.getByAddress(address);
    }

    @DeleteMapping("/bank/{id}")
    public void delete(@PathVariable UUID id) {
        bankService.deleteBank(id);
    }
}