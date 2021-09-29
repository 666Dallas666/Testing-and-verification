import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import ru.AllFunc;
import ru.Patient;
import ru.Patient1;
import ru.Service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Captor
    ArgumentCaptor<Patient> captor;
    @Captor
    ArgumentCaptor<Patient1> captor1;
    @Mock
    Service s;
    @Test
    void createpatient() {
        Patient patient = new Patient("Jeff", "Jefferson");
        s.createpatient(patient);
        Mockito.verify(s).createpatient(captor.capture());
        Patient captured = captor.getValue();
        assertEquals("Jefferson", captured.getLastName());
    }

    @Test
    void createpatient1() {
        Patient1 patient1 = new Patient1("Jeff", "Jefferson", 2);
        s.createpatient1(patient1);
        Mockito.verify(s).createpatient1(captor1.capture());
        Patient1 captured = captor1.getValue();
        assertEquals(2, captured.getPosition());
    }

    @Test
    void out(){
        Patient patient = new Patient("Jeff", "Jefferson");
        Patient1 patient1 = new Patient1("Jeff", "Jefferson", 2);
        s.createpatient(patient);
        s.createpatient1(patient1);
        Mockito.when(s.out()).thenReturn(List.of(patient, patient1));
        Assertions.assertEquals(2, s.out().size());
    }

    @Test
    void del(){
        List<AllFunc> list = new ArrayList<AllFunc>();
        Patient1 patient1 = new Patient1("Jeff", "Jefferson", 2);
        s.createpatient1(patient1);
        s.del();
        assertEquals(list, s.out());
    }
}