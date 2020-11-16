import java.net.*;
import java.io.*;
public class Project06A_Server {

	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(9999);
			System.out.println("Server ready...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		while(true) {
			try {
				Socket socket = ss.accept();  // client의 정보를 알고 있는 socket
				System.out.println("client connect success!!");
				InputStream in = socket.getInputStream();
				DataInputStream dis = new DataInputStream(in); // 한글이 꺠질 수 있어서 사용
				String message = dis.readUTF();
				
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				dos.writeUTF("[ECHO]"+message+"(from Server)"); //client로부터 받은 메시지를 다시 client로 보낸다.
				dos.close();
				dis.close();
				socket.close();
				System.out.println("client socket close");
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}// end while
	}// end main

}// end class
