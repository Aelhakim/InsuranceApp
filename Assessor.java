/**
 * @AntonioElhakim
 */
public class Assessor {

 //calc risk 
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

 //Score adder
    public static int score(Member m) {
        return  bpScore(m) + bmiScore(m)
                + ageScore(m) + m.getFamilyScore();
    }

//Blood pressure adder
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

//get BMI score
    private static int bmiScore(Member m) {
        int bmi = m.getBMI();
        if (bmi == Member.NORMAL) {
            return 0;
        } else if (bmi == Member.OVERWEIGHT) {
            return 30;
        }
        return 75;
    }

//calc age score
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
}
