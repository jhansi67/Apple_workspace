
class qq39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stud=new Student(10);
		Student stud1=new Student(35);
		change(stud);
		System.out.println(stud.sid);
		//change(stud1);
		//System.out.println(stud1.sid);
		

	}
	
	static void change(Student stud)
	{
		stud.sid=stud.sid+10;
	}

}

class Student{
	static int sid;
	//int sid;
	Student(int sid) {
		// TODO Auto-generated constructor stub
		
		this.sid=sid;
	}
	
}

//Static varaible output : 45
//non static variable output : 20

