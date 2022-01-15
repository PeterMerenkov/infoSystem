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
                case "help" -> {
                    if (strArr.length == 1) {
                        view.help();
                    }
                    else {
                        System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                    }
                }
                case "showAll students" -> {
                    if (strArr.length == 2) {
                        showAllStuds();
                    }
                    else {
                        System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                    }

                }
                case "showAll groups" -> {
                    if (strArr.length == 2) {

                    }
                    else {
                        System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                    }

                    showAllGroups();
                }
                case "show student" -> {
                    if (strArr.length == 3) {
                        BigInteger studId = BigInteger.valueOf(Long.parseLong(strArr[2]));

                        if (studId.compareTo(BigInteger.ZERO) > 0) {
                            System.out.println();

                            view.showStudHeader();
                            view.showStud(model.getStudent(studId).toStr());

                            System.out.println();
                        }
                        else {
                            System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                        }
                    }
                    else {
                        System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                    }
                }
                case "show group" -> {
                    if (strArr.length == 3) {
                        BigInteger groupId = BigInteger.valueOf(Long.parseLong(strArr[2]));

                        if (groupId.compareTo(BigInteger.ZERO) > 0) {
                            System.out.println();

                            view.showGroupHeader();
                            view.showGroup(model.getGroup(groupId).toStr());

                            System.out.println();
                        }
                        else {
                            System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                        }
                    }
                    else {
                        System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                    }
                }
                case "add student" -> {
                    if (strArr.length == 6) {
                        String fio = strArr[2] + " " + strArr[3] + " " + strArr[4];

                        BigInteger groupId = BigInteger.valueOf(Long.parseLong(strArr[5]));

                        if (groupId.compareTo(BigInteger.ZERO) > 0) {
                            Student stud = new Student(fio, groupId);

                            model.addStudent(stud);

                            System.out.println("\nStudent was successfully added!");
                            showAllStuds();
                        }
                        else {
                            System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                        }
                    }
                    else {
                        System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                    }
                }
                case "add group" -> {
                    if (strArr.length == 4) {
                        Integer groupNum = Integer.valueOf(strArr[2]);

                        if(groupNum > 0) {
                            String fac = strArr[3];

                            Group group = new Group(groupNum, fac);

                            model.addGroup(group);

                            System.out.println("\nGroup was successfully added!");
                            showAllGroups();
                        } else {
                            System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                        }
                    }
                    else {
                        System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                    }
                }
                case "change student" -> {
                    if (strArr.length == 7) {
                        BigInteger changeId = BigInteger.valueOf(Long.parseLong(strArr[2]));
                        BigInteger groupId = BigInteger.valueOf(Long.parseLong(strArr[6]));

                        if(changeId.compareTo(BigInteger.ZERO) > 0 && groupId.compareTo(BigInteger.ZERO) > 0) {
                            String fio = strArr[3] + " " + strArr[4] + " " + strArr[5];

                            Student stud = new Student(fio, groupId);

                            model.setStudent(changeId, stud);

                            System.out.println("\nStudent was successfully changed!");
                            showAllStuds();
                        } else {
                            System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                        }
                    }
                    else {
                        System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                    }
                }
                case "change group" -> {
                    if (strArr.length == 7) {
                        BigInteger changeId = BigInteger.valueOf(Long.parseLong(strArr[2]));
                        Integer groupNum = Integer.valueOf(strArr[3]);

                        if(changeId.compareTo(BigInteger.ZERO) > 0 && groupNum > 0) {
                            String fac = strArr[4];

                            Group group = new Group(groupNum, fac);

                            model.setGroup(changeId, group);

                            System.out.println("\nGroup was successfully changed!");
                            showAllGroups();
                        } else {
                            System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                        }
                    }
                    else {
                        System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                    }
                }
                case "delete student" -> {
                    if (strArr.length == 3) {
                        BigInteger id = BigInteger.valueOf(Long.parseLong(strArr[2]));

                        if(id.compareTo(BigInteger.ZERO) > 0) {
                            model.deleteStudent(id);

                            System.out.println("\nStudent was successfully deleted!");
                            showAllStuds();
                        } else {
                            System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                        }
                    }
                    else {
                        System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                    }
                }
                case "delete group" -> {
                    if (strArr.length == 3) {
                        BigInteger id = BigInteger.valueOf(Long.parseLong(strArr[2]));

                        if(id.compareTo(BigInteger.ZERO) > 0) {
                            model.deleteGroup(id);

                            System.out.println("\nGroup was successfully deleted!");
                            showAllGroups();
                        } else {
                            System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                        }

                    }
                    else {
                        System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                    }
                }
                case "load resCopy" -> {
                    if (strArr.length == 3) {
                        String path = strArr[2];

                        try {
                            model.load(path);
                            System.out.println("\nReserve copy was successfully loaded!");
                            showAllStuds();
                            showAllGroups();
                        } catch (IOException | ParseException e) {
                            System.out.println("Not correct load path!");
                            e.printStackTrace();
                        }

                    }
                    else {
                        System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                    }
                }
                case "save resCopy" -> {
                    if (strArr.length == 3) {
                        String path = strArr[2];

                        model.save(path);

                        System.out.println("\nReserve copy was successfully saved!\n");
                    }
                    else {
                        System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                    }
                }
                default -> {
                    if (str.equals("exit"))
                        System.out.println("\nExiting...\n");
                    else
                        System.out.println("\nInvalid command! Type \"help\" to see existing commands!\n");
                }
            }
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
