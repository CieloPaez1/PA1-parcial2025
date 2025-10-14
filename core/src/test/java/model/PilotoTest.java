package model;
import exception.ExceptionPiloto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.util.UUID;


public class PilotoTest {
    @Test
    public void FactoryTrue(){
        Piloto piloto = Piloto.factory(UUID.randomUUID(),"Franco Colapinto","123456ABC", LocalDateTime.MIN);
        Assertions.assertNotNull(piloto);



    }
    @Test
    public void FactoryFalse(){
        Assertions.assertThrows(Exception.class, () -> {Piloto.factory(null,"Franco Colapinto","123456ABC", LocalDateTime.MIN);});
        Assertions.assertThrows(Exception.class, () -> {Piloto.factory(UUID.randomUUID(),null,"123456ABC", LocalDateTime.MIN);});
        Assertions.assertThrows(Exception.class, () -> {Piloto.factory(UUID.randomUUID(),"","123456ABC", LocalDateTime.MIN);});
        Assertions.assertThrows(Exception.class, () -> {Piloto.factory(UUID.randomUUID(),"Franco Colapinto","", LocalDateTime.MIN);});
        Assertions.assertThrows(Exception.class, () -> {Piloto.factory(UUID.randomUUID(),"Franco Colapinto",null, LocalDateTime.MIN);});
        Assertions.assertThrows(Exception.class, () -> {Piloto.factory(UUID.randomUUID(),"Franco Colapinto","123456ABC", null);});
        Assertions.assertThrows(Exception.class, () -> {Piloto.factory(UUID.randomUUID(),"Franco Colapinto","123456ABC", LocalDateTime.MAX);});
    }
}
