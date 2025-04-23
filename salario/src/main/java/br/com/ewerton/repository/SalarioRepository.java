package br.com.ewerton.repository;

import br.com.ewerton.domain.Salario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SalarioRepository implements PanacheRepository<Salario> {
}

