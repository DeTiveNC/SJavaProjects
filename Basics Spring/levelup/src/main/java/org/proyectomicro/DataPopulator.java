package org.proyectomicro;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

import java.util.List;

import static io.micronaut.context.env.Environment.TEST;
@Singleton
@Requires(notEnv = TEST)
public class DataPopulator {
    private final ThingRepository thingRepository;

    DataPopulator(ThingRepository thingRepository) {
        this.thingRepository = thingRepository;
    }

    @EventListener
    @Transactional
    void init(StartupEvent event){
        if (thingRepository.count() == 0){
            thingRepository.saveAll(List.of(
                    new Thing("oceans", 5),
                    new Thing("countries", 195),
                    new Thing("continents", 7)
            ));
        }
    }
}
