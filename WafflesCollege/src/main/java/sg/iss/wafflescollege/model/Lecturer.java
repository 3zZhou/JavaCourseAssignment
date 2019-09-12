package sg.iss.wafflescollege.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lecturer database table.
 * 
 */
@Entity
@NamedQuery(name="Lecturer.findAll", query="SELECT l FROM Lecturer l")
public class Lecturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LEC_ID")
	private String lecId;

	@Column(name="LEC_FIRSTMIDNAME")
	private String lecFirstmidname;

	@Column(name="LEC_LASTNAME")
	private String lecLastname;

	//bi-directional many-to-one association to Course
	@OneToMany(mappedBy="lecturer")
	private List<Course> courses;

	public Lecturer() {
	}

	public String getLecId() {
		return this.lecId;
	}

	public void setLecId(String lecId) {
		this.lecId = lecId;
	}

	public String getLecFirstmidname() {
		return this.lecFirstmidname;
	}

	public void setLecFirstmidname(String lecFirstmidname) {
		this.lecFirstmidname = lecFirstmidname;
	}

	public String getLecLastname() {
		return this.lecLastname;
	}

	public void setLecLastname(String lecLastname) {
		this.lecLastname = lecLastname;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course addCours(Course cours) {
		getCourses().add(cours);
		cours.setLecturer(this);

		return cours;
	}

	public Course removeCours(Course cours) {
		getCourses().remove(cours);
		cours.setLecturer(null);

		return cours;
	}

}