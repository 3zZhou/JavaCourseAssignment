package sg.iss.wafflescollege.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="STU_ID")
	private String stuId;

	@Column(name="STU_ADDRESS")
	private String stuAddress;

	@Column(name="STU_EMAIL")
	private String stuEmail;

	@Column(name="STU_FIRSTMIDNAME")
	private String stuFirstmidname;

	@Column(name="STU_LASTNAME")
	private String stuLastname;

	@Column(name="STU_PHONE_NO")
	private String stuPhoneNo;

	@Column(name="STU_STATUS")
	private String stuStatus;

	//bi-directional many-to-one association to Enrollment
	@OneToMany(mappedBy="student")
	private List<Enrollment> enrollments;

	//bi-directional many-to-one association to Studentgrade
	@OneToMany(mappedBy="student")
	private List<Studentgrade> studentgrades;

	public Student() {
	}

	public String getStuId() {
		return this.stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getStuAddress() {
		return this.stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	public String getStuEmail() {
		return this.stuEmail;
	}

	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}

	public String getStuFirstmidname() {
		return this.stuFirstmidname;
	}

	public void setStuFirstmidname(String stuFirstmidname) {
		this.stuFirstmidname = stuFirstmidname;
	}

	public String getStuLastname() {
		return this.stuLastname;
	}

	public void setStuLastname(String stuLastname) {
		this.stuLastname = stuLastname;
	}

	public String getStuPhoneNo() {
		return this.stuPhoneNo;
	}

	public void setStuPhoneNo(String stuPhoneNo) {
		this.stuPhoneNo = stuPhoneNo;
	}

	public String getStuStatus() {
		return this.stuStatus;
	}

	public void setStuStatus(String stuStatus) {
		this.stuStatus = stuStatus;
	}

	public List<Enrollment> getEnrollments() {
		return this.enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Enrollment addEnrollment(Enrollment enrollment) {
		getEnrollments().add(enrollment);
		enrollment.setStudent(this);

		return enrollment;
	}

	public Enrollment removeEnrollment(Enrollment enrollment) {
		getEnrollments().remove(enrollment);
		enrollment.setStudent(null);

		return enrollment;
	}

	public List<Studentgrade> getStudentgrades() {
		return this.studentgrades;
	}

	public void setStudentgrades(List<Studentgrade> studentgrades) {
		this.studentgrades = studentgrades;
	}

	public Studentgrade addStudentgrade(Studentgrade studentgrade) {
		getStudentgrades().add(studentgrade);
		studentgrade.setStudent(this);

		return studentgrade;
	}

	public Studentgrade removeStudentgrade(Studentgrade studentgrade) {
		getStudentgrades().remove(studentgrade);
		studentgrade.setStudent(null);

		return studentgrade;
	}

}