 /**
 * MemberReader will read through a text file and add members.
 * 
 * @author Monique Cauty
 * @author Antonio Elhakim
 * @author Dan Laskero
 * @author John Vercimak
 *
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class MemberReader {

	/**********************************************************/
	/**
	 * This function's purpose is to load the data from a file.
	 * The user will be prompted to enter a filetype of their choice, 
	 * and then enter the name of the file they wish to load.
	 * 
	 * @param - sc
	 * @return - ArrayList of members
	 */
	public static ArrayList<Member> load(Scanner sc) {
		System.out.print("(T)ext, (B)inary, or (X)ML? ");
        String type = sc.next();
        System.out.print("Enter name of input file: ");
        String fileName = sc.next();
        ArrayList<Member> al = null;
        try {
            switch (type.toUpperCase()) {
                case "T":
                    al = readTabFile(fileName);
                    System.out.println(al.size() + " members were read.");
                    break;
                case "B":
                    al = readBinaryFile(fileName);
                    System.out.println(al.size() + " members were read.");
                    break;
                case "X":
                    al = readXMLFile(fileName);
                    System.out.println(al.size() + " members were read.");
                    break;
                default:
                    break;
            }
        } catch (IOException | ClassNotFoundException | JAXBException e) {
            System.out.println(e.getMessage());
        }

        return al;
	}

	/**********************************************************/
	/**
	 * readXMLFile load data from xml file
	 * 
	 * @param fileName
	 * @return 
	 */
	public static ArrayList<Member> readXMLFile(String fileName) throws JAXBException {
		File file = new File(fileName);
		JAXBContext jaxbContext = JAXBContext.newInstance(Members.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Members members = (Members) jaxbUnmarshaller.unmarshal(file);        
		return (ArrayList<Member>) members.members;
	}
	/**********************************************************/
	/**
	 * readBinaryFile will load data from a binary file  
	 * 
	 * @param fileName
	 * @return 
	 */
	public static ArrayList<Member> readBinaryFile(String fileName)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fileinput = new FileInputStream(new File(fileName));
        ObjectInputStream object = new ObjectInputStream(fileinput);
        Members member = (Members) object.readObject();   // read the whole object
        object.close();
        fileinput.close();
        return (ArrayList<Member>) member.getMembers();
	}

	/**********************************************************/
	/**
	 * readTabFile will read text file specified by the user
	 * and add members based on the contents of the file.
	 * 
	 * @param fileName
	 * @return - ArrayList of members
	 */
	public static ArrayList<Member> readTabFile(String fileName) {
		ArrayList<Member> al = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(new File(fileName));
            String firstname;
            String lastname;
            int age;
            int ht;
            int wt;
            int bpSyst;
            int bpDias;
            String cancer;
            String diabetes;
            String alzheimers;
            while (scanner.hasNext()) {
                Member member = new Member();
                firstname = scanner.next();
                lastname = scanner.next();
                age = scanner.nextInt();
                ht = scanner.nextInt();
                wt = scanner.nextInt();
                bpSyst = scanner.nextInt();
                bpDias = scanner.nextInt();
                cancer = scanner.next();
                diabetes = scanner.next();
                alzheimers = scanner.next();
                
                member.setAge(age);
                member.setAlzheimers(alzheimers);
                member.setBpDias(bpDias);
                member.setBpSyst(bpSyst);
                member.setCancer(cancer);
                member.setDiabetes(diabetes);
                member.setFname(firstname);
                member.setHeight(ht);
                member.setLname(lastname);
                member.setWeight(wt);        

				al.add(member);
			}
			scanner.close();
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		return al;
	}
	/**********************************************************/

}