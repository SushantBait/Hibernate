package com.hibernateWithMaven.HibernateEx1;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Student")
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ID")
	private Long studentId;

	@Column(name = "FNAME", nullable = false)
	private String firstName;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Column(name = "LNAME", unique = true, length = 25)
	private String lastName;

	@Column(name = "CONTACT_NO", length = 15)
	private String contactNo;

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactNo=" + contactNo + "]";
	}

}