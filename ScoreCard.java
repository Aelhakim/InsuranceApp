public class ScoreCard {
	private String name; // first last
	private String age; 
	private String height; //pounds
	private String weight; // inches
	private String sys;    // blood pressure sys and dia
	private String dia;
	private boolean cancer; 
	private boolean diabetes;
	private boolean alzheimers;
	public String getname() {
		return name;
		}
	public void setName(String name){
		this.name = name;
		}
	public String getAge() {
		return age;
		}
	public void setAge(String age) {
			this.age = age;
		}
	public String getHeight() {
		return height;
		}
	public void setHeight(String height) {
		this.height = height;
		}
	public String getWeight() {
		return weight;
		}
	public void setWeight(String weight) {
		this.weight = weight;
		}
	public String getSys() {
		return sys;
		}
	public void setSys(String sys) {
		this.sys = sys;
		}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public boolean isCancer() {
		return cancer;
		}
	public void setCancer(boolean cancer) {
		this.cancer = cancer;
		}
	public boolean isDiabetes() {
		return diabetes;
		}
	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
		}
	public boolean isAlzheimers() {
		return alzheimers;
		}
	public void setAlzheimers(boolean alzheimers) {
		this.alzheimers = alzheimers;
		}
	public ScoreCard() {
		name = "";
		age = "";
		height = "";
		weight = "";
		sys =  "";
		dia = "";
		}
	public ScoreCard(String name, String age, String height, String weight, String sys, String dia) {
		setName(name);
		setAge(age);
		setHeight(height);
		setWeight(weight);
		setSys(sys);	
		setDia(dia);
		}
		@Override
		public String toString() {
			return String.format("%-10s%-10s%-5s%-5s%-5s%-5s",name,age,height,weight,sys,dia);
			//name last first
			// age
			// height
			// weight
			// sys
			// dias
			// cancer
			// diabete
			// alzheimers
	}
}
