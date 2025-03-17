package org.mv.municipio;

import jakarta.enterprise.context.RequestScoped;
import org.mv.departamento.Departamento;
import org.mv.departamento.DepartamentoRepository;

@RequestScoped
public class MunicipioMapperImpl implements MunicipioMapper {

    DepartamentoRepository muni;
    @Override
    public Municipio createMunicipio(CreateMunicipioDTO dto) {
        Municipio municipio=new Municipio();
        Departamento departamento=muni.findById(dto.getIdDepartamento());
        municipio.setIdDepartam(departamento);
        municipio.setNombre(dto.nombre());
        municipio.setCodigo(dto.codigo());
        return municipio;
    }
}
