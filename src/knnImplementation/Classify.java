package knnImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Iterator;

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
	
	public HashMap<Integer,Double> distanceList (Instance testData, ArrayList<Instance> trainInstances, ArrayList<Integer> columns) {
		
		HashMap<Integer,Double> map=new HashMap <Integer, Double>();
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
	public LinkedHashMap<Integer,Double> sorting(HashMap<Integer,Double> passedMap) {
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
	
	public void setLabel(HashMap<Integer,Double> passedMap, ArrayList<Instance> trainInstances, ArrayList<Instance> testInstances) {
		
	}
	
}
