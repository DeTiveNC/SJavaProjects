package com.detivenc.repository;

import com.detivenc.model.Client;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class ClientRepository implements PanacheRepository<Client> {
    public Optional<Client> findByNameOptional(String name){
        return find("name",name).firstResultOptional();
    }
}
