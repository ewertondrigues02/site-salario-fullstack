package br.com.ewerton.service;

import br.com.ewerton.domain.Salario;
import br.com.ewerton.repository.SalarioRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class SalarioService {

    @Inject
    SalarioRepository salario;

    public List<Salario> listarTodos() {
        return salario.listAll();
    }

}
