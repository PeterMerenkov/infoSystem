package mvc;

import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Model {
    private ArrayList<Student> list = new ArrayList<Student>();

    public Student getStudent(int index) {
        return list.get(index);
    }

    public void setStudent(int index, Student student) {
        list.set(index, student);
    }

    public void addStudent(int index, Student student) {
        list.add(student);
    }

    public void deleteStudent(int index) {
        list.remove(index);
    }

    public void read(String path) throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(path);
    }
}