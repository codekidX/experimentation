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
	private static String localHost = "http://localhost";

	public static void main(String[] args)  throws IOException {
		
		// TODO make use of this IP address to create socket in computer IP
		
		System.out.println("Enter local IP (if u don't enter anything localhost will be used) : ");
		
		final Scanner scanner = new Scanner(System.in);
		
		localIP = scanner.nextLine();
		
		if(localIP == null) {
			localIP = localHost ;
		}
		
		serverPort = 6065;
		
		System.out.println("Connect your client with port : " + serverPort);
		if(serverPort !=0 && serverPort < 10000) {
			// instantiate server on port
				serverSocket = new ServerSocket(serverPort);
		}
		
	    // accept socket data from client
		socketFromServer = serverSocket.accept();
		
		while(serverSwitch) {
			
				// get pipe stream from socket
				InputStream in = socketFromServer.getInputStream();
				InputStreamReader inR = new InputStreamReader(in);
				// buffered reader to read socket pipe buffer (requires reader)
				buff = new BufferedReader(inR);
				
				DataOutputStream dos = new DataOutputStream(socketFromServer.getOutputStream());
				
				keepOnListening(dos);
			
				
		}

	}

	private static void keepOnListening(DataOutputStream dos) throws IOException {
		// TODO Auto-generated method stub
		String clientMsg = buff.readLine();
		
			if(clientMsg.equals("bye")) {
				System.out.println("Server CLOSED !!");
				serverSocket.close();
				dos.writeBytes("Bye Client");
			} else {
				dos.writeBytes("Reply from server : " + clientMsg + " is processed \n");
			}
		}

}
