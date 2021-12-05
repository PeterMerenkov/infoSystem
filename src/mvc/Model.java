package mvc;

import java.util.ArrayList;

public class Model {
    private ArrayList<Student> list = new ArrayList<Student>();

    public void showStudent(int index) {
        System.out.println(list.get(index));
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
}
