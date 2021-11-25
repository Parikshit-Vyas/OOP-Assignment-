import java.util.*;
import java.io.*;
class Admin implements Person , AdminServices  {
    private String name;
    private String ad;
    private String id;
    Course c1;
    String pass;

    public void setCourse(Course obj){
        this.c1 = obj;
    }


    

    
    Admin(String userName , String password){
        this.name = userName;
        this.pass = password;

    }

    Admin(String name , String ad , String id, String pass){
        this.name = name;
        this.ad = ad;
        this.id = id;
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

    public void coursesTeaching(Course c1){
        c1.getDetails();
    }

   

    public void marksStudents(Course obj){
        for(Map.Entry element : this.c1.marks.entrySet()){
            System.out.println(element.getKey()+" "+element.getValue());
        }

    }

    public void getInfo(){
        System.out.println(this.name + "\n"+ this.id + "\n"+this.ad);
    }

    

    public ArrayList<Student> enrolledStudents(Course course){
        return course.enrolledStudents;
    }

    public boolean courseDetails(Course c1 , boolean texit) throws IOException,InterruptedException {
        Scanner scr = new Scanner(System.in);
        System.out.print("Press 1 to get course details\nPress 2 to get handout of the course\nPress 3 to get enrolled students details\nPress 4 to create a test\nPress 5 to go back\n");
        int courseDetailsAdmin = scr.nextInt();
        switch(courseDetailsAdmin){
            case 1 : 
                Test.clearConsole();
                c1.getDetails();
                break;
            case 2 :
                Test.clearConsole();
                c1.getHandout();
                break;
            case 3 :
                Test.clearConsole();
                this.marksStudents(c1);
                break;
            case 4 :
            Test.clearConsole();
            c1.createNewTest();
            break;
            case 5 : 
                texit = true;
                break;  
        }
        return texit;
    }

    public void createTest(Course c1){
        System.out.println("Test is created.");
    }


}
