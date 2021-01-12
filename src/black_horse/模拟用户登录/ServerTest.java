package black_horse.模拟用户登录;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ServerTest {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket s = ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String use = br.readLine();
        String pass = br.readLine();
        boolean flag = false;

        PrintWriter out = new PrintWriter(s.getOutputStream(),true);

        List<User> users = UserDB.getUsers();
        User user = new User(use,pass);
        if(users.contains(user)){
            flag = true;
        }

        if(flag){
            out.println("ok");
        }else out.println("!");


        s.close();

    }
}
