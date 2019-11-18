/**
 /**
 * MemberWriter handles writing data to different files/filetypes.
 * 
 * @author Monique Cauty
 * @author Antonio Elhakim
 * @author Dan Laskero
 * @author John Vercimak
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;

public class MemberWriter {

	/**********************************************************/
	/**
	 * write() will write members to an output file with a 
	 * filetype specified by the user.
	 * 
	 * @param al
	 * @param sc
	 */
	public static void write(ArrayList<Member> al, Scanner sc) {
		System.out.print("(T)ext, (B)inary, or (X)ML? ");
		String type = sc.next();
		System.out.print("Enter name of output file: ");
		String fileName = sc.next();
		System.out.println("");
		try {
			switch (type) {
			case "T":
				writeText(al, fileName);
				System.out.println("Members were written successfully.");
				break;
			case "B":
				writeBinary(al, fileName);
				System.out.println("Members were written successfully.");
				break;
			case "X":
				writeXML(al, fileName);
				System.out.println("Members were written successfully.");
				break;
			default:
				break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************/
	/**
	 * writeXML will write data to an xml file  
	 * 
	 * @param al
	 * @param fileName
	 * @throws JAXBException
	 */
	private static void writeXML(ArrayList<Member> al, String fileName) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(Members.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		Members m = new Members();
		m.setMembers(al);
		jaxbMarshaller.marshal(m, new File(fileName));    
	}

	/**********************************************************/
	/**
	 * writeBinary will write data to binary file 
	 * 
	 * @param al
	 * @param fileName
	 */
	private static void writeBinary(ArrayList<Member> al, String fileName)
			throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream(new File(fileName));
		ObjectOutputStream os = new ObjectOutputStream(fos);
		Members m = new Members();
		m.setMembers(al);
		os.writeObject(m);        
		os.close();
		fos.close();
	}

	/**********************************************************/
	/**
	 * writeText will write data to a text file
	 * 
	 * @param al
	 * @param fileName
	 * @throws IOException
	 */
	private static void writeText(ArrayList<Member> al, String fileName) throws IOException {
		FileWriter fw = new FileWriter(fileName);
		for (Member member : al) {
			fw.write(member.toStringWithTab() + System.lineSeparator());
		}
		fw.close();
	}
	/**********************************************************/
}
