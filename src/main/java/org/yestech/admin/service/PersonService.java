/*
 *
 * Original Author:  Artie Copeland
 * Last Modified Date: $DateTime: $
 */
package org.yestech.admin.service;

import org.yestech.admin.objectmodel.Person;

import java.util.List;

/**
 * @author $Author: $
 * @version $Revision: $
 */
public interface PersonService {
    public List<Person> findAll();

    public void save(Person person);

    public void remove(int id);

    public Person find(int id);
}