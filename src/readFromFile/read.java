package readfromfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;

public class read {

	public read(){}
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
		
		//import the attributes i.e the 6 attributes given at the top of the file
		List<Attribute> attributes=new ArrayList<Attribute>();
		Enumeration enumerated_attributes=data.enumerateAttributes();
		while(enumerated_attributes.hasMoreElements()){
			attributes.add((Attribute) enumerated_attributes.nextElement());
		}
		//System.out.println(attributes.get(0));
		
		
		List<Instance> list=new ArrayList<Instance>();
		Enumeration inst=data.enumerateInstances();
		while(inst.hasMoreElements())
		{
			list.add((Instance) inst.nextElement());
		}
		System.out.println(list.toString());
		//System.out.println(list.size());
		System.out.println("first index:"+list.get(0).stringValue(1));
	}
}
