    /**
 * @AntonioElhakim
 */
    public static final int UNKNOWN = 0;
    public static final int NORMAL = 1;
    public static final int OVERWEIGHT = 2;
    public static final int OBESITY = 3;
    
    public static final int ELEVATED = 4;
    public static final int STAGE1 = 5;
    public static final int STAGE2 = 6;
    public static final int CRISIS = 7;
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

/// makes members
	public static Member makeMember(Scanner sc) {
        Member m = new Member();
        System.out.print("Enter first and last name: ");
        m.fname = sc.next();
        m.lname = sc.next();
        System.out.print("Enter age: ");
        m.age = sc.nextInt();
        System.out.print("Enter height in inches: ");
        m.height = sc.nextInt();
        System.out.print("Enter weight in pounds: ");
        m.weight = sc.nextInt();
        System.out.print("Enter blood pressure (sys and dia): ");
        m.bpSyst = sc.nextInt();
        m.bpDias = sc.nextInt();
        System.out.println("Has a family member had ...");
        System.out.print("Cancer? ");
        m.cancer = sc.next().toLowerCase();
        System.out.print("Diabetes? ");
        m.diabetes = sc.next().toLowerCase();
        System.out.print("Alzheimers? ");
        m.alzheimers = sc.next().toLowerCase();

        return m;
    }
}
