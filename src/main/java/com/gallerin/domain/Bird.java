package com.gallerin.domain;

import java.util.Date;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public abstract class Bird {
	
	@Id
	private Long 	id;
	private String	birdId;
	private Date 	birth;
	private String  alias;
	private Integer plate;
	private String  scrath;
	private Date 	died;
	private String  status;
	private String  enrace;
	private String 	comment;
	private String 	color;
	private String 	crest;
	private String  plateType;
	private String 	fatherId;
	private String 	motherId;
	
	@Relationship(type = "OWNER", direction = Relationship.OUTGOING)
	private User 	user;
	
	protected Long getId() {
		return id;
	}
	protected void setId(Long id) {
		this.id = id;
	}
	protected String getBirdId() {
		return birdId;
	}
	protected void setBirdId(String birdId) {
		this.birdId = birdId;
	}
	protected Date getBirth() {
		return birth;
	}
	protected void setBirth(Date birth) {
		this.birth = birth;
	}
	protected String getAlias() {
		return alias;
	}
	protected void setAlias(String alias) {
		this.alias = alias;
	}
	protected Integer getPlate() {
		return plate;
	}
	protected void setPlate(Integer plate) {
		this.plate = plate;
	}
	protected String getScrath() {
		return scrath;
	}
	protected void setScrath(String scrath) {
		this.scrath = scrath;
	}
	protected Date getDied() {
		return died;
	}
	protected void setDied(Date died) {
		this.died = died;
	}
	protected String getStatus() {
		return status;
	}
	protected void setStatus(String status) {
		this.status = status;
	}
	protected String getEnrace() {
		return enrace;
	}
	protected void setEnrace(String enrace) {
		this.enrace = enrace;
	}
	protected String getComment() {
		return comment;
	}
	protected void setComment(String comment) {
		this.comment = comment;
	}
	protected String getColor() {
		return color;
	}
	protected void setColor(String color) {
		this.color = color;
	}
	protected String getCrest() {
		return crest;
	}
	protected void setCrest(String crest) {
		this.crest = crest;
	}
	protected String getPlateType() {
		return plateType;
	}
	protected void setPlateType(String plateType) {
		this.plateType = plateType;
	}
	protected String getFatherId() {
		return fatherId;
	}
	protected void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}
	protected String getMotherId() {
		return motherId;
	}
	protected void setMotherId(String motherId) {
		this.motherId = motherId;
	}
	protected User getUser() {
		return user;
	}
	protected void setUser(User user) {
		this.user = user;
	}
}