package black_horse.模拟用户登录;

import java.io.*;
import java.net.Socket;

public class ClientTest {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("DESKTOP-9IDONUJ", 8888);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("用户名：");
        String users = br.readLine();
        System.out.println("password:");
        String password = br.readLine();

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println(users);
        out.println(password);

        BufferedReader serverBr = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String result = serverBr.readLine();
        System.out.println(result);

        s.close();
    }
}
