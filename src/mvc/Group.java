package mvc;

import java.math.BigInteger;

public class Group {
    private BigInteger id;
    private Integer number;
    private String fac;

    private static BigInteger idGenerator = BigInteger.valueOf(0);

    public Group(Integer number, String fac) {
        this.number = number;
        this.fac = fac;

        this.id = idGenerator;
        idGenerator = idGenerator.add(BigInteger.ONE);
    }

    public BigInteger getId() { return id; }

    public void setId(BigInteger id) { this.id = id; }

    public Integer getNumber() { return number; }

    public void setNumber(Integer number) { this.number = number; }

    public String getFac() { return fac; }

    public void setFac(String fac) { this.fac = fac; }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", number=" + number +
                ", fac='" + fac + '\'' +
                '}';
    }
}
