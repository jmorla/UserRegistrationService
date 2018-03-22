package org.jmorla.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

/**
 * @author jmorla
 *
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long id;

	@Column(name = "FIRST_NAME")
	@Length(min = 3, max = 30)
	@NotEmpty
	private String firstname;

	@Column(name = "LAST_NAME")
	@Length(min = 3, max = 30)
	@NotEmpty
	private String lastname;

	@Column(name = "ADDRESS")
	@Length(min = 5, max = 255)
	@NotEmpty
	private String address;

	@Email
	@Column(name = "EMAIL")
	@Length(min = 5, max = 100)
	@NotEmpty
	private String email;

	@NotEmpty
	@Column(name = "USERNAME")
	@Length(min = 3, max = 10)
	private String username;

	@NotEmpty
	@Column(name = "PASSWORD")
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}
