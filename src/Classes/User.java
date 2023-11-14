package Classes;

public class User {
    private int egn;
    private String name;
    private int debitCardNumber;

    public User(int egn, String name, int debitCardNumber) {
        this.egn = egn;
        this.name = name;
        this.debitCardNumber = debitCardNumber;
    }

    public int getEgn() {
        return egn;
    }

    public void setEgn(int egn) {
        this.egn = egn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDebitCardNumber() {
        return debitCardNumber;
    }

    public void setDebitCardNumber(int debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "egn=" + egn +
                ", name='" + name + '\'' +
                ", debitCardNumber=" + debitCardNumber +
                '}';
    }
}
