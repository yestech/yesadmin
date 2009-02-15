/*
 *
 * Original Author:  Artie Copeland
 * Last Modified Date: $DateTime: $
 */
package org.yestech.admin.service;

import org.yestech.admin.objectmodel.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author $Author: $
 * @version $Revision: $
 */
@Transactional
public class PersonServiceImpl implements PersonService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Person> findAll() {
        Query query = getEntityManager().createQuery("select p FROM Person p");
        return query.getResultList();
    }

    public void save(Person person) {
        if (person.getId() == null) {
            // new
            em.persist(person);
        } else {
            // update
            em.merge(person);
        }
    }

    public void remove(int id) {
        Person person = find(id);
        if (person != null) {
            em.remove(person);
        }
    }

    private EntityManager getEntityManager() {
        return em;
    }

    public Person find(int id) {
        return em.find(Person.class, id);
    }

}