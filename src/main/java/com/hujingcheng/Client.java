package com.hujingcheng;

import java.io.*;
import java.net.Socket;

//客户端：读取任意文件内容并发送至客户端
public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("192.168.43.89", 6666);   //个人电脑IP地址和端口号
        Reader in = null;
        try {
            in = new FileReader("D:\\java\\testTCP\\src\\main\\java\\com\\hujingcheng\\objectFile.txt");

        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
            System.exit(-1);
        }
        String str = new String();
        int b;
        char c;
        while ((b = in.read()) != -1) {
            c = (char) b;
            str = str.concat(String.valueOf(c));
        }
        System.out.println(str);
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF(str);
        dos.flush();
        dos.close();
        s.close();
    }
}