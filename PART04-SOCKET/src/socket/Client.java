package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 聊天室客户端
 */
public class Client {
    //java.net.Socket 套接字，原意是插座
    private Socket socket;

    //初始化客户端
    public Client() {
        try {
            System.out.println("正在链接服务器。。。");
            //localhost:本地主机
            socket = new Socket("localhost", 8088);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //192.168.0.127
    }

    //客户端开始工作的方法
    public void start() {
        try {
            ServerHandler handler = new ServerHandler();
            Thread t = new Thread(handler);
            t.setDaemon(true);
            t.start();
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw, true);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String line = scanner.nextLine();
                if ("exit".equalsIgnoreCase(line)) {
                    break;
                }
                pw.println(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //项目的主入口
    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    private class ServerHandler implements Runnable {
        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("服务器回复："+line);
                }
            } catch (IOException e) {
            }
        }
    }
}
