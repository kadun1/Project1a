package chat7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MultiClient {
	
	public static void main(String[] args) {
		
		MultiServer ms = new MultiServer();
		System.out.print("이름을 입력하세요:");
		Scanner scanner = new Scanner(System.in);
		try {
		while(true) {
		String s_name = scanner.nextLine();
			if(!ms.clientMap.containsKey(s_name)) {
				System.out.println(ms.clientMap.equals(s_name));
				String ServerIP = "localhost";
				if(args.length > 0) {
					ServerIP = args[0];
				}
				Socket socket = new Socket(ServerIP, 9999);
				System.out.println("서버와 연결되었습니다...");
				
				Thread receiver = new Receiver(socket);
				receiver.start();
				
				Thread sender = new Sender(socket, s_name);
				sender.start();
				break;
				
			}
			else {
				System.out.println("중복된 이름이 존재합니다.");
				break;
				
		//PrintWriter out = null;
		//BufferedReader in = null;
		
			}
		}
		}
		catch (Exception e) {
			System.out.println("예외발생[MultiClient]"+e);
		}
	
	}
}
