/**
 * @AntonioElhakim
 */
import java.io.Serializable;
import java.util.Scanner;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


// for xml writting
@XmlRootElement(name = "member")
@XmlAccessorType(XmlAccessType.FIELD)
public class Member implements Serializable {

    private String fname;
    private String lname;
    private int age;
    private int height;
    private int weight;
    private int bpSyst;
    private int bpDias;
    private String cancer;
    private String diabetes;
    private String alzheimers;
    
    public static final int UNKNOWN = 0;
    public static final int NORMAL = 1;
    public static final int OVERWEIGHT = 2;
    public static final int OBESITY = 3;
    public static final int ELEVATED = 4;
    public static final int STAGE1 = 5;
    public static final int STAGE2 = 6;
    public static final int CRISIS = 7;

//Tostringwithtabs
    public String toStringWithTab() {
        String exp = fname + "\t";
        exp += lname + "\t";
        exp += age + "\t";
        exp += height + "\t";
        exp += weight + "\t";
        exp += bpSyst + "\t";
        exp += bpDias + "\t";
        exp += cancer + "\t";
        exp += diabetes + "\t";
        exp += alzheimers;
        return exp;
    }

//normal Tostring
    @Override
    public String toString() {
        String exp = lname + ", " + fname + System.lineSeparator();
        exp += String.format("%-12s%4d", "Age", age)
                + System.lineSeparator();
        exp += String.format("%-12s%4d in", "Height", height)
                + System.lineSeparator();
        exp += String.format("%-12s%4d lbs", "Weight", weight)
                + System.lineSeparator();
        exp += String.format("%-12s%4d", "BP Syst", bpSyst)
                + System.lineSeparator();
        exp += String.format("%-12s%4d", "BP Dias", bpDias)
                + System.lineSeparator();
        exp += String.format("%-12s%4s", "Cancer", cancer)
                + System.lineSeparator();
        exp += String.format("%-12s%4s", "Diabetes", diabetes)
                + System.lineSeparator();
        exp += String.format("%-12s%4s", "Alzheimers", alzheimers)
                + System.lineSeparator();
        exp += "-----------------------";
        return exp;
    }
    
//Family Score
    public int getFamilyScore(){
        int score = 0;
        if (cancer.equals("y")) {
            score += 10;
        }
        if (diabetes.equals("y")) {
            score += 10;
        }
        if (alzheimers.equals("y")) {
            score += 10;
        }
        return score;
    }
    
//blood pressure
    public int getBloodPressure(){
        if (bpSyst < 120 && bpDias < 80) {
            return NORMAL;
        }
        if (bpSyst <= 129 && bpDias < 80) {
            return ELEVATED;
        }
        if (bpSyst <= 129 || bpDias <= 89) {
            return STAGE1;
        }
        if (bpSyst >= 100 || bpDias >= 120) {
            return STAGE2;
        }
        return CRISIS;
    }
    
//BMI 
    public int getBMI() {
        double bmi = 703.0 * weight / (height * height);
        int result = UNKNOWN;
        if (bmi < 18.5) {
        } else if (bmi < 25.0) {
            result = NORMAL;
        } else if (bmi < 30.0) {
            result = OVERWEIGHT;
        } else if (bmi < 35.0) {
            result = OBESITY;
        }
        return result;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getBpSyst() {
        return bpSyst;
    }

    public int getBpDias() {
        return bpDias;
    }

    public String getCancer() {
        return cancer;
    }

    public String getDiabetes() {
        return diabetes;
    }

    public String getAlzheimers() {
        return alzheimers;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setBpSyst(int bpSyst) {
        this.bpSyst = bpSyst;
    }

    public void setBpDias(int bpDias) {
        this.bpDias = bpDias;
    }

    public void setCancer(String cancer) {
        this.cancer = cancer;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    public void setAlzheimers(String alzheimers) {
        this.alzheimers = alzheimers;
    }

//object to Make a member
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
