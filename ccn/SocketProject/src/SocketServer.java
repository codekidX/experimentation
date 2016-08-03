import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServer {
	
	// address and port
	private static String localIP = null;
	private static int serverPort = 0;
	
	//server
	private static ServerSocket serverSocket;
	private static Socket socketFromServer;
	private static boolean serverSwitch = true;
	private static BufferedReader buff;

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner("Enter local IP (if u don't enter anything localhost will be used)");
		
		localIP = scanner.nextLine();
		
		if(localIP != null) {
			serverPort = scanner.nextInt();
		}
		if(serverPort !=0 && serverPort < 10000) {
			
				serverSocket = new ServerSocket(serverPort);
		}
		
		while(serverSwitch) {
			
				socketFromServer = serverSocket.accept();
			
				InputStream in = socketFromServer.getInputStream();
				InputStreamReader inR = new InputStreamReader(in);
				buff = new BufferedReader(inR);
			
				DataOutputStream dos = new DataOutputStream(socketFromServer.getOutputStream());
			
			String clientMsg = buff.readLine();
			
			System.out.println(clientMsg);
		}

	}

}
