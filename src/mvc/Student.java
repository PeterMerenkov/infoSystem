package mvc;

public class Student {
    private Integer id;
    private String fio;

    class Group {
        private Integer id;
        private Integer number;
        private String fac;

        public Group(Integer id, Integer number, String fac) {
            this.id = id;
            this.number = number;
            this.fac = fac;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getFac() {
            return fac;
        }

        public void setFac(String fac) {
            this.fac = fac;
        }
    }

    Student(Integer id1, String fio, Integer id2, Integer number, String fac) {
        this.id = id1;
        this.fio = fio;
        new Group(id2, number, fac);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        return "Строка с описанием студента";
    }
}
