package advance.dev;

import java.util.Scanner;

public class Person {

	private String name;
	private int age;
	private String phoneNumber;

	// Constructors
	public Person() {
	}

	public Person(String name, int age, String phoneNumber) {
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}

// Lớp Student kế thừa từ Person
class Student extends Person {
	private double mathScore;
	private double physicsScore;
	private double chemistryScore;
	private String studentId;
	private String studentClass;

	// Constructors
	public Student() {
	}

	public Student(String name, int age, String phoneNumber, double mathScore, double physicsScore,
			double chemistryScore, String studentId, String studentClass) {
		super(name, age, phoneNumber);
		this.mathScore = mathScore;
		this.physicsScore = physicsScore;
		this.chemistryScore = chemistryScore;
		this.studentId = studentId;
		this.studentClass = studentClass;
	}

	// Tính điểm trung bình
	public double diemTrungBinh() {
		return (mathScore + physicsScore + chemistryScore) / 3;
	}

	// Getters and Setters
	// ... (Tương tự như trên, bổ sung cho các thuộc tính mới)
}

// Lớp Teacher kế thừa từ Person
class Teacher extends Person {
	private String teacherId;
	private double salaryCoefficient;

	// Constructors
	public Teacher() {
	}

	public Teacher(String name, int age, String phoneNumber, String teacherId, double salaryCoefficient) {
		super(name, age, phoneNumber);
		this.teacherId = teacherId;
		this.salaryCoefficient = salaryCoefficient;
	}

	// Tính lương
	public double tinhLuong() {
		// Giả sử lương cơ bản là 5000
		return 5000 * salaryCoefficient;
	}

	// Getters and Setters
	// ... (Tương tự như trên, bổ sung cho các thuộc tính mới)
}
