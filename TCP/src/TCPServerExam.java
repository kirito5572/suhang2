import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerExam {
    public static void main(String[] args) {
        while(true) {
            try {
                ServerSocket serverSocket = new ServerSocket(5000);
                Socket conn = serverSocket.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String msg = br.readLine();
                if(msg.length() > 0) {
                    System.out.println("수신 주소" + conn.getInetAddress());
                    System.out.println("수신 메세지" + msg);
                    msg = null;
                }
            } catch (IOException e) {
            }
        }
    }
}
