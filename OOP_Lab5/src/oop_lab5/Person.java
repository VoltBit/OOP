package oop_lab5;
/**
 *	Class that represents a person.
 *
 */
public class Person {
	
	// protected not private, because subclasses may need it (any person has a name)
    
    public int compare(Person a, Person b){
        return a.name.compareTo(b.name);
    }
    
	protected String name;
	
	public Person(){
		name = "";
	}
	
	public Person(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
