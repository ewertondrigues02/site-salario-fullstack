package br.com.ewerton.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Example JPA entity.
 * <p>
 * To use it, get access to a JPA EntityManager via injection.
 * <p>
 * {@code
 *
 * @Inject EntityManager em;
 * <p>
 * public void doSomething() {
 * MyEntity entity1 = new MyEntity();
 * entity1.field = "field-1";
 * em.persist(entity1);
 * <p>
 * List<MyEntity> entities = em.createQuery("from MyEntity", MyEntity.class).getResultList();
 * }
 * }
 */
@Entity
public class Salario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String cbo;
    private String cargo;

    private BigDecimal salarioJunior;
    private BigDecimal salarioPleno;
    private BigDecimal salarioSenior;


    public Salario() {}

    public Salario(Long id, String cargo, String cbo, BigDecimal salarioJunior, BigDecimal salarioPleno, BigDecimal salarioSenior) {
        this.id = id;
        this.cargo = cargo;
        this.cbo = cbo;
        this.salarioJunior = salarioJunior;
        this.salarioPleno = salarioPleno;
        this.salarioSenior = salarioSenior;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCbo() {
        return cbo;
    }

    public void setCbo(String cbo) {
        this.cbo = cbo;
    }

    public BigDecimal getSalarioJunior() {
        return salarioJunior;
    }

    public void setSalarioJunior(BigDecimal salarioJunior) {
        this.salarioJunior = salarioJunior;
    }

    public BigDecimal getSalarioPleno() {
        return salarioPleno;
    }

    public void setSalarioPleno(BigDecimal salarioPleno) {
        this.salarioPleno = salarioPleno;
    }

    public BigDecimal getSalarioSenior() {
        return salarioSenior;
    }

    public void setSalarioSenior(BigDecimal salarioSenior) {
        this.salarioSenior = salarioSenior;
    }


    @Override
    public String toString() {
        return "Salario{" +
                "id=" + id +
                ", cargo='" + cargo + '\'' +
                ", cbo='" + cbo + '\'' +
                ", salarioJunior=" + salarioJunior +
                ", salarioPleno=" + salarioPleno +
                ", salarioSenior=" + salarioSenior;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salario salario = (Salario) o;
        return Objects.equals(getId(), salario.getId()) && Objects.equals(getCargo(), salario.getCargo()) && Objects.equals(getCbo(), salario.getCbo()) && Objects.equals(getSalarioJunior(), salario.getSalarioJunior()) && Objects.equals(getSalarioPleno(), salario.getSalarioPleno()) && Objects.equals(getSalarioSenior(), salario.getSalarioSenior());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCargo(), getCbo(), getSalarioJunior(), getSalarioPleno(), getSalarioSenior());
    }
}
