package usecase;

import exception.ExceptionPiloto;
import exception.PilotoExisteException;
import input.EntradaPiloto;
import model.Piloto;
import output.RepoPiloto;

import java.time.LocalDateTime;
import java.util.UUID;

public class CrearPiloto implements EntradaPiloto {
    private final RepoPiloto repoPiloto;


    public CrearPiloto(RepoPiloto repoPiloto) {
        this.repoPiloto = repoPiloto;
    }

    @Override
    public UUID crearPiloto(UUID licencia, String nombre, String documento, LocalDateTime fecha_nacimiento) throws ExceptionPiloto {
       Piloto piloto= Piloto.factory(licencia,nombre,documento,fecha_nacimiento);
        if (repoPiloto.validarPiloto(piloto.getDocumento()) ) {
            throw new PilotoExisteException("ElPiloto ya existe");

        }
        if (!repoPiloto.guardarPiloto(piloto)) {
            throw new PilotoExisteException("Error al guardar el piloto.");
        }

        return piloto.getLicencia();
    }



}
