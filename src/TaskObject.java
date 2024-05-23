import java.io.Serializable;

public class TaskObject implements Serializable,ITask {

    int num;
    int result;

    @Override
	public void setExecNumber(int num){
        this.num =num;
    }

    @Override
    public void exec(){
        for (int i = 2; i<=num; i++) {
            if (isPrime(i)) {
                result=i;
            }
        }
    }

    @Override
    public int getResult(){
        return result;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}