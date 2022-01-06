import mvc.Group;
import mvc.Model;
import mvc.Student;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        Model model = new Model("D:\\myFiles\\study\\netCracker\\java\\infoSystem\\src\\student.json");

        /*model.load("studentResCopy.json");*/

        Group g1 = new Group(2, "someFac");
        Group g2 = new Group(322, "someSuperFac2");

        model.addGroup(g1);
        model.addGroup(g2);

        /*model.load("studentResCopy.json");*/

        /*Student stud1 = new Student("Иван Иванович Иванов", BigInteger.valueOf(3));
        Student stud2 = new Student("Борисов Борис Борисович", BigInteger.valueOf(2));

        model.deleteStudent(BigInteger.valueOf(3));*/

        for (int i = 1; i <= 2; i++) {
            System.out.println(model.getGroup(BigInteger.valueOf(i)));
        }

        for (int i = 1; i <= 2; i++) {
            System.out.println(model.getStudent(BigInteger.valueOf(i)));
        }

        /*System.out.println(model.getStudent(BigInteger.valueOf(3)).equals(model.getStudent(BigInteger.valueOf(4))));*/
    }
}