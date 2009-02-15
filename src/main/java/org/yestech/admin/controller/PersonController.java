/*
 *
 * Original Author:  Artie Copeland
 * Last Modified Date: $DateTime: $
 */
package org.yestech.admin.controller;

import org.yestech.admin.objectmodel.Person;
import org.yestech.admin.service.PersonService;

import java.util.List;

/**
 * @author $Author: $
 * @version $Revision: $
 */
public class PersonController
{
    private PersonService service;
    private List<Person> persons;
    private Person person;
    private Integer id;

    public PersonController(PersonService service) {
        this.service = service;
    }

    public String execute() {
        this.persons = service.findAll();
        return "";
//        return Action.SUCCESS;
    }

    public String save() {
        this.service.save(person);
        this.person = new Person();
        return execute();
    }

    public String remove() {
        service.remove(id);
        return execute();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void prepare() throws Exception {
        if (id != null)
            person = service.find(id);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
