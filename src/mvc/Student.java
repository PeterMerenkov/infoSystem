package mvc;

import java.math.BigInteger;
import java.util.Calendar;

public class Student {
    private BigInteger id;
    private String fio;
    private Calendar date;

    class Group {
        private BigInteger id;
        private Integer number;
        private String fac;

        public Group(BigInteger id, Integer number, String fac) {
            this.id = id;
            this.number = number;
            this.fac = fac;
        }

        public BigInteger getId() { return id; }

        public void setId(BigInteger id) { this.id = id; }

        public Integer getNumber() { return number; }

        public void setNumber(Integer number) { this.number = number; }

        public String getFac() { return fac; }

        public void setFac(String fac) { this.fac = fac; }
    }

    Student(BigInteger id1, String fio, Calendar date, BigInteger id2, Integer number, String fac) {
        this.id = id1;
        this.fio = fio;
        this.date = date;
        new Group(id2, number, fac);
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