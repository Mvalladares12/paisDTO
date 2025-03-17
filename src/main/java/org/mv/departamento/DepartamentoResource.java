package org.mv.departamento;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/departamento")
public class DepartamentoResource {


    DepartamentoRepository departamentoRepository;

    DepartamentoMapper departamentoMapper;

    @Inject
    public DepartamentoResource(DepartamentoRepository departamentoRepository, DepartamentoMapper departamentoMapper) {
        this.departamentoRepository = departamentoRepository;
        this.departamentoMapper = departamentoMapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Departamento> findAll() {
        return departamentoRepository.listAll();
    }

    @GET
    @Path("{id}")
    public Departamento getDep(@PathParam("id") Long id) {
        return departamentoRepository.findById(id);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(CreateDepartamentoDTO departamento) {
        var entity=departamentoMapper.createDepartamento(departamento);
        departamentoRepository.persist(entity);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id){
        departamentoRepository.deleteById(id);
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Departamento update(@PathParam("id")Long id, Departamento departamento) {
        var entity = departamentoRepository.findById(id);
        if (entity != null) {
            entity.setCodigo(departamento.getCodigo());
            entity.setNombre(departamento.getNombre());
            departamentoRepository.persist(entity);
            return entity;
        }else {
            throw new NotFoundException();
        }
    }
}
