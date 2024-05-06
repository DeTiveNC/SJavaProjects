package com.detivenc.service;

import com.detivenc.model.Client;
import com.detivenc.repository.ClientRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class ClientService {
    @Inject
    ClientRepository clientRepository;
    public List<Client> findAll() {
        return clientRepository.findAll().stream().toList();
    }

    public Optional<Client> findById(Long id){
        return clientRepository.findByIdOptional(id);
    }

    public Optional<Client> findByName(String name){
        return clientRepository.findByNameOptional(name);
    }

    public boolean deleteClient(Long id){
        clientRepository.deleteById(id);
        return true;
    }
    // Always remember watch out with the ID on quarkus
    public boolean saveOrUpdateClient(Client client) {
        if (client.getId() == null || client.getId() == 0 || !clientRepository.findByIdOptional(client.getId()).isPresent()) {
            client.setId(null);
            clientRepository.persist(client);
        } else {
            clientRepository.getEntityManager().merge(client);
        }
        return true;
    }
}
