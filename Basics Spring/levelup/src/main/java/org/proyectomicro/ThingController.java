package org.proyectomicro;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.validation.constraints.Positive;

import java.util.List;
import java.util.Optional;

@Controller("/thing")
@ExecuteOn(TaskExecutors.IO)
public class ThingController {
    private final ThingRepository thingRepository;

    ThingController(ThingRepository thingRepository){
        this.thingRepository = thingRepository;
    }

    @Get("/{id}")
    Optional<Thing> get(long id){
        return thingRepository.findById(id);
    }

    @Get("/all")
    Iterable<Thing> getAll(){
        return thingRepository.findAll();
    }

    @Post("/create/{name}/{amount}")
    HttpResponse<Thing> create(String name, @Positive int amount){
        Thing thing = thingRepository.save(new Thing(name, amount));
        return HttpResponse.created(thing);
    }
}
