/**
 * The Calculator is the main application.
 * 
 * @author Monique Cauty
 * @author Antonio Elhakim
 * @author Dan Laskero
 * @author John Vercimak
 */
import java.util.ArrayList;

import java.util.Scanner;

/**********************************************************/
public class Calculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);    // read tab delimiter file
		showWelcomeMessage();
		ArrayList<Member> al = readFile(sc);   
		ArrayList<InsuranceScore> ises = new ArrayList<>();
		int selection;
		do {        
			selection = getUserSelection(sc);

			switch (selection) {
			case 1:
				listMember(al);
				break;
			case 2:
				al.add(Member.makeMember(sc));
				System.out.println("The new member has been added.");
				break;
			case 3:
				MemberWriter.write(al, sc);
				break;
			case 4:
				al.clear();
				al = MemberReader.load(sc);
				break;
			case 5:
				assessMember(al, ises);
				InsuranceScoreWriter.toScreen(ises);
				break;
			case 6:
				assessMember(al, ises);
				System.out.print("Enter name of JSON file: ");
				String fileName = sc.next();
				InsuranceScoreWriter.toJsonFile(ises, fileName);
				break;
			}
			System.out.println("");
		} while (selection != 7);
		showFinalMessage();
	}

	/**********************************************************/

	/**
	 * This function handles printing the departure message.
	 */
	private static void showFinalMessage() {
		System.out.println(""
				+ "****************************************\n"
				+ "         INSURANCE SCORE CARD\n"
				+ "               THANK YOU\n"
				+ "****************************************");
	}

	/**********************************************************/

	/**
	 * This function calculates assesses members
	 * 
	 * @param al
	 * @param ises
	 */
	private static void assessMember(ArrayList<Member> al,
			ArrayList<InsuranceScore> ises) {
		ises.clear();
		System.out.println("\nHere are the insurance assessments:");
		for (Member m : al) {
			InsuranceScore is = new InsuranceScore();
			is.setFname(m.getFname());
			is.setLname(m.getLname());
			is.setScore(Assessor.score(m));
			is.setVerdict(Assessor.risk(m));
			ises.add(is);
		}
	}

	/**********************************************************/

	/** 
	 * This function lists/prints all the members.
	 * @param al
	 */
	private static void listMember(ArrayList<Member> al) {
		if (al != null) {
			for (Member member : al) {
				System.out.println(member.toString());
			}
		}
	}

	/**********************************************************/

	/**
	 * This function handles listing the menu options and
	 * getting the user's selection.
	 * 
	 * @param sc
	 * @return
	 */
	private static int getUserSelection(Scanner sc) {
		System.out.print("\n"
				+ "Here are your choices:\n"
				+ "        1. List members\n"
				+ "        2. Add a new member\n"
				+ "        3. Save members\n"
				+ "        4. Load members\n"
				+ "        5. Assess members\n"
				+ "        6. Save assessments as JSON\n"
				+ "        7. Exit\n"
				+ "Please enter your choice: ");
		return sc.nextInt();
	}

	/**********************************************************/

	/** This function handles reading the initial file
	 * 
	 * @param sc
	 * @return al
	 */
	private static ArrayList<Member> readFile(Scanner sc) {
		System.out.print("Enter name of member file: ");
		String fileName = sc.next();
		ArrayList<Member> al = MemberReader.readTabFile(fileName);
		System.out.println(al.size() + " members were read.");
		return al;
	}

	/**********************************************************/

	/**
	 * This function handles printing the welcome message
	 */
	private static void showWelcomeMessage() {
		System.out.println(""
				+ "****************************************\n"
				+ "         INSURANCE SCORE CARD\n"
				+ "  This app scores a potential customer\n"
				+ "  on various health attributes: blood\n"
				+ "  pressure, age, height, weight, and\n"
				+ "  family history of disease. It writes\n"
				+ "  each member's insurance grade to a\n"
				+ "  JSON file so that they can be easily\n"
				+ "  shared on a web-based data exchange.\n"
				+ "\n"
				+ "****************************************");
	}
}
