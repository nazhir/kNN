package knnImplementation;

import java.util.ArrayList;
import java.util.List;

import weka.core.Instance;

public class normalizeData {
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

	public double[] findMin(ArrayList<Instance> instanceList, List<Integer> columns) {
		double[] minList=new double[2];
		double min=0;
		
		for(int i=0;i<columns.size();i++) { //For each column fins the min value.
		    for(int j=0;j<instanceList.size();j++) {  //iterate all rows and find the min.
			    double temp = instanceList.get(j).value(columns.get(i));
			    min=Math.min(min,temp);
		    }
		   minList[i]=min; //Record this min into list.
		}
		
		return minList;
	}
	
	public double[] findMax(ArrayList<Instance> instanceList, List<Integer> columns) {
		double[] maxList=new double[2];
		double max=0;
		
		for(int i=0;i<columns.size();i++) { //For each column fins the max value.
		    for(int j=0;j<instanceList.size();j++) {  //iterate all rows and find the max.
			    double temp = instanceList.get(j).value(columns.get(i));
			    max=Math.min(max,temp);
		    }
		   maxList[i]=max; //Record this min into list.
		}
		
		return maxList;
	}
}
