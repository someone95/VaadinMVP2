package georgi.vaadinmvp.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

import georgi.vaadinmvp.student.service.repository.HasId;

/**
 * @author Georgi Dinev
 */

@Entity
public class Student implements Serializable, HasId {

	public static String ID = "id";
	public static String NAME = "name";
	public static String AGE = "age";
	public static String HAS_PAID_TAX = "paidTax";

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Integer age;

	@Column(name = "paid_tax")
	private boolean paidTax;

	public Student() {
	}

	public Student(final Long id, final String name, final Integer age, final boolean paidTax) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.paidTax = paidTax;
	}

	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(final Integer age) {
		this.age = age;
	}

	public boolean isPaidTax() {
		return this.paidTax;
	}

	public void setPaidTax(final boolean paidTax) {
		this.paidTax = paidTax;
	}
}
