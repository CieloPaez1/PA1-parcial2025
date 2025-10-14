package usecase;

import model.Piloto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.RepoPiloto;

import java.time.LocalDateTime;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class CrearPilotoTest {
    @Mock
    RepoPiloto repoPiloto;

    @Test
    public void CrearPiloto(){
        CrearPilotoUseCase pilotoUseCase=new CrearPilotoUseCase(repoPiloto);
        when (repoPiloto.validarPiloto("123456ABC")).thenReturn(false);
        when (repoPiloto.guardarPiloto(any(Piloto.class))).thenReturn(true);
        boolean resultado=pilotoUseCase.crearPiloto(UUID.randomUUID(),"Franco Colapinto","123456ABC", LocalDateTime.MIN);
    }
}
