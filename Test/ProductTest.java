import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    Product p1, p2, p3;

    @BeforeEach
    void setUp() {
        p1 = new Product("000001", "Skittles", "Test1", 2.99);
        p2 = new Product("000002", "Hershey's", "Test2", 1.50);
        p3 = new Product("000003", "Cane", "Test3", 9.90);
    }

    @Test
    void setID() {
        setUp();
        assertEquals("000001", p1.getID());
    }

    @Test
    void setName() {
        setUp();
        assertEquals("Skittles", p1.getName());
    }

    @Test
    void setDescription() {
        setUp();
        assertEquals("Test1", p1.getDescription());
    }

    @Test
    void setCost() {
        setUp();
        assertEquals(2.99, p1.getCost());
    }

    @Test
    void toCSV() {
        setUp();
        assertEquals("000001, Skittles, Test1, 2.99", p1.toCSV());
    }

    @Test
    void toJSON() {
        setUp();
        char DQ = '\u0022';
        assertEquals("{" + DQ + "ID" + DQ + ": " + DQ + "000001" + DQ + ", "
                + DQ + "name" + DQ + ": " + DQ + "Skittles" + DQ + ", "
                + DQ + "description" + DQ + ": " + DQ + "Test1" + DQ + ", "
                + DQ + "cost" + DQ + ": " + DQ + 2.99 + "}", p1.toJSON());
    }

    @Test
    void toXML() {
        setUp();
        assertEquals("<Product> \n" +
                " <ID>000001</ID> \n" +
                " <name>Skittles</name> \n" +
                " <description>Test1</description> \n" +
                " <cost>2.99</cost> \n" +
                "</Product>", p1.toXML());

    }

    @Test
    void testToString() {
        setUp();
        assertEquals("Product{" +
                "ID='" + "000001" + '\'' +
                ", name='" + "Skittles" + '\'' +
                ", description='" + "Test1" + '\'' +
                ", cost='" + "2.99" + '\'' +
                '}', p1.toString());
    }

    @Test
    void testEquals() {
        setUp();
        assertEquals(true, p1.equals(p1));
    }

    @Test
    void testHashCode() {
        setUp();
        assertEquals(116510067, p1.hashCode());
    }
}