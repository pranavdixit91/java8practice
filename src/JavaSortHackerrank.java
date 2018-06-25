import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

//Complete the code
public class JavaSortHackerrank
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			testCases--;
		}
        
        List<Student> studentListFinal = studentList
            .stream()
            .sorted(comparing(Student::getCgpa)
            .reversed()
            .thenComparing(Student::getFname)
            .thenComparing(Student::getId))
            .collect(Collectors.toList());
            
      
      	for(Student st: studentListFinal){
			System.out.println(st.getFname());
		}
	}
}
