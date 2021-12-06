package mvc;

public class View {
    public void show(Student student) {
        //оформление информации (таблица данных)
        System.out.println(student.getGroup().getId());
    }
}
