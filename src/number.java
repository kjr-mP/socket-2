import java.io.Serializable;

public class number implements Serializable {

    int number1;
    int number2;
    String message;

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = Integer.parseInt(number1);
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = Integer.parseInt(number2);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}