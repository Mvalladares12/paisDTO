package org.mv.distrito;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/distrito")
public class DistritoResource {

    @Inject
    DistritoRepository distritoRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Distrito> findAll() {
        return distritoRepository.listAll();
    }

    @GET
    @Path("{id}")
    public Distrito getDep(@PathParam("id") Long id) {
        return distritoRepository.findById(id);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Distrito distrito) {
        distritoRepository.persist(distrito);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id){
        distritoRepository.deleteById(id);
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Distrito update(@PathParam("id")Long id, Distrito distrito) {
        var entity = distritoRepository.findById(id);
        if (entity != null) {
            entity.setCodigo(distrito.getCodigo());
            entity.setNombre(distrito.getNombre());
            distritoRepository.persist(entity);
            return entity;
        }else {
            throw new NotFoundException();
        }
    }
}
