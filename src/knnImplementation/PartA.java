package knnImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import weka.core.Attribute;
import weka.core.Instance;

public class PartA {
	public static void main (String[] args) {
		List<ArrayList> trainList=new ArrayList<ArrayList>();
		List<ArrayList> testList=new ArrayList<ArrayList>();
    	ArrayList<Instance> trainInstances=new ArrayList<Instance>();
    	ArrayList<Instance> testInstances=new ArrayList<Instance>();
    	
    	ArrayList<Attribute> attributes=new ArrayList<Attribute>();
    	//ArrayList<Attribute> testAttri=new ArrayList<Attribute>();
    	ArrayList<Integer> columns=new ArrayList<Integer>();
    	
    	/*read data*/
		ReadData getData=new ReadData();	
		trainList=getData.read("trainProdSelection.arff");
		testList=getData.read("testProdSelection.arff");
		trainInstances=(ArrayList<Instance>)trainList.get(0);
		testInstances=(ArrayList<Instance>)testList.get(0);
		
		attributes=(ArrayList<Attribute>)trainList.get(1);
		
		/*Get columns   */
		columns=getData.getNormColumns(attributes);
		//System.out.println(trainInstances.get(0).toString());
		
		/*Find the min and max value */
		NormalizeData norm= new NormalizeData();
		double[] minList=norm.findMin(trainInstances,testInstances, columns);
		double[] maxList=norm.findMax(trainInstances, testInstances, columns);
		
		/* Normalize the data */
			trainInstances=norm.normalization(minList, maxList, trainInstances, columns);
			testInstances=norm.normalization(minList, maxList, testInstances, columns);
		//for(Instance inst:trainInstances ) System.out.println(inst);
		
		/* Calculate the distance and sorting*/
		Classify classify=new Classify();
		LinkedHashMap<Integer,Double> map;
		for(Instance test: testInstances) {
			map=classify.distanceList(test, trainInstances, columns);
			map=classify.sorting(map);
			/* Find the TOP3 and setLabel */
			classify.setLabel(map, trainInstances, test);
			System.out.println(test);
		}
			
	}
}
