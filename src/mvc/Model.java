package mvc;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Model {
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Group> groupList = new ArrayList<>();

    private BigInteger studIdGen;
    private BigInteger groupIdGen;

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
            tempStudent.setId(BigInteger.valueOf((Long) studentJSONObj.get("studentId")));

            String[] tempDate = ((String) studentJSONObj.get("date")).split("/");
            tempStudent.setDate(new GregorianCalendar(Integer.parseInt(tempDate[2]),
                    Integer.parseInt(tempDate[1]) - 1, Integer.parseInt(tempDate[0])));

            studentList.add(tempStudent);
        }

        studIdGen = BigInteger.valueOf(studentList.size());
        groupIdGen = BigInteger.valueOf(groupList.size());

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
        student.setId(studIdGen.add(BigInteger.ONE));

        studIdGen = studIdGen.add(BigInteger.ONE);

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
        group.setId(groupIdGen.add(BigInteger.ONE));

        groupIdGen = groupIdGen.add(BigInteger.ONE);

        groupList.add(group);
    }

    public void deleteGroup() {
        groupIdGen = groupIdGen.subtract(BigInteger.ONE);

        groupList.remove(groupList.get(groupList.size() - 1));
    }

    public void write(String path) {
        JSONObject root = new JSONObject();

        JSONArray studs = new JSONArray();
        JSONArray groups = new JSONArray();

        studs.addAll(studentList);
        groups.addAll(groupList);

        root.put("students", studs);
        root.put("groups", groups);

        try {
            try (FileWriter file = new FileWriter(path)) {
                file.write(root.toJSONString());
                file.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}