package utilisationmock;


import org.example.jour4.correctionconnectedfridge.utilisationmock.Repository;
import org.example.jour4.correctionconnectedfridge.utilisationmock.Service;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ServiceTest {

    @Test
    public void testGetData() {
        //Arange
        /*Repository repository = Mockito.mock(Repository.class);
        when(repository.findDataById(1)).thenReturn("mocked data 1");
        //when(repository.findDataById(2)).thenReturn("mocked data 2");
        //when(repository.findDataById(anyInt())).thenThrow(new RuntimeException(""));
        when(repository.findDataById(1)).thenAnswer(invocation -> {
            int id = invocation.getArgument(0);
            return "mocked data "+ id;
        });*/
        Repository realRepository = new Repository();
        Repository spyRepository = spy(realRepository);
        when(spyRepository.findDataById(1)).thenReturn("mocked data 1");
        Service service = new Service(spyRepository);

        String result = service.getData(1);

        assertEquals("MOCKED DATA 1", result);

    }
}
