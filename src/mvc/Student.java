package mvc;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Student {
    private BigInteger studentId;
    private String fio;
    private Calendar date;
    private BigInteger groupId;

    Student(String fio, BigInteger groupId) {
        this.fio = fio;
        this.groupId = groupId;

        this.date = new GregorianCalendar();
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
        return "Student{" +
                "studentId=" + studentId +
                ", fio='" + fio + '\'' +
                ", date=" + date.getTime() +
                ", groupId=" + groupId +
                '}';
    }
}