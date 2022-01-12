package mvc;

public class View {
    public void  showStudHeader() {
        String line = "";
        for (int i = 0; i < 18; i++) {
            line += "-";
        }
        System.out.println("+" + line + "+" + line + "+" + line + "+" + line + "+" + line + "+");

        System.out.format("| %-16s | %-16s | %-16s | %-16s | %-16s |", "ID", "SURNAME", "NAME", "PATRONYMIC", "GROUP-ID");
        System.out.println();

        System.out.println("+" + line + "+" + line + "+" + line + "+" + line + "+" + line + "+");
    }

    public void showStud(String studentInfo) {
        String[] strArr = studentInfo.split(" ");

        System.out.format("| %-16s | %-16s | %-16s | %-16s | %-16s |", strArr[0], strArr[1], strArr[2], strArr[3], strArr[4]);
        System.out.println();

        String line = "";
        for (int i = 0; i < 18; i++) {
            line += "-";
        }
        System.out.println("+" + line + "+" + line + "+" + line + "+" + line + "+" + line + "+");
    }

    public void  showGroupHeader() {
        String line = "";
        for (int i = 0; i < 18; i++) {
            line += "-";
        }
        System.out.println("+" + line + "+" + line + "+" + line + "+");

        System.out.format("| %-16s | %-16s | %-16s |", "ID", "NUMBER_OF_GROUP", "FACILITY");
        System.out.println();

        System.out.println("+" + line + "+" + line + "+" + line + "+");
    }

    public void showGroup(String groupInfo) {
        String[] strArr = groupInfo.split(" ");

        System.out.format("| %-16s | %-16s | %-16s |", strArr[0], strArr[1], strArr[2]);
        System.out.println();

        String line = "";
        for (int i = 0; i < 18; i++) {
            line += "-";
        }
        System.out.println("+" + line + "+" + line + "+" + line + "+");
    }
    public void help() {
        System.out.println(
                "List of the commands:" + "\n"
                        + " - help" + "\n"
                        + " - showAll students" + "\n"
                        + " - showAll groups" + "\n"
                        + " - show student (ID)"  + "\n"
                        + " - show group (ID)" + "\n"
                        + " - add student (FIO GROUP_ID)" + "\n"
                        + " - add group (NUMBER_OF_GROUP FACILITY)" + "\n"
                        + " - change student (ID FIO GROUP_ID)" + "\n"
                        + " - change group (ID NUMBER_OF_GROUP FACILITY)" + "\n"
                        + " - delete student (ID)" + "\n"
                        + " - delete group (ID)" + "\n"
                        + " - load resCopy (PATH_TO_RESERVE_COPY)" + "\n"
                        + " - save resCopy (PATH_TO_RESERVE_COPY)" + "\n"
                        + " - exit" + "\n"
        );
    }
}
