package mvc;

import java.math.BigInteger;
import java.util.Calendar;

public class Student {
    private BigInteger id;
    private String fio;
    private Calendar date;

    Student(BigInteger id, String fio, Calendar date) {
        this.id = id;
        this.fio = fio;
        this.date = date;
    }

    public BigInteger getId() { return id; }

    public void setId(BigInteger id) { this.id = id; }

    public String getFio() { return fio; }

    public void setFio(String fio) { this.fio = fio; }

    public Calendar getDate() { return date; }

    public void setDate(Calendar date) { this.date = date; }

    @Override
    public String toString() {
        return "Строка с описанием студента";
    }
}