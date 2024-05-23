import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class TaskClientWhile {

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            while (true) {
                System.out.println("入力数字以下の最大素数を求めます。数を入力してください (1以下の数値を入力すると終了) ↓");
                int num = scanner.nextInt();

                if (num <= 1) {
                    System.out.println("終了します");
                    break; // ループを抜けてプログラムを終了
                }

                TaskObject present = new TaskObject();
                present.setExecNumber(num);

                oos.writeObject(present);
                oos.flush();

                TaskObject okaeshiPresent = (TaskObject) ois.readObject();
                System.out.println("答えは" + okaeshiPresent.getResult());
            }

            ois.close();
            oos.close();
            socket.close();
            scanner.close();
        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
