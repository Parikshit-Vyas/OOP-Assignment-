import java.io.*;

interface StudentService extends Services{
	boolean myCourses(Course c , boolean texit) throws IOException,InterruptedException;
	
}
