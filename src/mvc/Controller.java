package mvc;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void start () {
        System.out.println("Greetings message!" + "\n\n");
        view.help();

        String str;
        do {
            System.out.print("Input your command: ");
            Scanner in = new Scanner(System.in);
            str = in.nextLine();

            String[] strArr = str.split(" ");

            String command;

            if (strArr.length >= 2)
                command = strArr[0] + " " + strArr[1];
            else
                command = strArr[0];

            switch (command) {
                case "showAll students" -> {
                    showAllStuds();
                }
                case "showAll groups" -> {
                    showAllGroups();
                }
                case "show student" -> {
                    BigInteger studId = BigInteger.valueOf(Long.parseLong(strArr[2]));
                    System.out.println();
                    view.showStudHeader();
                    view.showStud(model.getStudent(studId).toStr());
                    System.out.println();
                }
                case "show group" -> {
                    BigInteger groupId = BigInteger.valueOf(Long.parseLong(strArr[2]));
                    System.out.println();
                    view.showGroupHeader();
                    view.showGroup(model.getGroup(groupId).toStr());
                    System.out.println();
                }
                case "add student" -> {
                    String fio = strArr[2] + " " + strArr[3] + " " + strArr[4];

                    BigInteger groupId = BigInteger.valueOf(Long.parseLong(strArr[5]));

                    Student stud = new Student(fio, groupId);

                    model.addStudent(stud);

                    System.out.println("\nStudent was successfully added!");
                    showAllStuds();
                }
                case "add group" -> {
                    Integer groupNum = Integer.valueOf(strArr[2]);

                    String fac = strArr[3];

                    Group group = new Group(groupNum, fac);

                    model.addGroup(group);

                    System.out.println("\nGroup was successfully added!");
                    showAllGroups();
                }
                case "change student" -> {
                    BigInteger changeId = BigInteger.valueOf(Long.parseLong(strArr[2]));

                    String fio = strArr[3] + " " + strArr[4] + " " + strArr[5];

                    BigInteger groupId = BigInteger.valueOf(Long.parseLong(strArr[6]));

                    Student stud = new Student(fio, groupId);

                    model.setStudent(changeId, stud);

                    System.out.println("\nStudent was successfully changed!");
                    showAllStuds();
                }
                case "change group" -> {
                    BigInteger changeId = BigInteger.valueOf(Long.parseLong(strArr[2]));

                    Integer groupNum = Integer.valueOf(strArr[3]);

                    String fac = strArr[4];

                    Group group = new Group(groupNum, fac);

                    model.setGroup(changeId, group);

                    System.out.println("\nGroup was successfully changed!");
                    showAllGroups();
                }
                case "delete student" -> {
                    BigInteger id = BigInteger.valueOf(Long.parseLong(strArr[2]));

                    model.deleteStudent(id);

                    System.out.println("\nStudent was successfully deleted!");
                    showAllStuds();
                }
                case "delete group" -> {
                    BigInteger id = BigInteger.valueOf(Long.parseLong(strArr[2]));

                    model.deleteGroup(id);

                    System.out.println("\nGroup was successfully deleted!");
                    showAllGroups();
                }
                case "load resCopy" -> {
                    String path = strArr[2];

                    try {
                        model.load(path);
                    } catch (IOException | ParseException e) {
                        e.printStackTrace();
                    }

                    System.out.println("\nReserve copy was successfully loaded!");
                    showAllStuds();
                    showAllGroups();
                }
                case "save resCopy" -> {
                    String path = strArr[2];

                    model.save(path);

                    System.out.println("\nReserve copy was successfully saved!\n");
                }
                default -> {
                    if (str.equals("exit"))
                        System.out.println("\nExiting...\n");
                    else
                        System.out.println("\nInvalid command!\n");
                }
            }

            /*in.close();*/
        } while (!str.equals("exit"));
    }

    private void showAllStuds() {
        System.out.println();
        view.showStudHeader();
        for (int i = 0; i < model.getStudentList().size(); i++) {
            view.showStud(model.getStudentList().get(i).toStr());
        }
        System.out.println();
    }

    private void showAllGroups(){
        System.out.println();
        view.showGroupHeader();
        for (int i = 0; i < model.getGroupList().size(); i++) {
            view.showGroup(model.getGroupList().get(i).toStr());
        }
        System.out.println();
    }
}
