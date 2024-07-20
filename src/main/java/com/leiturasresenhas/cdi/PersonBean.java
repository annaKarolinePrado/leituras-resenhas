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
    private Person selectedPerson;

    @Inject
    private PersonService personService;

    public void save() {
        personService.savePerson(person);
        person = new Person();
    }

    public Person getPerson() {
        return person;
    }

    public void edit(Person person) {
        this.selectedPerson = person;
        this.person = new Person(person); // Cria uma cópia do objeto para edição
    }

    public void delete(Person person) {
        personService.deletePerson(person); // Adicione este método ao seu service
       // persons = personService.list(); // Atualiza a lista
    }

    public Person getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }


    public List<Person> getPersons() {
        return personService.list();
    }
    public void setPerson(Person person) {
        this.person = person;
    }
}