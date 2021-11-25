
import java.util.*;
import java.io.*;

public class Test {
	public static void clearConsole() throws IOException, InterruptedException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}


	//////////////////////////////////////////////////////////////////////////////////	

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Scanner scr = new Scanner(System.in);
		
		ReadWriteData fileRW = new ReadWriteData();
		
		ArrayList<Admin> adminArr = fileRW.readTeacherData();
		
		ArrayList<Student> studentArr = fileRW.readStData();

		Course c1 = new Course("CS F200","Handout",studentArr,"Test");
		c1.marks = new HashMap<String,Integer>();
		
		
		for(Admin admin : adminArr){
			admin.setCourse(c1);
		}

		for(Student st : studentArr){
			st.setCourse(c1);
			c1.marks.put(st.getName(),(int)(Math.random()*100));
		}
		
		boolean exit = false;
		

		login: while (!exit) {
			clearConsole();
			System.out.print("Welcome to Nalanda-Mini\n");
			System.out.print("Press 1 to Login: \n");
			System.out.print("Press 2 to Exit:\n");
			int homepage = scr.nextInt();
			clearConsole();

			if (homepage == 1) {
				entry: while (!exit) {
					System.out.print("1 : Admin\n2 : Student\n3 : Exit the site\n");

					int person = scr.nextInt();
					clearConsole();
					
					
					

					if (person == 1) {
						scr.nextLine();

						boolean loginS = false;
						int id =0;
						clearConsole();
						System.out.print("Username: ");
						String userName = scr.nextLine();
						System.out.print("\nPassword: ");
						String password = scr.nextLine();
						userName.trim();
						password.trim();

						

						for(int a =0;a<adminArr.size();a++){
							
							
							if(adminArr.get(a).getName().trim().equals(userName)){
								if(adminArr.get(a).pass.trim().equals(password)){
									loginS = true;
									id =a;
								}
							}
						}

						if(loginS == true){
							clearConsole();
						System.out.println("Welcome  Prof."+adminArr.get(id).getName()+"\n\n");

						admin : 
							while(!exit){
						System.out.print("Press 1 to get your personal details\nPress 2 to get the courses you are teaching\nPress 3 to get course details\nPress 4 to go back\n");

						int toption1 = scr.nextInt();
						switch(toption1){
							case 1 :
							clearConsole();
								adminArr.get(id).getInfo();
								System.out.println("\n\n\n\n");
								
								break;
							case 2 :
							clearConsole();
								adminArr.get(id).coursesTeaching(c1);
								System.out.println("\n\n\n\n");
								break;
							case 3 :
							clearConsole();
								boolean texit=false;
								while(!texit){
									texit = adminArr.get(id).courseDetails(c1,texit);
									System.out.println("\n\n\n\n");

								}
								break;
							case 4 :
							clearConsole();
								break admin;

						}
						
					}
						}else{
							clearConsole();
							System.out.println("Invalid username or password\n\n\n\n");
							continue entry;
						}
						
						

					} else if (person == 2) {
						System.out.println("Press 1 if you are already registered\nPress 2 to register");
						int reg = scr.nextInt();
						scr.nextLine();
						if(reg == 1){
							boolean loginS = false;
							int id =0;
							clearConsole();
							System.out.print("Username: ");
						String userName = scr.nextLine();
						System.out.print("\nPassword: ");
						String password = scr.nextLine();

						for(int a=0;a<studentArr.size();a++){
							if(studentArr.get(a).getName().equals(userName) && studentArr.get(a).pass.equals(password)){
								loginS = true;
								id =a;
							}
						}

						if(loginS){
							clearConsole();
						System.out.println("Welcome "+studentArr.get(id).getName());

						student:
							while(!exit){
								System.out.print("Press 1 to get your personal details\nPress 2 to get the courses you are enrolled in \nPress 3 to go back\n");

								int stOption = scr.nextInt();
								switch(stOption){
									case 1:
										clearConsole();
										studentArr.get(id).getInfo();
										break;
									case 2:
										clearConsole();
										boolean texit=false;
										while(!texit){

										texit = studentArr.get(id).myCourses(c1,texit);
										}
										break;
									case 3 :
										clearConsole();
										break student;
										
								}
							}

						}else{
							clearConsole();
							System.out.println("Incorrect Username or Password\n\n\n");
							continue entry;
						}

						}else if(reg == 2){
							
							System.out.println("Enter Username : ");
							String data="";
							String name = scr.nextLine();
							data = data + name+"\n";
							System.out.println("Enter Address :");
							String adr = scr.nextLine();
							data = data + adr+"\n";
							System.out.println("Enter your password :");
							String pass = scr.nextLine();
							data = data + pass+"\n";
							clearConsole();
							fileRW.writeStData(data);

						}else{
							continue entry;
						}

					} 
					else if(person == 3){
						exit = true;
						break login;
					}
					
					else {
						System.out.print("Invalid Input\n");
						continue entry;
					}

				}

			} else if (homepage == 2) {
				exit = true;
				break login;
			} else {
				System.out.print("Invalid Input\n");
				continue login;

			}
		}
		System.out.println("You have successfully left the site.");

	}

}
