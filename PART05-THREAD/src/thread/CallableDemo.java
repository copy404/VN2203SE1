package thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class CallableDemo implements Callable<Boolean> {
    private String url;
    private String name;

    public CallableDemo(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo c1 = new CallableDemo("https://img.alicdn.com/imgextra/i1/3363331024/O1CN01HwZy3U1JR2JqSppnV_!!3363331024.jpg","1.jpg");
        CallableDemo c2 = new CallableDemo("https://img.alicdn.com/imgextra/i4/3363331024/O1CN013aKqj41JR2JpXQQsL_!!3363331024.jpg","2.jpg");
        CallableDemo c3 = new CallableDemo("https://img.alicdn.com/imgextra/i2/3363331024/O1CN01kXttES1JR2JoF7brG_!!3363331024.jpg","3.jpg");
        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(1);
        //提交执行
        Future<Boolean> r1 = ser.submit(c1);
        Future<Boolean> r2 = ser.submit(c2);
        Future<Boolean> r3 = ser.submit(c3);
        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);
        //关闭服务
        ser.shutdownNow();
    }
}
class WebDownloader{
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}