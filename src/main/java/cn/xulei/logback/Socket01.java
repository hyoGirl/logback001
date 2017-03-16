package cn.xulei.logback;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Socket01 {

	public static void main(String[] args) {
//		MeasegeBean msg = new MeasegeBean();
//		MeasegeBean msg1 = new MeasegeBean();
//		msg.setReceive("sdfvsdfv");
//		msg1 = sendSocket(msg);
//		System.out.println(msg1.getResult());

		System.out.println("客户端启动...");
		System.out.println("当接收到服务器端字符为 \"OK\" 的时候, 客户端将终止\n");
		Socket socket = null;
		try {
			// 创建一个流套接字并将其连接到指定主机上的指定端口号
			socket = new Socket("192.168.56.102", 9999);

			// 读取服务器端数据
			DataInputStream input = new DataInputStream(socket.getInputStream());
			// 向服务器端发送数据
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			System.out.print("请输入: \t");
			// String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
			String str = "待发送的数据信息";
			out.writeUTF(str);

			String ret = input.readUTF();
			System.out.println("服务器端返回过来的是: " + ret);
			// 如接收到 "OK" 则断开连接
			if ("OK".equals(ret)) {
				System.out.println("客户端将关闭连接");
				Thread.sleep(500);
				// break;
			}

			out.close();
			input.close();
		} catch (Exception e) {
			System.out.println("客户端异常:" + e.getMessage());
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					socket = null;
					System.out.println("客户端 finally 异常:" + e.getMessage());
				}
			}
		}

	}
}
