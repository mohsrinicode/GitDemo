package pojo;

public class GetCourse {
	
	private String url;
	private String services;
	private String expert;
	private String instructor;
	
	public courses getCourses() {
		return Courses;
	}
	public void setCourses(pojo.courses courses) {
		Courses = courses;
	}
	private String linkedIn;
	private courses Courses;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpert() {
		return expert;
	}
	public void setExpert(String expert) {
		this.expert = expert;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	
	
}
