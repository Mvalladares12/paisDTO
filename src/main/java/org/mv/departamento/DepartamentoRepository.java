package org.mv.departamento;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DepartamentoRepository implements PanacheRepository<Departamento> {
}
