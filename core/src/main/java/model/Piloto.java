package model;

import exception.ExceptionPiloto;

import java.time.LocalDateTime;

import java.util.UUID;

public class Piloto {
    private UUID licencia;
    private String nombre;
    private String documento;
    private LocalDateTime fecha_nacimiento;

    private Piloto(UUID licencia, String nombre, String documento, LocalDateTime fecha_nacimiento) {
        this.licencia = licencia;
        this.nombre = nombre;
        this.documento = documento;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    private static int getEdad(LocalDateTime fecha_nacimiento){
        int edad;
        if(fecha_nacimiento.getYear() > LocalDateTime.now().getYear()){
            edad = LocalDateTime.now().getYear() - fecha_nacimiento.getYear();
        }else{
            edad = LocalDateTime.now().getYear() - fecha_nacimiento.getYear() - 1;
        }
        return edad;
    }

    public static Piloto factory(UUID licencia, String nombre, String documento, LocalDateTime fecha_nacimiento) {
        if (licencia == null) {
            throw new ExceptionPiloto("ID no puede ser nulo");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new ExceptionPiloto("Nombre no puede ser nulo o vacío");
        }
        if (documento == null || documento.isBlank()) {
            throw new ExceptionPiloto("Documento no puede ser nulo o vacío");
        }
        if (fecha_nacimiento == null || fecha_nacimiento.isAfter(LocalDateTime.now())) {
            throw new ExceptionPiloto("Fecha de nacimiento no puede ser nula o en el futuro");
        }
        if (LocalDateTime.now().getYear() - fecha_nacimiento.getYear() < 18) {
            throw new ExceptionPiloto("El piloto debe ser mayor de edad");
        }

        return new Piloto(licencia, nombre, documento, fecha_nacimiento);
    }


}
