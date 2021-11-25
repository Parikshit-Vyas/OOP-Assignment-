import java.util.*;
import java.lang.*;
import java.io.*;


public class ReadWriteData {


    public ArrayList<Admin> readTeacherData() throws FileNotFoundException , NumberFormatException{
        
		File file = new File("Teachers.txt");
		Scanner scr = new Scanner(file);
		
        ArrayList<ArrayList<String>> teacherArr = new ArrayList<>();
		ArrayList<Admin> adminArr = new ArrayList<>(); 
        
		scr.useDelimiter("\n");
		int counter = 0;
		int  i= 0;

		while(scr.hasNext()){
			if(counter % 3 == 0 &&  counter !=0){
				counter = 0;
				i++;
			}
			String temp = scr.next();
			counter++;
			
			// System.out.println(teacherArr[i][counter-1]);
		}
		// System.out.println(i);
		scr.close();

		Scanner sc = new Scanner(file);
		sc.useDelimiter("\n");
      

        for(int a=0;a<i;a++){
            ArrayList<String> temp = new ArrayList<>();
            for(int b = 0;b<4;b++){
                temp.add(sc.next());
                // System.out.println(temp.get(b));
            }
            teacherArr.add(temp);
        }

        



		sc.close();
        
		for(int a=0;a<i;a++){
			adminArr.add(new Admin(teacherArr.get(a).get(0),teacherArr.get(a).get(1),teacherArr.get(a).get(2),teacherArr.get(a).get(3)));
			
			
		}

		return adminArr;
	}
    ///////////////////////////////////////////////////////////////////////////////////////

    public void writeStData(String s) throws FileNotFoundException{
		int len = s.length();

		try{
		FileWriter fw = new FileWriter("Students.txt",true);
		for(int a=0;a<len;a++){
			fw.write(s.charAt(a));
		}
		fw.close();
	
	}catch(Exception e){
		e.getStackTrace();
	}

	}

    ////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Student> readStData() throws FileNotFoundException , NumberFormatException{
		File file = new File("Students.txt");
		Scanner scr = new Scanner(file);
		ArrayList<ArrayList<String>> Arr = new ArrayList<>();
		ArrayList<Student> stArr = new ArrayList<>(); 

		scr.useDelimiter("\n");
		int counter = 0;
		int i =0;
		while(scr.hasNext()){
			if(counter % 3 == 0 &&  counter !=0){
				counter = 0;
				i++;
			}
			String temp = scr.next();
			counter++;
			
			// System.out.println(teacherArr[i][counter-1]);
		}
		// System.out.println(i );
		scr.close();

		Scanner sc = new Scanner(file);
		sc.useDelimiter("\n");



		for(int a = 0;a<=i;a++){
			ArrayList<String> temp = new ArrayList<>();
			for(int b = 0;b<3;b++){
				temp.add(sc.next());
			}
			Arr.add(temp);
		}

		sc.close();
		
		for(int a=0;a<=i;a++){
			Student temp = new Student(Arr.get(a).get(0),Arr.get(a).get(1),Arr.get(a).get(2));
			stArr.add(temp);
		}

		return stArr;
		
	}






}
