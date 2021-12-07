package mvc;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class Model {
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private ArrayList<Group> groupList = new ArrayList<Group>();

    public Student getStudent(BigInteger id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public ArrayList<Group> getGroupList() {
        return groupList;
    }

    public void setStudent(int index, Student student) {
        studentList.set(index, student);
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void deleteStudent(int index) {
        studentList.remove(index);
    }


    public Group getGroup(BigInteger id) {
        for (Group group : groupList) {
            if (group.getId().equals(id)) {
                return group;
            }
        }
        return null;
    }

    public void addGroup(Group group) {
        groupList.add(group);
    }


    public void read(String path) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(path);

        JSONObject jsonObject = (JSONObject) parser.parse(reader);


    }
}