package client.test;

import exception.ClientAlreadyExistsException;
import org.junit.Test;
import org.mockito.Mockito;

public class ClientServiceTest {

    @Test(expected = ClientAlreadyExistsException.class)
    public void shouldThrowExceptionForExistingClient(){
        Mockito.when(client.ClientService).thenReturn(0);
    }
    }
}
