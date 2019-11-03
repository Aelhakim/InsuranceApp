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
		public static void showThanks() {
				printSymbol(22);
				System.out.println("             INSUREANCE SCORE CARD");
				System.out.println("                  THANK YOU");
				printSymbol(22);
			}
	public static void main(String []args) {
		int choice;
		Scanner sc = new Scanner(System.in);
        do {
            showMenu();
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            if (choice == 1) {
            	
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
}
