package sg.iss.wafflescollege.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the studentgrade database table.
 * 
 */
@Entity
@NamedQuery(name="Studentgrade.findAll", query="SELECT s FROM Studentgrade s")
public class Studentgrade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="STG_ID")
	private int stgId;

	@Column(name="STG_GRADE")
	private String stgGrade;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="CSE_ID")
	private Course course;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="STU_ID")
	private Student student;

	public Studentgrade() {
	}

	public int getStgId() {
		return this.stgId;
	}

	public void setStgId(int stgId) {
		this.stgId = stgId;
	}

	public String getStgGrade() {
		return this.stgGrade;
	}

	public void setStgGrade(String stgGrade) {
		this.stgGrade = stgGrade;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}