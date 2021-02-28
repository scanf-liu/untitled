package black_horse._tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientDemoo {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket(InetAddress.getByName("DESKTOP-9IDONUJ"), 10010);
        OutputStream os = s.getOutputStream();
        os.write("wewee".getBytes());

        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);

        System.out.println(new String(bys, 0, len));
        s.close();
    }
}
