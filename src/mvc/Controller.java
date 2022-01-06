package mvc;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.math.BigInteger;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void command (String str) {
        String[] strArr = str.split(" ");

        String command = strArr[0] + " " + strArr[1];

        switch (command) {
            case "show student" -> {
                BigInteger studId = BigInteger.valueOf(Long.parseLong(strArr[2]));
                view.showStud(model.getStudent(studId).toString());
            }
            case "show group" -> {
                BigInteger groupId = BigInteger.valueOf(Long.parseLong(strArr[2]));
                view.showGroup(model.getGroup(groupId).toString());
            }
            case "add student" -> {
                String fio = strArr[2] + " " + strArr[3] + " " + strArr[4];

                BigInteger groupId = BigInteger.valueOf(Long.parseLong(strArr[5]));

                Student stud = new Student(fio, groupId);

                model.addStudent(stud);
            }
            case "add group" -> {
                Integer groupNum = Integer.valueOf(strArr[2]);

                String fac = strArr[3];

                Group group = new Group(groupNum, fac);

                model.addGroup(group);
            }
            case "change student" -> {
                BigInteger changeId = BigInteger.valueOf(Long.parseLong(strArr[2]));

                String fio = strArr[3] + " " + strArr[4] + " " + strArr[5];

                BigInteger groupId = BigInteger.valueOf(Long.parseLong(strArr[6]));

                Student stud = new Student(fio, groupId);

                model.setStudent(changeId, stud);
            }
            case "change group" -> {
                BigInteger changeId = BigInteger.valueOf(Long.parseLong(strArr[2]));

                Integer groupNum = Integer.valueOf(strArr[3]);

                String fac = strArr[4];

                Group group = new Group(groupNum, fac);

                model.setGroup(changeId, group);
            }
            case "delete student" -> {
                BigInteger id = BigInteger.valueOf(Long.parseLong(strArr[2]));

                model.deleteStudent(id);
            }
            case "delete group" -> {
                BigInteger id = BigInteger.valueOf(Long.parseLong(strArr[2]));

                model.deleteGroup(id);
            }
            case "load resCopy" -> {
                String path = strArr[2];

                try {
                    model.load(path);
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            }
            case "save resCopy" -> {
                String path = strArr[2];

                model.save(path);
            }
        }

    }
}
