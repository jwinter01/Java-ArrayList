/*

Jonathan Winter

This project will take an input file and
parse the data into an array list



 */


import java.io.*;
import java.util.*;
public class ReadStudents {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new ReadStudents().doIt();
	}
public void doIt(){
	
	// The sorting stuff
	// CRN:FNAME:LNAME:JNUMBER
	
	HashMap<String,ArrayList> hm = new HashMap<String,ArrayList>();
	
	
	try{
	File infile=new File("c:\\users\\jswin\\Students.txt");
	FileReader fr=new FileReader(infile);
	BufferedReader br=new BufferedReader(fr);
	String temp;
	String[] parsed;
	while((temp=br.readLine())!=null){
		parsed=temp.split(":");
		System.out.println(parsed[0]+"\t"+parsed[1]+"\t"+parsed[2]+
								".........."+parsed[3]);
		
		// If the key is already present
		if (hm.containsKey(parsed[0]))
		{
			hm.get(parsed[0]).add(new Student(parsed[0], parsed[1], parsed[2], parsed[3]));
		}
		// If the key is NOT already present
		else
		{
			// Add CRN and FNAME to ArrayList
			ArrayList<Student> students = new ArrayList<Student>();
			students.add(new Student(parsed[0], parsed[1], parsed[2], parsed[3]));
			// Add CRN and ArrayList to HashMap
			//hm.putIfAbsent(parsed[0], new ArrayList<Student>());
			hm.put(parsed[0], students);
		}
		}

	br.close();
	}catch(FileNotFoundException fnfe){
		System.out.println("File not found");
	}
	catch(IOException ioe){}
	
	// Find Stuff
	System.out.println("\n");
	ArrayList<Student>temp;
	temp=hm.get("32212");
	Iterator i = temp.iterator();
	while(i.hasNext()) {
		System.out.println(((Student)i.next()).name);
	}

	// NEED TO SORT BY LAST NAME AND THEN PRINT!!!!!!!!!!!!!!!!!!!!!!!!!!
	
}// End doIt()

public void sortIt() {
	
}
}

class Student{
	public String CRN;
	public String name;
	public String last;
	public String jnum;
	public Student(String c, String n, String l, String j)
	{
		CRN = c;
		name = n;
		last = l;
		jnum = j;
	}
}
