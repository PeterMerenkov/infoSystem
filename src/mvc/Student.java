package mvc;

import java.math.BigInteger;
import java.util.Calendar;

public class Student {
    private BigInteger studentId;
    private String fio;
    private Calendar date;
    private BigInteger groupId;

    Student(String fio, BigInteger groupId) {
        this.fio = fio;
        this.groupId = groupId;
    }

    public BigInteger getStudentId() { return studentId; }

    public void setStudentId(BigInteger studentId) { this.studentId = studentId; }

    public String getFio() { return fio; }

    public void setFio(String fio) { this.fio = fio; }

    public Calendar getDate() { return date; }

    public void setDate(Calendar date) { this.date = date; }

    public BigInteger getGroupId() {
        return groupId;
    }

    public void setGroupId(BigInteger groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Строка с описанием студента";
    }
}