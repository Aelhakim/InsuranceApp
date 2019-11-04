	import java.util.*;
	import java.io.File;
	public class InsuranceReader {
		public static ArrayList<ScoreCard> readInfoFromTextFile(String fname) {
			try {
				Scanner fsc = new Scanner(new File(fname));
				String line;
				String name,age,height,weight,sys,dia;
				ArrayList<ScoreCard> info = new ArrayList<ScoreCard>();
				while (fsc.hasNextLine()) {
					line = fsc.nextLine().trim();
					info.add(parseDescription(line));
				}
				fsc.close();
				return info;
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}
		public static ScoreCard parseDescription(String text) {
			text = text.trim();
			String name,age,height,weight,sys,dia;
			String parts [] = text.split("\t");
			 name = parts [0];
			 age = parts [1];
			 height = parts[2];
			 weight = parts[3];
			 sys = parts [4];
			 dia = parts [5];
			 return new ScoreCard(name,age,height,weight,sys,dia);
		} 
		public static void writeInfoToScreen(ArrayList<ScoreCard> clients) {
			for (ScoreCard client : clients) {
				System.out.println(client);
			}
		}
	}
