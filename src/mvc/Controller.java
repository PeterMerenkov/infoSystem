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
                    System.out.println();
                    view.showStudHeader();
                    for (int i = 0; i < model.getStudentList().size(); i++) {
                        view.showStud(model.getStudentList().get(i).toStr());
                    }
                    System.out.println();
                }
                case "showAll groups" -> {
                    System.out.println();
                    view.showGroupHeader();
                    for (int i = 0; i < model.getGroupList().size(); i++) {
                        view.showGroup(model.getGroupList().get(i).toStr());
                    }
                    System.out.println();
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

                    System.out.println("\nStudent was successfully added! Checkout w \"showAll students\"!\n");
                }
                case "add group" -> {
                    Integer groupNum = Integer.valueOf(strArr[2]);

                    String fac = strArr[3];

                    Group group = new Group(groupNum, fac);

                    model.addGroup(group);

                    System.out.println("\nGroup was successfully added! Checkout w \"showAll groups\"!\n");
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
                default -> {
                    if (str.equals("exit"))
                        System.out.println("Exiting...");
                    else
                        System.out.println("Invalid command!");
                }
            }

            /*in.close();*/
        } while (!str.equals("exit"));


    }
}
