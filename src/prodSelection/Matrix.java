package prodSelection;

public class Matrix {
	
	public double typeMatrix (String t1, String t2){
		double sim = 0;
		if(t1.equals(t2)){
			sim = 1;
		}
		return sim;		
	}
	
	public double lifeStyle (String t1, String t2){
		double sim = 0;
		if(t1.equals(t2)){
			sim = 1;
		}
		return sim;		
	}
}
