package Pract_14;

import java.util.ArrayList;
import java.util.List;

public class NewBank {
    private List<Bank> banks;

    public NewBank() {
        banks = new ArrayList<>();
        create();
    }

    private void create() {
        banks.add(new Bank("MyBank", "MyStreet 10"));
        banks.add(new Bank("NotMyBank", "NotMyStreet 20"));
    }

    public void add(Bank bank) {
        banks.add(bank);
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void deleteBank(Bank bank) {
        banks.remove(bank);
    }
}
