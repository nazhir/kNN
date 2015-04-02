package knnImplementation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;

public class Read {

	public Read(){}
	public static void main(String args[]){
		
		
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(
			        new FileReader("trainProdSelection.arff"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Instances data = null;
		try {
			data = new Instances(reader);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// setting class attribute
		data.setClassIndex(data.numAttributes() - 1);
		
		//import the attributes i.e the 6 attributes given at the top of the production file
		List<Attribute> train_attributes=new ArrayList<Attribute>();
		Enumeration enumerated_attributes=data.enumerateAttributes();
		while(enumerated_attributes.hasMoreElements()){
			train_attributes.add((Attribute) enumerated_attributes.nextElement());
		}
		//System.out.println(attributes.get(0));
		
		//import the instances(row data) from the production file
		List<Instance> train_instance=new ArrayList<Instance>();
		Enumeration inst=data.enumerateInstances();
		while(inst.hasMoreElements())
		{
			train_instance.add((Instance) inst.nextElement());
		}
		/*System.out.println(train_instance.toString());
		System.out.println(list.size());
		System.out.println("first index:"+train_instance.get(0).stringValue(1));*/
		
		
		
		
		
		
		//-----------------------------------------------------------------------------------------------------------------
		//read test data
		
		
		try {
			reader = new BufferedReader(
			        new FileReader("testProdSelection.arff"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			data = new Instances(reader);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// setting class attribute
		data.setClassIndex(data.numAttributes() - 1);
		
		//import the attributes from the test set of data
				List<Attribute> test_attributes=new ArrayList<Attribute>();
				enumerated_attributes=data.enumerateAttributes();
				while(enumerated_attributes.hasMoreElements()){
					test_attributes.add((Attribute) enumerated_attributes.nextElement());
				}
				//System.out.println(attributes.get(0));
				
				//import the instances(row data) from the test data
				List<Instance> test_instance=new ArrayList<Instance>();
				inst=data.enumerateInstances();
				while(inst.hasMoreElements())
				{
					test_instance.add((Instance) inst.nextElement());
				}
				
				
				
				//columns to normalise 
				List<Integer> columns=new ArrayList<Integer>();
				Iterator<Attribute> i = test_attributes.iterator();
				int c=0;
				while(i.hasNext())
				{
					
					/*if(i.next().equals("real"))
						columns.add(c);*/
					String[] s = i.next().toString().split(" ");
					if(s[s.length-1].equals("numeric")) 
					{
						columns.add(c);
						//System.out.println(c);
					}
					c++;
					
				}
				
				
				
				//new array list for storing the normalised instances from test data
				List<Instance> test_normalised_instances=new ArrayList<Instance>();
				test_normalised_instances.addAll(test_instance);
				//System.out.println(test_normalised_instances.get(0));
				
				//new array list for storing the normalised isntances for train data
				List<Instance> train_normalised_instances=new ArrayList<Instance>();
				train_normalised_instances.addAll(train_instance);
				
				
				
				
				
				//Normalisation part
				//loop through every single row of the test data
				for(int i1=0;i1<test_instance.size();i1++)	
				
				//for(int i1=0;i1<1;i1++)			
						
				{
					double min=0,max=0;
					//loop through every single column that is numeric and needs to be normalised
					for(int z=0;z<columns.size();z++)
					{
						
						min=test_instance.get(i1).value(columns.get(z));
						max=test_instance.get(i1).value(columns.get(z));
						//loop through every single row of the train data
						for(int j=0;j<train_instance.size();j++)
						{
							double temp = train_instance.get(j).value(columns.get(z));
							
							if(temp<min)
								min=temp;
							if(temp>max)
								max=temp;
						}
						
						normalise_testdata(min,max,test_instance.get(i1),columns.get(z),test_normalised_instances,i1);
						normalise_traindata(min,max,columns.get(z),train_normalised_instances);
						
						
					}
					for(Instance d:train_normalised_instances)
						System.out.println(d);
					
					// you need to reset the normalised_instances to the previous state 
					
				}
			/*	
				for(Instance d:test_normalised_instances)
					System.out.println(d);
				*/
				
				
				
		}
	
	//normalise all the rows of the train data with respect to a single row of test data
	private static void normalise_traindata(double min, double max,
			Integer z, List<Instance> train_normalised_instances) {
		// TODO Auto-generated method stub
		double denominator=max-min;
		double val;
		for(int i=0;i<train_normalised_instances.size();i++)
		{
			val=(train_normalised_instances.get(i).value(z) - min) / denominator;
			train_normalised_instances.get(i).setValue(z, val);
		}
		
	}
	

	//normalise the row of test data
	private static void normalise_testdata(double min, double max, Instance instance,
			int z,List<Instance> normalised_instances,int index) {
		// TODO Auto-generated method stub
	//	System.out.println("min"+min+"max:"+max);
		double denominator=max-min;

		 double val = (normalised_instances.get(index).value(z) - min) / denominator;
		 	
		 normalised_instances.get(index).setValue(z, val);
		 
		
	}
	
	
}
