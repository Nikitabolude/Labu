package labs.lab2;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @Test
    void testEquals() {
        EqualsVerifier.forClass(Person.class).verify();

        Person person = new Person("Michael", "Canada", 23);
        assertEquals(person, Person.fromJson(Person.toJson(person)));
    }
}
