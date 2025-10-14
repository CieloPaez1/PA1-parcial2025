package usecase;

import exception.ExceptionPiloto;
import input.EntradaPiloto;
import model.Piloto;
import output.RepoPiloto;

import java.time.LocalDateTime;
import java.util.UUID;

public class RegistrarPiloto implements EntradaPiloto {
    private final RepoPiloto repoPiloto;


    public RegistrarPiloto(RepoPiloto repoPiloto) {
        this.repoPiloto = repoPiloto;
    }

    @Override
    public UUID registrarPiloto(UUID licencia, String nombre, String documento, LocalDateTime fecha_nacimiento)  {
        Piloto piloto = Piloto.factory(licencia, nombre, documento, fecha_nacimiento);
        if (repoPiloto.validarPiloto(piloto.getDocumento()))
            throw new ExceptionPiloto("El piloto ya existe");

        if (!repoPiloto.guardarPiloto(piloto)) {
            throw new ExceptionPiloto("Error al guardar el piloto.");
        }
        return piloto.getLicencia();
    }

}
