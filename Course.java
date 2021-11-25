import java.util.*;
class Course {
    String details;
    String handout;
    ArrayList<Student> enrolledStudents;
    String createTest;
    HashMap<String,Integer> marks;


    Course(String details , String handout , ArrayList<Student> students , String test){
        this.details = details;
        this.handout = handout;
        this.enrolledStudents = students;
        this.createTest = test;
    }

    public void getDetails(){
        System.out.println(this.details);
        System.out.println("\n\n");
    }
    public void getHandout(){
        System.out.println(this.handout);
        System.out.println("\n\n");
    }
    public void getStDetails(){
        for(Student st : enrolledStudents){
            System.out.println(st.getName());
        }
        System.out.println("\n\n");
    }
    public void createNewTest(){
        System.out.println("Test created");
        System.out.println("\n\n");
    }

    public void getMarks(String name){
        System.out.print("Your marks : ");
        System.out.println(marks.get(name));
        System.out.println("\n\n");
    }

    public void giveTest(){
        System.out.println("Giving test");
        System.out.println("\n\n");
    }
}
