package domain;

public class DataStructure {
	//프로퍼티 선언
	private String name;
	private String description;
	
	//생성자
	public DataStructure() {
		super();
	}
	public DataStructure(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Datastructure [name=" + name + ", description=" + description + "]";
	}
	
	
	
	
}
