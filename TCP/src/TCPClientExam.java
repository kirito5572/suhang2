import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClientExam extends JFrame {
    public TCPClientExam() {
        super("TCP Client");
        JPanel upperPaenl= new JPanel();
        JTextField msgTextField = new JTextField(20);
        JButton send = new JButton("Send");
        JTextArea sendData = new JTextArea();
        JScrollPane centerScrollPane = new JScrollPane(sendData);
        upperPaenl.add(msgTextField);
        upperPaenl.add(send);
        add(upperPaenl,BorderLayout.NORTH);
        add(centerScrollPane,BorderLayout.CENTER);
        setSize(350,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        send.addActionListener(e -> {
            String msg = msgTextField.getText();
            msgTextField.setText("");
            try {
                InetAddress ia = InetAddress.getByName("127.0.0.1");
                Socket conn = new Socket(ia, 5000);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
                bw.write(msg);
                bw.flush();
                bw.close();
            } catch (IOException ignored) {
            }
            sendData.append(msg + " ");
        });
        msgTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String msg = msgTextField.getText();
                msgTextField.setText("");
                try {
                    InetAddress ia = InetAddress.getByName("127.0.0.1");
                    Socket conn = new Socket(ia, 5000);
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
                    bw.write(msg);
                    bw.flush();
                    bw.close();
                } catch (IOException ignored) {
                }
                sendData.append(msg + " ");
            }
        });
    }
    public static void main(String[] args) {
        new TCPClientExam();
    }
}
