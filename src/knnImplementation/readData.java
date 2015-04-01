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

public class readData {
    public List<ArrayList> read(String file) {
    	List<ArrayList> list=new ArrayList<ArrayList>();
    	ArrayList<Instance> instanceList=new ArrayList<Instance>();
    	ArrayList<Attribute> attributes=new ArrayList<Attribute>();    //import the 6 attributes
    	BufferedReader reader = null;
    	try {
			reader = new BufferedReader( new FileReader(file));
		
    	
    	Instances data = null;
    	data = new Instances(reader);
    	reader.close();
    	
    	/* setting class attribute */
    	data.setClassIndex(data.numAttributes() - 1);		 
    	
		Enumeration enumerated_attributes=data.enumerateAttributes();
		while(enumerated_attributes.hasMoreElements()){
			attributes.add((Attribute) enumerated_attributes.nextElement());
		}
		
		/*import the instances(row data) from the production file */
		Enumeration inst=data.enumerateInstances();
		while(inst.hasMoreElements())
		{
			instanceList.add((Instance) inst.nextElement());
		}
		
		//return instanceList;
		
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	list.add(instanceList);
    	list.add(attributes);
		return list;
    }
    
    public List<Integer> getNormColumns (List<Attribute> attributes) {
		List<Integer> columns=new ArrayList<Integer>();
		Iterator<Attribute> i = attributes.iterator();
		int c=0;
		while(i.hasNext())
		{
			
			/*if(i.next().equals("real"))
				columns.add(c);*/
			String[] s = i.next().toString().split(" ");
			if(s[s.length-1].equals("numeric"))  //equals("real");
			{
				columns.add(c);
			}
			c++;
		}
		return columns;
	}
}
