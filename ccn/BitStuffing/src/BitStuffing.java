import java.util.Scanner;

public class BitStuffing {
	
	//flag
	private static String flag = "";
	private static int flagLength = 0;
	
	private static final String DEFAULT_FLAG = "0111110";
	
	//data
	private static String data = "";
	private static String stuffedData = "";
	private static int dataLength = 0;
	private static final CharSequence CONSECUTIVE_ONES="11";
	private static final String CONSECUTIVE_ZEROS="00";

	public static void main(String[] args) {
		// ask the user for flag sequence
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the flag sequence (Press N to run with default flag) : ");
		flag = scanner.nextLine();
		
		if(!flag.matches("")) {
			if(flag.matches("N") || flag.matches("n")) {
				System.out.println("Using default flag (0111110)");
				flag = DEFAULT_FLAG;
			}
		} else {
			// user is dumb ask again
						System.out.println("Enter the flag sequence (Press N to run with default flag) :");
						data = scanner.nextLine();
		}
		//get flag length
		flagLength = flag.length();
		
		// ask the user for data sequence
		System.out.println("Enter the data sequence : ");
		data = scanner.nextLine();
		
		// no more user input needed close scanner
		scanner.close();
		
		if(data !=null && !data.matches("")) {
		if(data.contains(flag)) {
			
			dataLength = data.length();
			int startIndex = data.indexOf(flag);
			int endIndex = startIndex + flagLength;
			
			//extract flag from the data
			String flagData = data.substring(startIndex, endIndex);
			System.out.println("flag data : " + flagData);
			int startIndexOfContSeq;
			
			//check if it has any consecutive ones. Why? because its the best place to stuff
			if(flagData.contains(CONSECUTIVE_ONES)) {
				startIndexOfContSeq = flagData.indexOf("11");
				int whereToStuff = startIndex + startIndexOfContSeq + 1;
				stuffedData = data.substring(0,whereToStuff) + "|0|" + data.substring(whereToStuff , dataLength);
				
			} else {
				//improvise
				startIndexOfContSeq = flagData.indexOf(CONSECUTIVE_ZEROS);
			}
			
			System.out.println("Before stuffing: " + data);
			System.out.println(" After stuffing: " + stuffedData);
			
		} else {
			System.out.println(" Your data is safe to transmit and does not need bit stuffing.");
		}
		} else {
			// user is dumb ask again
			System.out.println("Enter the data sequence : ");
			data = scanner.nextLine();
		}
		
	}

}
