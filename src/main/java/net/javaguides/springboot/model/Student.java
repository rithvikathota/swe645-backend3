package net.javaguides.springboot.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="studentsurvey")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstname;
	private String lastname;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String email;
	@Column(name = "telephone", nullable = false)
	private String telephone;
	private LocalDate date;
    private String mostliked;
	private String likelihood;
	private String comments;
	private String interest;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getLikelihood() {
		return likelihood;
	}
	public void setLikelihood(String likelihood) {
		this.likelihood = likelihood;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	
	public String getMostliked() {
		return mostliked;
	}
	public void setMostliked(String mostliked) {
		this.mostliked = mostliked;
	}
	public Student() {
	
	}
	
	@Override
	public String toString() {
		return "Student [firstname=" + firstname + ", lastname=" + lastname + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", telephone=" + telephone + ", date=" + date + ", email="
				+ email +" interest=" + interest + ", likelihood=" + likelihood
				+ ", comments=" + comments + ", getFirstname()=" + getFirstname() + ", getLastname()=" + getLastname()
				+ ", getStreet()=" + getStreet() + ", getCity()=" + getCity() + ", getState()=" + getState()
				+ ", getZip()=" + getZip() + ", getTelephone()=" + getTelephone() + ", getDate()=" + getDate()
				+ ", getEmail()=" + getEmail() + ", getMostLiked()=" + getMostliked() + ", getInterest()="
				+ getInterest() + ", getLikelihood()=" + getLikelihood() + ", getComments()=" + getComments()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public Student(String firstname, String lastname, String street, String city, String state, String zip,
			String telephone, LocalDate date, String email, String mostliked, String interest, String likelihood,
			String comments) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.telephone = telephone;
		this.date = date;
		this.email = email;
		this.mostliked = mostliked;
		this.interest = interest;
		this.likelihood = likelihood;
		this.comments = comments;
	}
	
}




