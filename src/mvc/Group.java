package mvc;

import java.io.Serializable;
import java.math.BigInteger;

public class Group implements Serializable {
    private BigInteger id;
    private Integer number;
    private String fac;

    public Group(Integer number, String fac) {
        this.number = number;
        this.fac = fac;

        this.id = null;
    }

    public BigInteger getId() { return id; }

    public void setId(BigInteger id) { this.id = id; }

    public Integer getNumber() { return number; }

    public void setNumber(Integer number) { this.number = number; }

    public String getFac() { return fac; }

    public void setFac(String fac) { this.fac = fac; }

    public void set(Group group) {
        setNumber(group.getNumber());
        setFac(group.getFac());
    }

    @Override
    public String toString() {
        return "\n{" +
                "\"groupId\": " + id +
                ",\"number\": " + number +
                ",\"fac\": \"" + fac +
                "\"}";
    }

    public String toStr() {
        return id + " " + number + " " + fac;
    }
}
