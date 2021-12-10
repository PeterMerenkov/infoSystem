package mvc;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Model {
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Group> groupList = new ArrayList<>();

    public Model(String path) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(path);

        JSONObject rootJsonObject = (JSONObject) parser.parse(reader);

        JSONArray groupJSONArr = (JSONArray) rootJsonObject.get("groups");

        for(Object it : groupJSONArr) {
            JSONObject groupJSONObj = (JSONObject) it;

            Group tempGroup = new Group(((Long) groupJSONObj.get("number")).intValue(), (String) groupJSONObj.get("fac"));
            tempGroup.setId(BigInteger.valueOf((Long) groupJSONObj.get("groupId")));

            groupList.add(tempGroup);
        }

        JSONArray studentJSONArr = (JSONArray) rootJsonObject.get("students");

        for(Object it : studentJSONArr) {
            JSONObject studentJSONObj = (JSONObject) it;

            Student tempStudent = new Student((String) studentJSONObj.get("fio"),
                    BigInteger.valueOf((Long) studentJSONObj.get("groupId")));
            tempStudent.setStudentId(BigInteger.valueOf((Long) studentJSONObj.get("studentId")));

            String[] tempDate = ((String) studentJSONObj.get("date")).split("/");
            tempStudent.setDate(new GregorianCalendar(Integer.parseInt(tempDate[0]),
                    Integer.parseInt(tempDate[1]), Integer.parseInt(tempDate[2])));

            studentList.add(tempStudent);
        }

        reader.close();
    }

    public Student getStudent(BigInteger id) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(id)) {
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