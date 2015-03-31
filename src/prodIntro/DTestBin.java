package prodIntro;

public class DTestBin {
	private String serviceType;
	private String customer;
	private double monthlyFee;
	private double advertisementBudget;
	private String size;
	private String promotion;
	private double interestRate;
	private double period;
	private int label;
	
	public DTestBin(String serviceType, String customer, double monthlyFee, double advertisementBudget, String size, String promotion
					 , double interestRate, double period)
		{
			this.serviceType = serviceType;
			this.customer = customer;
			this.monthlyFee = monthlyFee;
			this.advertisementBudget = advertisementBudget;
			this.size = size;
			this.promotion = promotion;
			this.interestRate = interestRate;
			this.period = period;
		}
	
	public String getServiceType(){
		return this.serviceType;
	}
	
	public String getCustomer(){
		return this.customer;
	}
	
	public double monthlyFee(){
		return this.monthlyFee;
	}
	
	public double advertisementBudget(){
		return this.advertisementBudget;
	}
	
	public String size(){
		return this.size;
	}
	
	public String promotion(){
		return this.promotion;
	}

	public double interestRate(){
		return this.interestRate;
	}
	
	public double period(){
		return this.period;
	}
	
	public int label(){
		return this.label;
	}
	
	public void setLabel(int label) {
		this.label = label;
	}
}
