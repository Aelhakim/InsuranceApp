/**
 * The Assessor class exists to determine the risk for 
 * each member.  Assessor will also create an InsuranceScore object 
 * that expresses the risk for each member.
 * 
 * @author Monique Cauty
 * @author Antonio Elhakim
 * @author Dan Laskero
 * @author John Vercimak
 */

public class Assessor {

	/****************************************************/
	/**
	 * This function calculates the risk
	 * based on a member's score.
	 * 
	 * @param member
	 * @return the risk of the member
	 */
	public static String risk(Member m) {
		int score = Assessor.score(m);
		if (score <= 20) {
			return "low risk";
		}
		if (score <= 50) {
			return "moderate risk";
		}
		if (score <= 75) {
			return "high risk";
		}
		return "uninsurable";
	}

	/****************************************************/
	/**
	 * This function will tally up and add the points
	 * to calculate a score for the user.
	 * 
	 * @param member
	 * @return the score
	 */
	public static int score(Member m) {
		return  bpScore(m) + bmiScore(m)
		+ ageScore(m) + m.getFamilyScore();
	}

	/****************************************************/
	/**
	 * This function will add up the points determined
	 * from their blood pressure
	 * 
	 * @param member
	 * @return blood pressure score
	 */
	private static int bpScore(Member m) {
		int bp = m.getBloodPressure();
		if(bp == Member.NORMAL)
			return 0;
		if(bp == Member.ELEVATED)
			return 15;
		if(bp == Member.STAGE1)
			return 30;
		if(bp == Member.STAGE2)
			return 75;
		else
			return 100;
	}

	/****************************************************/
	/**
	 * This function calculates the score for a member's
	 * Body Mass Index (BMI)
	 * 
	 * @param member
	 * @return BMI score
	 */
	private static int bmiScore(Member m) {
		int bmi = m.getBMI();
		if (bmi == Member.NORMAL) {
			return 0;
		} else if (bmi == Member.OVERWEIGHT) {
			return 30;
		}
		return 75;
	}

	/****************************************************/
	/**
	 * This function calculates the score based on a 
	 * member's age.
	 * 
	 * @param member
	 * @return age score
	 */
	private static int ageScore(Member m) {
		if (m.getAge() < 30) {
			return 0;
		}
		if (m.getAge() < 45) {
			return 10;
		}
		if (m.getAge() < 60) {
			return 20;
		}
		return 30;
	}
	/****************************************************/

}
