package oop_lab5;
/**
 *	Class that represents a student.
 *
 */
public class Student extends Person{
	
	private Integer grade;
	
        static int compare(Student a, Student b){
            if(b.grade < a.grade)return 1;
            else return 0;
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
