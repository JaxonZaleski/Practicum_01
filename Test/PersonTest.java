import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person p1, p2, p3;

    @BeforeEach
    void setUp() {
        p1 = new Person("000001", "Jay", "Test1", "Dr.", 1833);
        p2 = new Person("000002", "Bob", "Test2", "Prof.", 1942);
        p3 = new Person("000003", "Joe", "Test3", "Esq.", 1122);
    }

    @Test
    void setID() {
        setUp();
        assertEquals("000002", p2.getID());
    }

    @Test
    void setFirstName() {
        setUp();
        assertEquals("Bob", p2.getFirstName());
    }

    @Test
    void setLastName() {
        setUp();
        assertEquals("Test2", p2.getLastName());
    }

    @Test
    void setTitle() {
        setUp();
        assertEquals("Prof.", p2.getTitle());
    }

    @Test
    void setYOB() {
        setUp();
        assertEquals(1942, p2.getYOB());
    }

    @Test
    void fullName() {
        setUp();
        assertEquals("Bob Test2", p2.fullName());
    }

    @Test
    void formalName() {
        setUp();
        assertEquals("Prof. Bob Test2", p2.formalName());
    }

    @Test
    void toCSV() {
        setUp();
        assertEquals("000002, Bob, Test2, Prof., 1942", p2.toCSV());
    }

    @Test
    void toJSON() {
        setUp();
        char DQ = '\u0022';
        assertEquals("{" + DQ + "ID" + DQ + ": " + DQ + "000002" + DQ + ", "
                + DQ + "firstName" + DQ + ": " + DQ + "Bob" + DQ + ", "
                + DQ + "lastName" + DQ + ": " + DQ + "Test2" + DQ + ", "
                + DQ + "title" + DQ + ": " + DQ + "Prof." + DQ + ", "
                + DQ + "YOB" + DQ + ": " + 1942 + "}", p2.toJSON());
    }

    @Test
    void toXML() {
        p1.setID("000002");
        p1.setFirstName("Bob");
        p1.setLastName("Test2");
        p1.setTitle("Prof.");
        p1.setYOB(1942);
        assertEquals("<Person> \n" +
                " <ID>000002</ID> \n" +
                " <firstName>Bob</firstName> \n" +
                " <lastName>Test2</lastName> \n" +
                " <title>Prof.</title> \n" +
                " <YOB>1942</YOB> \n" +
                "</Person>", p1.toXML());
    }

    @Test
    void testToString() {
        setUp();
        assertEquals("Person{" +
                "ID='" + "000002" + '\'' +
                ", firstName='" + "Bob" + '\'' +
                ", lastName='" + "Test2" + '\'' +
                ", title='" + "Prof." + '\'' +
                ", YOB=" + 1942 +
                '}', p2.toString());
    }

    @Test
    void testEquals() {
        setUp();
        assertEquals(true, p2.equals(p2));
    }

    @Test
    void testHashCode() {
        setUp();
        assertEquals(1790003213, p2.hashCode());
    }
}