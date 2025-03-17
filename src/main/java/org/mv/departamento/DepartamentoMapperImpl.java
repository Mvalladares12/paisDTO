package org.mv.departamento;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.mv.municipio.CreateMunicipioDTO;
import org.mv.municipio.Municipio;
import org.mv.municipio.MunicipioMapper;

@RequestScoped
public class DepartamentoMapperImpl implements DepartamentoMapper {

    @Inject
    DepartamentoRepository departamento;

    @Override
    public Departamento createDepartamento(CreateDepartamentoDTO dto) {
        Departamento departamento=new Departamento();
        departamento.setNombre(dto.nombre());
        departamento.setCodigo(dto.codigo());
        return departamento;
    }
}
