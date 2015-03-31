package prodIntro;

public class Matrix {
	
	public double serviceTypeMatrix (String t1, String t2){
		double sim = 0;
		
		if(t1.equals("Loan")){
			switch(t2){
			case "Loan": 
				sim = 1;
				break;
			case "Bank_Account": 
				sim = 0;
			 	break;
			case "CD": 
				sim = 0.1;
			 	break;
			case "Mortgage": 
				sim = 0.3;
			 	break;
			case "Fund": 
				sim = 0.2;
			 	break;
			}			
		} else if (t1.equals("Bank_Account")) {
			switch(t2){
			case "Loan": 
				sim = 0;
				break;
			case "Bank_Account": 
				sim = 1;
			 	break;
			case "CD": 
				sim = 0;
			 	break;
			case "Mortgage": 
				sim = 0;
			 	break;
			case "Fund": 
				sim = 0;
			 	break;
			}
		} else if (t1.equals("CD")) {
			switch(t2){
			case "Loan": 
				sim = 0.1;
				break;
			case "Bank_Account": 
				sim = 0;
			 	break;
			case "CD": 
				sim = 1;
			 	break;
			case "Mortgage": 
				sim = 0.2;
			 	break;
			case "Fund": 
				sim = 0.2;
			 	break;
			}
		} else if (t1.equals("Mortgage")) {
			switch(t2) {
			case "Loan": 
				sim = 0.3;
				break;
			case "Bank_Account": 
				sim = 0;
			 	break;
			case "CD": 
				sim = 0.2;
			 	break;
			case "Mortgage": 
				sim = 1;
			 	break;
			case "Fund": 
				sim = 0.1;
			 	break;
			}
		} else if (t1.equals("Fund")) {
			switch(t2) {
			case "Loan": 
				sim = 0.2;
				break;
			case "Bank_Account": 
				sim = 0;
			 	break;
			case "CD": 
				sim = 0.2;
			 	break;
			case "Mortgage": 
				sim = 0.1;
			 	break;
			case "Fund": 
				sim = 1;
			 	break;
			}
		}
		
		return sim;		
	}
	
	public double customerMatrix (String t1, String t2){
		double sim = 0;
		
		if(t1.equals("Business")){
			switch(t2){
			case "Business": 
				sim = 1;
				break;
			case "Professional": 
				sim = 0.2;
			 	break;
			case "Student": 
				sim = 0.1;
			 	break;
			case "Doctor": 
				sim = 0.2;
			 	break;
			case "Other": 
				sim = 0;
			 	break;
			}			
		} else if(t1.equals("Professional")){
			switch(t2){
			case "Business": 
				sim = 0.2;
				break;
			case "Professional": 
				sim = 1;
			 	break;
			case "Student": 
				sim = 0.2;
			 	break;
			case "Doctor": 
				sim = 0.1;
			 	break;
			case "Other": 
				sim = 0;
			 	break;
			}			
		} else if(t1.equals("Student")){
			switch(t2){
			case "Business": 
				sim = 0.1;
				break;
			case "Professional": 
				sim = 0.2;
			 	break;
			case "Student": 
				sim = 1;
			 	break;
			case "Doctor": 
				sim = 0.1;
			 	break;
			case "Other": 
				sim = 0;
			 	break;
			}			
		} else if(t1.equals("Doctor")){
			switch(t2){
			case "Business": 
				sim = 0.2;
				break;
			case "Professional": 
				sim = 0.1;
			 	break;
			case "Student": 
				sim = 0.1;
			 	break;
			case "Doctor": 
				sim = 1;
			 	break;
			case "Other": 
				sim = 0;
			 	break;
			}			
		} else if(t1.equals("Other")){
			switch(t2){
			case "Business": 
				sim = 0;
				break;
			case "Professional": 
				sim = 0;
			 	break;
			case "Student": 
				sim = 0;
			 	break;
			case "Doctor": 
				sim = 0;
			 	break;
			case "Other": 
				sim = 1;
			 	break;
			}
		}
		
		return sim;	
	}
	
	public double sizeMatrix (String t1, String t2){
		double sim = 0;
		
		if(t1.equals("Small")){
			switch(t2){
			case "Small": 
				sim = 1;
				break;
			case "Medium": 
				sim = 0.1;
			 	break;
			case "Large": 
				sim = 0;
			 	break;
			}			
		} else if(t1.equals("Medium")){
			switch(t2){
			case "Small": 
				sim = 0.1;
				break;
			case "Medium": 
				sim = 1;
			 	break;
			case "Large": 
				sim = 0.1;
			 	break;
			}			
		} else if(t1.equals("Large")){
			switch(t2){
			case "Small": 
				sim = 0;
				break;
			case "Medium": 
				sim = 0.1;
			 	break;
			case "Large": 
				sim = 1;
			 	break;
			}			
		}
		
		return sim;
	}
	
	public double promotionMatrix (String t1, String t2){
		double sim = 0;
		
		if(t1.equals("Full")){
			switch(t2){
			case "Full": 
				sim = 1;
				break;
			case "Web&Email": 
				sim = 0.8;
			 	break;
			case "Web": 
				sim = 0;
			 	break;
			case "None": 
				sim = 0;
			 	break;
			}			
		} else if(t1.equals("Web&Email")){
			switch(t2){
			case "Full": 
				sim = 0.8;
				break;
			case "Web&Email": 
				sim = 1;
			 	break;
			case "Web": 
				sim = 0.1;
			 	break;
			case "None": 
				sim = 0.5;
			 	break;
			}  
		} else if(t1.equals("Web")){
			switch(t2){
			case "Full": 
				sim = 0;
				break;
			case "Web&Email": 
				sim = 0.1;
			 	break;
			case "Web": 
				sim = 1;
			 	break;
			case "None": 
				sim = 0.4;
			 	break;
			}  
		} else if(t1.equals("Full")){
			switch(t2){
			case "Full": 
				sim = 0;
				break;
			case "Web&Email": 
				sim = 0.5;
			 	break;
			case "Web": 
				sim = 0.4;
			 	break;
			case "None": 
				sim = 1;
			 	break;
			}  
		}
		
		return sim;
	}
		
}
