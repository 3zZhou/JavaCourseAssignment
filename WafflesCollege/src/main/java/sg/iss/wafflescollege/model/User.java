package sg.iss.wafflescollege.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USE_ID")
	private String useId;

	@Column(name="USE_PASSWORD")
	private String usePassword;

	@Column(name="USE_ROLE")
	private String useRole;

	public User() {
	}

	public String getUseId() {
		return this.useId;
	}

	public void setUseId(String useId) {
		this.useId = useId;
	}

	public String getUsePassword() {
		return this.usePassword;
	}

	public void setUsePassword(String usePassword) {
		this.usePassword = usePassword;
	}

	public String getUseRole() {
		return this.useRole;
	}

	public void setUseRole(String useRole) {
		this.useRole = useRole;
	}

}