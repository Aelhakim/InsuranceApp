import java.util.*;
public class InsuranceScore {
	public static void showMenu() {
		System.out.println("\nHere are your choices: ");
		System.out.println("1. List members ");
		System.out.println("2. Add a new member");
		System.out.println("3. Save members");
		System.out.println("4. Load members");
		System.out.println("5. Assess members");
		System.out.println("6. Save assessments as JSON");
		System.out.println("7. Exit");
		}
	public static void printSymbol(int howMany) {
		String symbol = "";
		for (int i = 0; i < howMany; i++) {
			symbol = symbol + "<>";
			}
	        System.out.println(symbol);
	    }
	public static void showCard() {
		printSymbol(20);
		System.out.println("	  INSURANCE SCORE CARD");
		System.out.println("  This app scores a potential customer");
		System.out.println("  on various health attributes: blood");
		System.out.println("  pressure, age, height, weight, and");
		System.out.println("  family history of disease. It writes");
		System.out.println("  each member's insurance grade to a ");
		System.out.println("  JSON file so that they can be easily");
		System.out.println("  shared on a web-based data exchange.");
		printSymbol(20);
		}
	public static void showThanks() {
		printSymbol(22);
		System.out.println("             INSURANCE SCORE CARD");
		System.out.println("                  THANK YOU");
		printSymbol(22);
		}
	public static void main(String []args) {
		int choice;
		String fname;
		Scanner sc = new Scanner(System.in);
		showCard();
		System.out.println("Enter the name of the file: ");
		fname = sc.nextLine();
		ArrayList<ScoreCard> clients = InsuranceReader.readInfoFromTextFile(fname);
		if (clients == null) {
			System.out.println("No members were found");
		}
		do {
			showMenu();
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            if (choice == 1) {
		    System.out.println("");
                    System.out.println("Here is a list of all the members\n");
                    InsuranceReader.writeInfoToScreen(clients);
            } else if (choice == 2) {
            	
            } else if (choice == 3) {
            
            } else if (choice == 4) {

            } else if (choice == 5) {
            	
            } else if (choice == 6) {
            
            }	
            } while (choice != 7);
        showThanks();
        }
}
