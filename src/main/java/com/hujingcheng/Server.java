package com.hujingcheng;

import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

//服务器端：接收并保存文件
public class Server {
    //在方法声明部分使用,表示该方法可能产生此异常,如果在方法声明处使用了throws声明异常,则该方法产生异常也不必捕获,
    // 会直接把异常抛出到调用该方法的地方
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(6666);   //指定端口号，用来监听客户端的连接
        Socket s;
        Writer out = null;
        s = ss.accept();     //接收客户端的申请连接
        DataInputStream dis = new DataInputStream(s.getInputStream());
        String str = dis.readUTF();
        System.out.println(str);
        try {
            out = new FileWriter("D:\\java\\testTCP\\src\\main\\java\\com\\hujingcheng\\objectFileCopy.txt");

        } catch (IOException e) {
            System.out.println("文件复制错误");
            System.exit(-1);
        }
        out.write(str);
        out.close();
        dis.close();
        s.close();
    }
}

