package model;

public class User {

	private String id;
	private String name;
	private String addr;
	private String tell;
	private String age;

	public String getId() {
		return id;
	}

	//メソッド
	public void setId(String id) {
		this.id = id;
	}
	//
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	//
	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAddr() {
		return addr;
	}

	//
	public void setTell(String tell) {
		this.tell = tell;
	}

	public String getTell() {
		return tell;
	}

	//
	public void setAge(String age) {
		this.age = age;
	}

	public String getAge() {
		return age;
	}
}
