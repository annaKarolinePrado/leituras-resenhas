package com.leiturasresenhas.ejb;

import com.leiturasresenhas.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonService {

    @PersistenceContext
    private EntityManager em;

    public void savePerson(Person person) {
        em.persist(person);
    }

    public void updatePerson(Person person) {
        em.merge(person);
    }

    public void deletePerson(Person person) {
        em.remove(em.contains(person) ? person : em.merge(person));
    }

    public List<Person> list() {
        return em.createQuery("SELECT p FROM Person p ORDER BY p.name ASC", Person.class).getResultList();
    }

    public List<Person> search(String searchTerm) {
        return em.createQuery("SELECT p FROM Person p WHERE p.name LIKE :searchTerm", Person.class)
                .setParameter("searchTerm", "%" + searchTerm + "%")
                .getResultList();
    }
}
