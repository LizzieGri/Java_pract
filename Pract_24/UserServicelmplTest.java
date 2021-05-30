package Pract_24;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class UserServicelmplTest {
    @Mock
    private UserRepository userRepository;

    @Test
    public void getGame() {
        userRepository=mock(UserRepository.class);
        User user = new User();
        user.setUsername("uOne");
        User user1 = new User();
        user1.setUsername("uTwo");
        Mockito.when(userRepository.findAll()).thenReturn(Arrays.asList(user,user1));
        UserService userService = new UserService(userRepository);
        Assertions.assertEquals(2, userService.allUsers().size());
        Assertions.assertEquals("uOne",
                userService.allUsers().get(0).getUsername());
    }
}
