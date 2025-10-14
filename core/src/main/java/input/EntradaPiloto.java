package input;

import exception.ExceptionPiloto;

import java.time.LocalDateTime;
import java.util.UUID;

public interface EntradaPiloto {
    UUID crearPiloto(UUID licencia ,String nombre,String documento, LocalDateTime fecha_nacimiento) throws ExceptionPiloto;


}
