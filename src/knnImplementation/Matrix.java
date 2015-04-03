package knnImplementation;

public class Matrix {
	
	public double serviceTypeMatrix (String t1, String t2){
		double sim = 0;
		
		if(t1.equals("Loan")){
			switch(t2.toLowerCase()){
			case "loan": 
				sim = 1;
				break;
			case "bank_account": 
				sim = 0;
			 	break;
			case "cd": 
				sim = 0.1;
			 	break;
			case "mortgage": 
				sim = 0.3;
			 	break;
			case "fund": 
				sim = 0.2;
			 	break;
			}			
		} else if (t1.equals("Bank_Account")) {
			switch(t2.toLowerCase()){
			case "loan": 
				sim = 0;
				break;
			case "bank_account": 
				sim = 1;
			 	break;
			case "cd": 
				sim = 0;
			 	break;
			case "mortgage": 
				sim = 0;
			 	break;
			case "fund": 
				sim = 0;
			 	break;
			}
		} else if (t1.equals("CD")) {
			switch(t2.toLowerCase()){
			case "loan": 
				sim = 0.1;
				break;
			case "bank_account": 
				sim = 0;
			 	break;
			case "cd": 
				sim = 1;
			 	break;
			case "mortgage": 
				sim = 0.2;
			 	break;
			case "fund": 
				sim = 0.2;
			 	break;
			}
		} else if (t1.equals("Mortgage")) {
			switch(t2.toLowerCase()) {
			case "loan": 
				sim = 0.3;
				break;
			case "bank_account": 
				sim = 0;
			 	break;
			case "cd": 
				sim = 0.2;
			 	break;
			case "mortgage": 
				sim = 1;
			 	break;
			case "fund": 
				sim = 0.1;
			 	break;
			}
		} else if (t1.equals("Fund")) {
			switch(t2.toLowerCase()) {
			case "loan": 
				sim = 0.2;
				break;
			case "bank_account": 
				sim = 0;
			 	break;
			case "cd": 
				sim = 0.2;
			 	break;
			case "mortgage": 
				sim = 0.1;
			 	break;
			case "fund": 
				sim = 1;
			 	break;
			}
		}
		
		return sim;		
	}
	
	public double customerMatrix (String t1, String t2){
		double sim = 0;
		
		if(t1.equals("Business")){
			switch(t2.toLowerCase()){
			case "business": 
				sim = 1;
				break;
			case "professional": 
				sim = 0.2;
			 	break;
			case "student": 
				sim = 0.1;
			 	break;
			case "doctor": 
				sim = 0.2;
			 	break;
			case "other": 
				sim = 0;
			 	break;
			}			
		} else if(t1.equals("Professional")){
			switch(t2.toLowerCase()){
			case "business": 
				sim = 0.2;
				break;
			case "professional": 
				sim = 1;
			 	break;
			case "student": 
				sim = 0.2;
			 	break;
			case "doctor": 
				sim = 0.1;
			 	break;
			case "other": 
				sim = 0;
			 	break;
			}			
		} else if(t1.equals("Student")){
			switch(t2.toLowerCase()){
			case "business": 
				sim = 0.1;
				break;
			case "professional": 
				sim = 0.2;
			 	break;
			case "student": 
				sim = 1;
			 	break;
			case "doctor": 
				sim = 0.1;
			 	break;
			case "other": 
				sim = 0;
			 	break;
			}			
		} else if(t1.equals("Doctor")){
			switch(t2.toLowerCase()){
			case "business": 
				sim = 0.2;
				break;
			case "professional": 
				sim = 0.1;
			 	break;
			case "student": 
				sim = 0.1;
			 	break;
			case "doctor": 
				sim = 1;
			 	break;
			case "other": 
				sim = 0;
			 	break;
			}			
		} else if(t1.equals("Other")){
			switch(t2.toLowerCase()){
			case "business": 
				sim = 0;
				break;
			case "professional": 
				sim = 0;
			 	break;
			case "student": 
				sim = 0;
			 	break;
			case "doctor": 
				sim = 0;
			 	break;
			case "other": 
				sim = 1;
			 	break;
			}
		}
		
		return sim;	
	}
	
	public double sizeMatrix (String t1, String t2){
		double sim = 0;
		
		if(t1.equals("Small")){
			switch(t2.toLowerCase()){
			case "small": 
				sim = 1;
				break;
			case "medium": 
				sim = 0.1;
			 	break;
			case "large": 
				sim = 0;
			 	break;
			}			
		} else if(t1.equals("Medium")){
			switch(t2.toLowerCase()){
			case "small": 
				sim = 0.1;
				break;
			case "medium": 
				sim = 1;
			 	break;
			case "large": 
				sim = 0.1;
			 	break;
			}			
		} else if(t1.equals("Large")){
			switch(t2.toLowerCase()){
			case "small": 
				sim = 0;
				break;
			case "medium": 
				sim = 0.1;
			 	break;
			case "large": 
				sim = 1;
			 	break;
			}			
		}
		
		return sim;
	}
	
	public double promotionMatrix (String t1, String t2){
		double sim = 0;
		
		if(t1.equals("Full")){
			switch(t2.toLowerCase()){
			case "full": 
				sim = 1;
				break;
			case "web&email": 
				sim = 0.8;
			 	break;
			case "web": 
				sim = 0;
			 	break;
			case "none": 
				sim = 0;
			 	break;
			}			
		} else if(t1.equals("Web&Email")){
			switch(t2.toLowerCase()){
			case "full": 
				sim = 0.8;
				break;
			case "web&email": 
				sim = 1;
			 	break;
			case "web": 
				sim = 0.1;
			 	break;
			case "none": 
				sim = 0.5;
			 	break;
			}  
		} else if(t1.equals("Web")){
			switch(t2.toLowerCase()){
			case "full": 
				sim = 0;
				break;
			case "web&email": 
				sim = 0.1;
			 	break;
			case "web": 
				sim = 1;
			 	break;
			case "none": 
				sim = 0.4;
			 	break;
			}  
		} else if(t1.equals("Full")){
			switch(t2.toLowerCase()){
			case "full": 
				sim = 0;
				break;
			case "web&email": 
				sim = 0.5;
			 	break;
			case "web": 
				sim = 0.4;
			 	break;
			case "none": 
				sim = 1;
			 	break;
			}  
		}
		
		return sim;
	}
		
}
