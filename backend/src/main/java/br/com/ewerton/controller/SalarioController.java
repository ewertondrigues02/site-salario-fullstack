package br.com.ewerton.controller;

import br.com.ewerton.domain.Salario;
import br.com.ewerton.service.SalarioService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/salarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SalarioController {

    @Inject
    SalarioService service;

    @GET
    @Path("/allcbo")
    public Response getAllCbo() {
        List<Salario> salarios = service.listarTodos();
        return Response.ok(salarios).build();
    }

    @GET
    public Response listarTodos() {
        List<Salario> salarios = service.listarTodos();
        return Response.ok(salarios).build();
    }

}
