package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Server {
    private ServerSocket server;
    private PrintWriter[] allOut = {};
    public Server(){
        try {
            System.out.println("正在启动服务器。。。");
            server = new ServerSocket(8088);
            System.out.println("服务器启动完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        try {
            while (true){
                System.out.println("等待客户端链接。。。");
                //accept：接收
                Socket socket = server.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread t = new Thread(clientHandler);
                t.start();
                System.out.println("一个客户端链接了！！！");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
    private class ClientHandler implements Runnable{
        private Socket socket;
        private String host;
        public ClientHandler(Socket socket) {
            this.socket = socket;
            host = socket.getInetAddress().getHostAddress();
        }
        @Override
        public void run() {
            PrintWriter pw = null;
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out,StandardCharsets.UTF_8);
                BufferedWriter bw = new BufferedWriter(osw);
                pw = new PrintWriter(bw,true);
                synchronized(Server.this){
                    allOut[allOut.length-1] = pw;
                    allOut = Arrays.copyOf(allOut,allOut.length+1);
                }
                sendMessage("有新的客户端上线了！当前在线人数："+allOut.length);
                String line ;
                while ((line = br.readLine())!=null){
                    System.out.println(host+"客户端说："+line);
                    sendMessage(line);
//                    for (int i = 0; i < allOut.length; i++) {
//                        allOut[i].println(line);
//                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                synchronized (Server.this) {
                    for (int i = 0; i < allOut.length; i++) {
                        if (allOut[i] == pw) {
                            allOut[i] = allOut[allOut.length - 1];
                            allOut = Arrays.copyOf(allOut, allOut.length - 1);
                            break;
                        }
                    }
                }
                sendMessage("有新的客户端下线了！当前在线人数："+allOut.length);
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
        private void sendMessage(String msg){
            synchronized (Server.this){
                for (int i = 0; i < allOut.length; i++) {
                    allOut[i].println(msg);
                }
            }
        }
    }
}
