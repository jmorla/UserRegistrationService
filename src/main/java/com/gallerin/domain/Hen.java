package com.gallerin.domain;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Relationship;

public class Hen {

	@Id
	private Long 	id;	
	@NotEmpty
	@NotNull
	private String	birdId;
	private Date 	birth;
	private String  alias;
	@NotNull
	@NotEmpty
	private Integer plate;
	@NotNull
	@NotEmpty
	private String  scrath;
	private Date 	died;
	@NotNull
	@NotEmpty
	private String  status;
	@NotNull
	@NotEmpty
	private String  enrace;
	private String 	comment;
	@NotNull
	@NotEmpty
	private String 	color;
	@NotNull
	@NotEmpty
	private String 	crest;
	@NotNull
	@NotEmpty
	private String  plateType;
	private String 	fatherId;
	private String 	motherId;
	
	@Relationship(type = "OWNER", direction = Relationship.OUTGOING)
	private User 	user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBirdId() {
		return birdId;
	}

	public void setBirdId(String birdId) {
		this.birdId = birdId;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Integer getPlate() {
		return plate;
	}

	public void setPlate(Integer plate) {
		this.plate = plate;
	}

	public String getScrath() {
		return scrath;
	}

	public void setScrath(String scrath) {
		this.scrath = scrath;
	}

	public Date getDied() {
		return died;
	}

	public void setDied(Date died) {
		this.died = died;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEnrace() {
		return enrace;
	}

	public void setEnrace(String enrace) {
		this.enrace = enrace;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCrest() {
		return crest;
	}

	public void setCrest(String crest) {
		this.crest = crest;
	}

	public String getPlateType() {
		return plateType;
	}

	public void setPlateType(String plateType) {
		this.plateType = plateType;
	}

	public String getFatherId() {
		return fatherId;
	}

	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	public String getMotherId() {
		return motherId;
	}

	public void setMotherId(String motherId) {
		this.motherId = motherId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
