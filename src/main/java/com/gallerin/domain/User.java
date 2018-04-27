package com.gallerin.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * @author jmorla
 *
 */
@NodeEntity
public class User implements Serializable {
	
	@GraphId
	private Long id;

	@NotEmpty
	@Length(min = 3, max = 10)
	private String username;

	@NotEmpty
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Email
	@Length(min = 5, max = 100)
	@NotEmpty
	private String email;

	private String firstname;

	private String lastname;

	private String address;
	
	private String city;
	
	private String country;
	
	private Integer postalCode;
	
	private String aboutMe;
	
	@Relationship(type = "OWNER", direction = Relationship.INCOMING)
	private Set<Bird> birds;
	
	public User() {
		this.birds = new HashSet<>();
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	protected Set<Bird> getBirds() {
		return birds;
	}

	protected void setBirds(Set<Bird> birds) {
		this.birds = birds;
	}
	
}
