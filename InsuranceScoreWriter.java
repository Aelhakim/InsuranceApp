/**
 * InsuranceScoreWriter handles writing scores to the screen
 * as well as writing scores to a Json file.
 * 
 * @author Monique Cauty
 * @author Antonio Elhakim
 * @author Dan Laskero
 * @author John Vercimak
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class InsuranceScoreWriter {

	/**********************************************************/
	/**
	 * toScreen prints the scores neatly
	 * 
	 * @param ises
	 */
	public static void toScreen(ArrayList<InsuranceScore> ises) {
		for (InsuranceScore is : ises) {
			System.out.println(is.toString());
			System.out.println("");
		}
	}

	/**********************************************************/
	/** 
	 * toJsonFile writes the scores to a Json file
	 * 
	 * @param ises
	 * @param fileName
	 */
	public static void toJsonFile(ArrayList<InsuranceScore> ises,
			String fileName) {
		FileWriter fw;
		try {
			fw = new FileWriter(fileName);
			fw.write("{\"InsuranceScore\":[" + System.lineSeparator());

			if (ises.isEmpty() == false) {
				fw.write(ises.get(0).toJsonString()
						+ System.lineSeparator());                
			}            
			for (int i = 1; i < ises.size(); i++) {                
				fw.write(", " + ises.get(i).toJsonString()   // json separated by a comma 
						+ System.lineSeparator());                
			}
			fw.write("]}");
			fw.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	/**********************************************************/
}

