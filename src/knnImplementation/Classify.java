package knnImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import weka.core.Attribute;
import weka.core.Instance;

public class Classify {
/*
 * 1. Read data from file
 * 2. Get normalized columns
 * 3. Find min and max value
 * 4. Normalize the instance list
 * 5. Calculate the distance
 */
	
	public LinkedHashMap<Integer,Double> distanceList (Instance testData, ArrayList<Instance> trainInstances, ArrayList<Integer> columns) {
		
		LinkedHashMap<Integer,Double> map=new LinkedHashMap <Integer, Double>();
		double distance=0;
		int sim_type=0;
		int sim_style=0;
		//for(Instance test: testInstances) {//For each row of testData
			for (int i=0; i<trainInstances.size();i++){ //For each row of trainData
				for(int j: columns) { //For numeric attributes.
					distance+=Math.pow(testData.value(j)-trainInstances.get(i).value(j), 2);
				}
				if(testData.stringValue(0).equals(trainInstances.get(i).stringValue(0))) sim_type=1;
				if(testData.stringValue(1).equals(trainInstances.get(i).stringValue(0))) sim_style=1;
				distance+=Math.pow(1-sim_type,2)+Math.pow(1-sim_style,2);
				distance=1/Math.pow(distance, 0.5);
				map.put(i,distance);
			}
		//}
	
		return map;
		
	}
	public LinkedHashMap<Integer,Double> sorting(LinkedHashMap<Integer,Double> passedMap) {
		   ArrayList mapKeys = new ArrayList(passedMap.keySet());
		   ArrayList mapValues = new ArrayList(passedMap.values());
		   Collections.sort(mapValues);
		   Collections.sort(mapKeys);

		   LinkedHashMap<Integer,Double> sortedMap = new LinkedHashMap<Integer,Double>();

		   Iterator<Double> valueIt = mapValues.iterator();
		   while (valueIt.hasNext()) {
		       Object val = valueIt.next();
		       Iterator<Integer> keyIt = mapKeys.iterator();

		       while (keyIt.hasNext()) {
		           Object key = keyIt.next();
		           double comp1 = passedMap.get(key);
		           double comp2 =(double) val;

		           if (comp1==comp2){
		               passedMap.remove(key);
		               mapKeys.remove(key);
		               sortedMap.put((Integer)key, (Double)val);
		               break;
		           }

		       }

		   }
		   return sortedMap;
		}
	
	public void setLabel(LinkedHashMap<Integer,Double> sortedMap, ArrayList<Instance> trainInstances, Instance testData) {
	    double dis3=0;
		HashMap<Integer,Double> list=new LinkedHashMap<Integer,Double>();
		int index=0;
		/*Get the top3 distance*/
		for(Map.Entry<Integer, Double> entry: sortedMap.entrySet()) { 
			if(index==2) dis3=entry.getValue();
			if(index>2) { //Judge whether the value(distance) is same with the 3rd one.
				if(entry.getValue()!=dis3) break; 				
			}
			list.put(entry.getKey(),entry.getValue()); 
			index++;
		}
		/* For each element in map list, find its label */
		double[] labels=new double[5];
		double max=0;
		int indice=0;
		for(Map.Entry<Integer, Double> entry: list.entrySet()) {
			String label=trainInstances.get(entry.getKey()).stringValue(6);
			switch(label) {
			    case "C1": labels[0]+=entry.getValue(); break;
			    case "C2": labels[1]+=entry.getValue(); break;
			    case "C3": labels[2]+=entry.getValue(); break;
			    case "C4": labels[3]+=entry.getValue(); break;
			    case "C5": labels[4]+=entry.getValue(); break;
			}
			
		}
		/* Find maximum label*/
		for (int i=1;i<5;i++) {
			if(labels[i]>max) indice=i;
		}
		String label="";
		switch(indice+1) {
		    case 1: label="C1"; break;
		    case 2: label="C2"; break;
		    case 3: label="C3"; break;
		    case 4: label="C4"; break;
		    case 5: label="C5"; break;
		}
		testData.setValue(6, label);
		
	}
	
}
