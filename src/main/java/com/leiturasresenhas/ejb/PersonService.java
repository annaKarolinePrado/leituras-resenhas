package com.leiturasresenhas.ejb;

import com.leiturasresenhas.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonService {
    @PersistenceContext(unitName = "leituras-resenhasPU")
    private EntityManager em;

    public void savePerson(Person person) {
        em.persist(person);
    }

    public List<Person> list() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    public void deletePerson(Person person) {
        em.createQuery("DELETE FROM Person WHERE ID = "+person.getId());
    }
}