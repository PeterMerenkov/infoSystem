package mvc;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {
    private Model model;
    private View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    //command id1 fio id2 number fac date
    //add 1 Пупкин Василий Иванович 2 4 ИАИТ 26.11.2021
    public void command (String str) {
        int index = 0;
        String temp = "";

        while(str.charAt(index) != ' ') {
            temp += str.charAt(index);
            index++;
        }
        String command = temp;

        index++;
        temp = "";

        while(str.charAt(index) != ' ') {
            temp += str.charAt(index);
            index++;
        }
        BigInteger id1 = new BigInteger(temp);

        index++;
        temp = "";

        while(str.charAt(index) != ' ') {
            temp += str.charAt(index);
            index++;
        }
        String fio = temp;

        index++;
        temp = "";

        while(str.charAt(index) != ' ') {
            temp += str.charAt(index);
            index++;
        }
        fio += " " + temp;

        index++;
        temp = "";

        while(str.charAt(index) != ' ') {
            temp += str.charAt(index);
            index++;
        }
        fio += " " + temp;

        index++;
        temp = "";

        while(str.charAt(index) != ' ') {
            temp += str.charAt(index);
            index++;
        }
        BigInteger id2 = new BigInteger(temp);

        index++;
        temp = "";

        while(str.charAt(index) != ' ') {
            temp += str.charAt(index);
            index++;
        }
        Integer number = Integer.parseInt(temp);

        index++;
        temp = "";

        while(str.charAt(index) != ' ') {
            temp += str.charAt(index);
            index++;
        }
        String faculty = temp;

        index++;
        temp = "";

        while(str.charAt(index) != '.') {
            temp += str.charAt(index);
            index++;
        }
        int day = Integer.parseInt(temp);

        index++;
        temp = "";

        while(str.charAt(index) != '.') {
            temp += str.charAt(index);
            index++;
        }
        int month = Integer.parseInt(temp);

        index++;
        temp = "";

        while(str.length() != index) {
            temp += str.charAt(index);
            index++;
        }
        int year = Integer.parseInt(temp);

        Calendar date = new GregorianCalendar(year, month - 1, day);
    }
}
