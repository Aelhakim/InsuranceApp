/**
 * InsuranceScore object, made for each member
 * 
 * @author Monique Cauty
 * @author Antonio Elhakim
 * @author Dan Laskero
 * @author John Vercimak
 *
 */
public class InsuranceScore {    // the name, score, and risk level 
	private String fname;
	private String lname;
	private int score;
	private String verdict;

	/**********************************************************/
	//Json toString
	public String toJsonString() {
		String json = "{" + System.lineSeparator();
		json += "\t\"InsuranceScore\":{";
		json += "\t\t\"fname\":\"" + fname + "\"," + System.lineSeparator();
		json += "\t\t\"lname\":\"" + lname + "\"," + System.lineSeparator();
		json += "\t\t\"score\":\"" + score + "\"," + System.lineSeparator();
		json += "\t\t\"verdict\":\"" + verdict + "\"" + System.lineSeparator();
		json += "\t}" + System.lineSeparator();
		json += "}";
		return json;
	}

	/**********************************************************/
	/**
	 * toString for printing the verdict
	 */
	@Override
	public String toString() {
		String exp = "";
		exp += String.format("%-20s%15s\n", "Name:", lname + ", " + fname);
		exp += String.format("%-20s%15d\n", "Score:", score);
		exp += String.format("%-20s%15s", "Verdict:", verdict);
		return exp;
	}

	/**********************************************************/
	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public int getScore() {
		return score;
	}

	public String getVerdict() {
		return verdict;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setVerdict(String verdict) {
		this.verdict = verdict;
	}
	/**********************************************************/


}
