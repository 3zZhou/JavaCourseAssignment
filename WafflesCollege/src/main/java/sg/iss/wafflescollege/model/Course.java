package sg.iss.wafflescollege.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CSE_ID")
	private String cseId;

	@Column(name="CSE_CREDIT")
	private int cseCredit;

	@Column(name="CSE_DESC")
	private String cseDesc;

	@Column(name="CSE_MAX_SIZE")
	private int cseMaxSize;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="CSE_STARTDATE")
	private Date cseStartdate;

	@Column(name="CSE_STATUS")
	private String cseStatus;

	//bi-directional many-to-one association to Lecturer
	@ManyToOne
	@JoinColumn(name="LEC_ID")
	private Lecturer lecturer;

	//bi-directional many-to-one association to Enrollment
	@OneToMany(mappedBy="course")
	private List<Enrollment> enrollments;

	//bi-directional many-to-one association to Studentgrade
	@OneToMany(mappedBy="course")
	private List<Studentgrade> studentgrades;

	public Course() {
	}

	public String getCseId() {
		return this.cseId;
	}

	public void setCseId(String cseId) {
		this.cseId = cseId;
	}

	public int getCseCredit() {
		return this.cseCredit;
	}

	public void setCseCredit(int cseCredit) {
		this.cseCredit = cseCredit;
	}

	public String getCseDesc() {
		return this.cseDesc;
	}

	public void setCseDesc(String cseDesc) {
		this.cseDesc = cseDesc;
	}

	public int getCseMaxSize() {
		return this.cseMaxSize;
	}

	public void setCseMaxSize(int cseMaxSize) {
		this.cseMaxSize = cseMaxSize;
	}

	public Date getCseStartdate() {
		return this.cseStartdate;
	}

	public void setCseStartdate(Date cseStartdate) {
		this.cseStartdate = cseStartdate;
	}

	public String getCseStatus() {
		return this.cseStatus;
	}

	public void setCseStatus(String cseStatus) {
		this.cseStatus = cseStatus;
	}

	public Lecturer getLecturer() {
		return this.lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public List<Enrollment> getEnrollments() {
		return this.enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Enrollment addEnrollment(Enrollment enrollment) {
		getEnrollments().add(enrollment);
		enrollment.setCourse(this);

		return enrollment;
	}

	public Enrollment removeEnrollment(Enrollment enrollment) {
		getEnrollments().remove(enrollment);
		enrollment.setCourse(null);

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
		studentgrade.setCourse(this);

		return studentgrade;
	}

	public Studentgrade removeStudentgrade(Studentgrade studentgrade) {
		getStudentgrades().remove(studentgrade);
		studentgrade.setCourse(null);

		return studentgrade;
	}

}