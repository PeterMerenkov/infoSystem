package mvc;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Student {
    private BigInteger studentId;
    private String fio;
    private Calendar date;
    private BigInteger groupId;

    public Student(String fio, BigInteger groupId) {
        this.fio = fio;
        this.groupId = groupId;

        this.date = new GregorianCalendar();
    }

    public BigInteger getStudentId() { return studentId; }

    public void setId(BigInteger Id) { this.studentId = Id; }

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

    public void set(Student student) {
        setFio(student.getFio());
        setGroupId(student.getGroupId());
        setDate(student.getDate());
    }

    @Override
    public String toString() {
        return "\n{" +
                "\"studentId\": " + studentId +
                ",\"fio\": \"" + fio +
                "\",\"date\": \"" + date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.MONTH) + 1) + "/" + date.get(Calendar.YEAR) +
                "\",\"groupId\": " + groupId +
                "}";
    }
}