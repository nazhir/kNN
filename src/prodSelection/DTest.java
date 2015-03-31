package prodSelection;

public class DTest {
	private String type;
	private String lifeStyle;
	private double vacation;
	private double eCredit;
	private double salary;
	private double property;
	private String label;
	
	public DTest(String type, String lifeStyle, double vacation, double eCredit, double salary,double property){
		this.type = type;
		this.lifeStyle = lifeStyle;
		this.vacation = vacation;
		this.eCredit = eCredit;
		this.salary = salary;
		this.property = property;
	}
	
	public String getType(){
		return this.type;
	}
	
	public String getLifeStyle(){
		return this.lifeStyle;
	}
	
	public double getVacation(){
		return this.vacation;
	}
	
	public double getECredit(){
		return this.eCredit;
	}
	
	public double getSalary(){
		return this.salary;
	}
	
	public double getProperty(){
		return this.property;
	}
	
	public String getLabel(){
		return this.label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
}
