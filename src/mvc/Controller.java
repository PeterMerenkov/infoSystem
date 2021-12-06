package mvc;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {
    private final Model model;
    private final View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    //command id1 fio id2 number fac date
    //add 0 1 Пупкин Василий Иванович 2 4 ИАИТ 26.11.2021
    public void command (String str) {
        //str parser begin-------------------
        int i = 0;
        StringBuilder temp = new StringBuilder();

        while(str.charAt(i) != ' ') {
            temp.append(str.charAt(i));
            i++;
        }
        String command = temp.toString();

        i++;
        temp = new StringBuilder();

        while(str.charAt(i) != ' ') {
            temp.append(str.charAt(i));
            i++;
        }
        int index = Integer.parseInt(temp.toString());

        i++;
        temp = new StringBuilder();

        while(str.charAt(i) != ' ') {
            temp.append(str.charAt(i));
            i++;
        }
        BigInteger id1 = new BigInteger(temp.toString());

        i++;
        temp = new StringBuilder();

        while(str.charAt(i) != ' ') {
            temp.append(str.charAt(i));
            i++;
        }
        String fio = temp.toString();

        i++;
        temp = new StringBuilder();

        while(str.charAt(i) != ' ') {
            temp.append(str.charAt(i));
            i++;
        }
        fio += " " + temp;

        i++;
        temp = new StringBuilder();

        while(str.charAt(i) != ' ') {
            temp.append(str.charAt(i));
            i++;
        }
        fio += " " + temp;

        i++;
        temp = new StringBuilder();

        while(str.charAt(i) != ' ') {
            temp.append(str.charAt(i));
            i++;
        }
        BigInteger id2 = new BigInteger(temp.toString());

        i++;
        temp = new StringBuilder();

        while(str.charAt(i) != ' ') {
            temp.append(str.charAt(i));
            i++;
        }
        Integer number = Integer.parseInt(temp.toString());

        i++;
        temp = new StringBuilder();

        while(str.charAt(i) != ' ') {
            temp.append(str.charAt(i));
            i++;
        }
        String faculty = temp.toString();

        i++;
        temp = new StringBuilder();

        while(str.charAt(i) != '.') {
            temp.append(str.charAt(i));
            i++;
        }
        int day = Integer.parseInt(temp.toString());

        i++;
        temp = new StringBuilder();

        while(str.charAt(i) != '.') {
            temp.append(str.charAt(i));
            i++;
        }
        int month = Integer.parseInt(temp.toString());

        i++;
        temp = new StringBuilder();

        while(str.length() != i) {
            temp.append(str.charAt(i));
            i++;
        }
        int year = Integer.parseInt(temp.toString());

        Calendar date = new GregorianCalendar(year, month - 1, day);
        //str parser end-------------------

        switch (command) {
            case "get" -> model.getStudent(index);
            case "set" -> model.setStudent(index,
                    new Student(id1, fio, date, id2, number, faculty));
            case "add" -> model.addStudent(index,
                    new Student(id1, fio, date, id2, number, faculty));
            case "delete" -> model.deleteStudent(index);
            case "show" -> view.show(model.getStudent(index));
        }
    }
}
