package input;

import exception.ExceptionPiloto;

import java.time.LocalDateTime;
import java.util.UUID;

public interface EntradaPiloto {
    UUID registrarPiloto(UUID licencia ,String nombre, LocalDateTime fecha_nacimiento) throws ExceptionPiloto;
}
