package knnImplementation;

import java.util.ArrayList;
import java.util.List;

import weka.core.Instance;

public class NormalizeData {
	//public static double min=0;
	//public static double max=0;
	public void normaliseHelper(double min, double max, Integer col, List<Instance> normInstances) {
		double denominator=max-min;
		double val;
		for(int i=0;i<normInstances.size();i++) {
			val=(normInstances.get(i).value(col) - min) / denominator;
			normInstances.get(i).setValue(col, val);
		}
		
	}
	
	public List<Instance> normalization (double[] minList, double[] maxList, ArrayList<Instance> instanceList, List<Integer> columns) {
		List<Instance> normInstances=new ArrayList<Instance>();
		normInstances.addAll(instanceList);
		//int min=0;
		//int max=0;
		
		for(int i=0;i<columns.size();i++) { //For each column, normalize it.
			normaliseHelper(minList[i], maxList[i], i, normInstances);
		}
		
		return normInstances;
	}

	public double[] findMin(ArrayList<Instance> trainInstances, ArrayList<Instance> testInstances, List<Integer> columns) {
		double[] minList=new double[columns.size()];
		double min=0;
		
		for(int i=0;i<columns.size();i++) { //For each column fins the min value.
		    for(int j=0;j<trainInstances.size();j++) {  //iterate all rows and find the min.
			    double temp = trainInstances.get(j).value(columns.get(i));
			    min=Math.min(min,temp);
		    }
		    for(int z=0;z<testInstances.size();z++) {  //iterate all rows and find the min.
			    double temp = testInstances.get(z).value(columns.get(i));
			    min=Math.min(min,temp);
		    }
		   minList[i]=min; //Record this min into list.
		}
		
		return minList;
	}
	
	public double[] findMax(ArrayList<Instance> trainInstances, ArrayList<Instance> testInstances, List<Integer> columns) {
		double[] maxList=new double[columns.size()];
		double max=0;
		
		for(int i=0;i<columns.size();i++) { //For each column fins the max value.
		    for(int j=0;j<trainInstances.size();j++) {  //iterate all rows and find the max.
			    double temp = trainInstances.get(j).value(columns.get(i));
			    max=Math.min(max,temp);
		    }
		    for(int j=0;j<testInstances.size();j++) {  //iterate all rows and find the max.
			    double temp = testInstances.get(j).value(columns.get(i));
			    max=Math.min(max,temp);
		    }
		   maxList[i]=max; //Record this min into list.
		}
		
		return maxList;
	}
}