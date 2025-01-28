import java.util.Objects;

public class Person {

    private String ID = "";
    private String firstName = "";
    private String lastName = "";
    private String title = "";
    private int YOB = 0;



    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String fullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public String getAge() {
        int trash = 0;
        String age = "Your age is: ";

        return age + trash;
    }

    public String getAge(int year) {
        int trash = 0;
        String age = "Your calculated age is: ";

        trash = year - this.getYOB();
        return age + trash;

    }

    public String toCSV() {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    public String toJSON() {

        String retString = "";
        char DQ = '\u0022';

        retString = "{\"ID\"" + ": " + "\"" + this.getID() + "\"" + ", ";
        retString += "\"firstName\"" + ": " + "\"" + this.getFirstName() + "\"" +  ", ";
        retString += "\"lastName\"" + ": " + "\"" + this.getLastName() + "\"" + ", ";
        retString += "\"title\"" + ": " + "\"" + this.getTitle() + "\"" + ", ";
        retString += "\"YOB\"" + ": " + this.getYOB() + "}";

        return retString;
    }

    public String toXML() {
        String retString = ("<Person> \n" +
                " <ID>" + ID + "</ID> \n" +
                " <firstName>" + firstName + "</firstName> \n" +
                " <lastName>" + lastName + "</lastName> \n" +
                " <title>" + title + "</title> \n" +
                " <YOB>" + YOB + "</YOB> \n" +
                "</Person>");
        return retString;
    }


    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return YOB == person.YOB && Objects.equals(ID, person.ID) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, title, YOB);
    }
}
