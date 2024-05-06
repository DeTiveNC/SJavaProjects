package com.detivenc.controller;

import com.detivenc.model.Client;
import com.detivenc.service.ClientService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.Optional;

@Path("/api/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientController {
    @Inject
    ClientService clientService;

    @POST
    @Path("/create")
    public Response saveClient(@RequestBody Client client){
        if (clientService.saveOrUpdateClient(client)) return Response.ok(client).build();
        else return Response.noContent().build();
    }

    @GET
    @Path("/all")
    public Response findAllClients(){
        return Response.ok(clientService.findAll()).build();
    }

    @GET
    @Path("/get/{id}")
    public Response findClientById(@PathParam("id") Long id){
        Optional<Client> client = clientService.findById(id);
        if(client.isPresent()) {
            return Response.ok(client.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build(); // 404 Not Found
        }
    }

    @GET
    @Path("/{name}")
    public Response findClientByName(@PathParam("name") String name){
        Optional<Client> clientbyName = clientService.findByName(name);
        return clientbyName.isPresent() ? Response.ok(clientbyName.get()).build()
                : Response.noContent().build();
    }

    @PUT
    @Path("/update")
    public Response updateClient(@RequestBody Client client){
        if(clientService.saveOrUpdateClient(client)) return Response.ok(client).build();
        else return Response.notModified().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") Long id){
        if(clientService.deleteClient(id)) return Response.ok().build();
        else return Response.noContent().build();
    }


}
