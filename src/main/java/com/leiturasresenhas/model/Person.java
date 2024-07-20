package com.leiturasresenhas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private String cpf;

    private Integer matricula;

    public Person() {
    }

    public Person(Long id, String name, String cpf, Integer matricula) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.matricula = matricula;
    }

    public Person(Person person) {
        this.name = person.getName();
        this.cpf = person.getCpf();
        this.matricula = person.getMatricula();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
}