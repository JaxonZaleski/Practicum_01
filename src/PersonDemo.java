import java.util.Scanner;

public class PersonDemo {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        SafeInputOBJ sio = new SafeInputOBJ(in);
        boolean done = false;

        Person boy = new Person("000001", "Bill", "Bailey", "Dr.", 1942);
        Person girl = new Person("000001", "Sally", "Smith", "Dr.", 1952);

        System.out.println(boy.fullName());
        System.out.println(girl.formalName());
        System.out.println(girl.toCSV());
        System.out.println(girl.getAge(2000));

        do {
            String id = sio.getNonZeroLenString("Enter your id");
            String firstName = sio.getNonZeroLenString("Enter your first name");
            String lastName = sio.getNonZeroLenString("Enter your lastName");
            String title = sio.getNonZeroLenString("Enter your title [Dr. Mr. Mrs.]");
            int YOB = sio.getRangedInt("Enter your year of birth", 1000, 9999);
            done = sio.getYNConfirm("Are you done? [Y/N]");
        } while (!done);
    }
}