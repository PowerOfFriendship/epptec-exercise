package exercise;

import java.util.HashMap;
import java.util.Map;

public class PersonRepository {

    private final Map<String, Person> databaseOfPersons = new HashMap<>();

    public Person getPesonById(String id){
        return databaseOfPersons.get(id);
    }

    public void addPerson(Person person){
        databaseOfPersons.put(person.getId(), person);
    }

    public void deletePerson(String id) {
        databaseOfPersons.remove(id);
    }

    public boolean personExistsInDatabase(String id){
        return databaseOfPersons.containsKey(id);
    }
}
