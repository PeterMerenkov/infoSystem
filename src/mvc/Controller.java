package mvc;

import java.math.BigInteger;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    //command index id1         fio             id2 number fac    date
    //add       0    1  Пупкин Василий Иванович  2    4    ИАИТ 26.11.2021
    public void command (String str) {
        String[] strArr = str.split(" ");

        String command = strArr[0];

        String fio = strArr[1] + " " + strArr[2] + " " + strArr[3];

        BigInteger groupId = BigInteger.valueOf(Long.parseLong(strArr[4]));

        Integer groupNum = Integer.valueOf(strArr[5]);

        String Fac = strArr[6];

    }
}
