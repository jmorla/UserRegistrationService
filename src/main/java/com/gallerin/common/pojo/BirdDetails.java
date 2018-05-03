package com.gallerin.common.pojo;

import java.util.Date;

public class BirdDetails {

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
	private String  fatherBirdId;
	private String  motherBirdId;
	private String 	sex;
	
	public BirdDetails() {
		super();
	}
	
	public BirdDetails(Long id, String birdId, Date birth, String alias, Integer plate, String scrath, Date died,
			String status, String enrace, String comment, String color, String crest, String plateType,
			String fatherBirdId, String motherBirdId, String sex) {
		super();
		this.id = id;
		this.birdId = birdId;
		this.birth = birth;
		this.alias = alias;
		this.plate = plate;
		this.scrath = scrath;
		this.died = died;
		this.status = status;
		this.enrace = enrace;
		this.comment = comment;
		this.color = color;
		this.crest = crest;
		this.plateType = plateType;
		this.fatherBirdId = fatherBirdId;
		this.motherBirdId = motherBirdId;
		this.sex = sex;
	}


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
	public String getFatherBirdId() {
		return fatherBirdId;
	}
	public void setFatherbirdId(String fatherbirdId) {
		fatherBirdId = fatherbirdId;
	}
	public String getMotherBirdId() {
		return motherBirdId;
	}
	public void setMotherBirdId(String motherBirdId) {
		this.motherBirdId = motherBirdId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
