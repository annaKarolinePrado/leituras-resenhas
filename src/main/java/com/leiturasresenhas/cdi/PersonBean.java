package com.leiturasresenhas.cdi;

import com.leiturasresenhas.ejb.PersonService;
import com.leiturasresenhas.model.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PersonBean {
    private Person person = new Person();
    private String searchTerm = "";
    private List<Person> filteredPersons;

    @Inject
    private PersonService personService;

    public void save() {
        System.out.println(person.getId());
        if (person.getId() == null) {
            personService.savePerson(person);
        } else {
            personService.updatePerson(person);
        }
        person = new Person();
        loadPersons();
    }

    public Person getPerson() {
        return person;
    }

    public void edit(Person person) {
        this.person = new Person(person);
    }

    public void delete(Person person) {
        personService.deletePerson(person);
        loadPersons();
    }

    public void cancel() {
        person = new Person();
    }

    public List<Person> getPersons() {
        if (filteredPersons == null) {
            loadPersons();
        }
        return filteredPersons;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void search() {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            loadPersons();
        } else {
            filteredPersons = personService.search(searchTerm);
        }
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    private void loadPersons() {
        filteredPersons = personService.list();
    }
}
