import mvc.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Model model = new Model("D:\\myFiles\\study\\netCracker\\java\\infoSystem\\src\\student.json");
        View view = new View();

        Controller controller = new Controller(model, view);

        controller.start();
    }
}