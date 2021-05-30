package Pract_24;

import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;


@ExtendWith(MockitoExtension.class)
public class BankServicelmplTest {

    @Mock
    private BankRepository bankRepository;
    @Test
    public void getBank() {
        bankRepository=mock(BankRepository .class);
        Bank bank = new Bank();
        bank.setName("Raffaz");
        Bank bank1 = new Bank();
        bank1.setName("Tinkon");
        Mockito.when(bankRepository.findAll()).thenReturn(Arrays.asList(bank, bank1));
        BankService userService = new BankService(bankRepository);
        Assertions.assertEquals(2, userService.getBanks().size());
        Assertions.assertEquals("Raffaz",
                userService.getBanks().get(0).getName());
    }
}
