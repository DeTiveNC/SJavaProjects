package org.proyectomicro;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class ThingRepositoryTest {

    @Inject
    ThingRepository thingRepository;

    @Test
    void testCreate(){

        System.out.println(thingRepository.getClass().getName());

        long startCount = thingRepository.count();

        thingRepository.save(new Thing("widget",42));
        thingRepository.saveAll(List.of(
                new Thing("t1", 1),
                new Thing("t2", 2),
                new Thing("t3", 3)
        ));

        assertEquals (startCount + 4,thingRepository.count());
        for (Thing t : thingRepository.findAll()){
            System.out.println(t);
        }
    }

    @Test
    void testFindByName(){
        thingRepository.save(new Thing("by_name", 123));

        Optional<Thing> thing = thingRepository.findByName("by_name");
        assertTrue(thing.isPresent());
        assertEquals(123, thing.get().amount());

        assertFalse(thingRepository.findByName("assasaswdadwda").isPresent());
    }
}
