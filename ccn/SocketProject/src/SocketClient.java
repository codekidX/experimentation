import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClient {
	
	private static Socket mSocket;
	private static String host = "localhost";
	private static int serverPort = 6365;
	private static boolean clientSwitch = true;
	
	private static String serverMsg = "";

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		mSocket = new Socket(host,serverPort);
		
		while(clientSwitch) {
			
			
			// get pipe stream from socket
			InputStream in = mSocket.getInputStream();
			InputStreamReader inR = new InputStreamReader(in);
			BufferedReader buff = new BufferedReader(inR);
			
			
			DataOutputStream dos = new DataOutputStream(mSocket.getOutputStream());
			
			System.out.println("Message : ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String msg = reader.readLine();
			
			dos.writeChars(msg + "\n");
			
			serverMsg = buff.readLine();
			System.out.println(serverMsg);
			
			
		}

	}

}
