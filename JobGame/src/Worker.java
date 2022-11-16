
abstract class Worker {
	
	private String ID;
	private String Name;
	private String Job;
	
	public Worker(String iD, String name, String job) {
		super();
		ID = iD;
		Name = name;
		Job = job;
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
}
