import java.util.*;
import java.io.*;
public class Student implements Person , StudentService {
    private String name;
    private String ad;
    private String id;
    String pass;
    Course c1;

    public void setCourse(Course obj){
        this.c1 = obj;
    }
    public void setCourseMarks(int marks){
        this.c1.marks.put(id,marks);
    }


    Student(String username , String password){
        this.name = username;


    }

    Student(String name , String ad , String pass){
        this.name = name;
        this.ad =ad;
        this.pass = pass;
    }


    public String getName(){
        return this.name;
    }
    public void setName(String a){
        this.name = a;
    }

    public void getAd(){
        System.out.println(this.ad);
    }
    public void setAd(String b){
        this.ad = b;
    }

    public void getId(){
        System.out.println(this.id);
    }
    public void setId(String a){
        this.id = a;
    }


    public boolean myCourses(Course c1, boolean texit) throws IOException,InterruptedException{
        
        System.out.print("Press 1 to get course details\nPress 2 to get handout of the course\nPress 3 to get enrolled students details\nPress 4 to view available tests\nPress 5 to see your marks\nPress 6 to go back\n");
        Scanner scr = new Scanner(System.in);
        int courseStOption = scr.nextInt();
        switch(courseStOption){
            case 1:
                Test.clearConsole();
                c1.getDetails();
                break;
            case 2 :
            Test.clearConsole();
                c1.getHandout();
                break;
            case 3 :
            Test.clearConsole();
                c1.getStDetails();
                break;

            case 4 :
            Test.clearConsole();
                c1.giveTest();
                break;
            case 5 :
            Test.clearConsole();
                c1.getMarks(this.name);
                break;
            case 6:
            Test.clearConsole();
                texit = true;
                
                break;

        }
        return texit;

    }

   

    public void getInfo(){
        System.out.println(this.name + "\n"+this.ad+"\n\n");
    }

    

    public ArrayList<Student> enrolledStudents(Course course){
        return course.enrolledStudents;
    }
}
