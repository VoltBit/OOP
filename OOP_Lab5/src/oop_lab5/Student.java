package oop_lab5;
/**
 *	Class that represents a student.
 *
 */
public class Student extends Person{
	
	private Integer grade;
	
        static boolean compare(Student a, Student b){
            return (b.grade < a.grade);
        }
        
	public Student(){}
	
	public Student(String name){
		super(name);
	}

	public Student(String name, Integer grade){
		super(name);
		this.grade = grade;
	}
	
	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	

}
