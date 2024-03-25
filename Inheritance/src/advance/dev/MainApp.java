package advance.dev;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		Person[] persons = new Person[10];
		input(persons);
		print(persons);
		Teacher highestPaidTeacher = findTeacher(persons);
		Student highestScoreStudent = findStudent(persons);
		System.out.println("Giáo viên có lương cao nhất: "
				+ (highestPaidTeacher != null ? highestPaidTeacher.getName() : "Không có"));
		System.out.println("Sinh viên có điểm trung bình cao nhất: "
				+ (highestScoreStudent != null ? highestScoreStudent.getName() : "Không có"));
	}

	// Phương thức nhập
	public static void input(Person[] persons) {
		Scanner scanner = new Scanner(System.in);
		int teacherCount = 0, studentCount = 0;

		for (int i = 0; i < persons.length;) {
			System.out.println("Nhập thông tin cho " + (i < 4 ? "giáo viên" : "sinh viên") + " thứ " + (i + 1) + ":");
			System.out.print("Tên: ");
			String name = scanner.nextLine();
			System.out.print("Tuổi: ");
			int age = scanner.nextInt();
			scanner.nextLine(); // Consume newline left-over
			System.out.print("Số điện thoại: ");
			String phoneNumber = scanner.nextLine();

			if (i < 4) { // Nhập thông tin giáo viên
				System.out.print("Mã giáo viên: ");
				String teacherId = scanner.nextLine();
				System.out.print("Hệ số lương: ");
				double salaryCoefficient = scanner.nextDouble();
				scanner.nextLine(); // Consume newline left-over
				persons[i] = new Teacher(name, age, phoneNumber, teacherId, salaryCoefficient);
				teacherCount++;
			} else { // Nhập thông tin sinh viên
				System.out.print("Điểm Toán: ");
				double mathScore = scanner.nextDouble();
				System.out.print("Điểm Lý: ");
				double physicsScore = scanner.nextDouble();
				System.out.print("Điểm Hóa: ");
				double chemistryScore = scanner.nextDouble();
				scanner.nextLine(); // Consume newline left-over
				System.out.print("Mã sinh viên: ");
				String studentId = scanner.nextLine();
				System.out.print("Lớp: ");
				String studentClass = scanner.nextLine();
				persons[i] = new Student(name, age, phoneNumber, mathScore, physicsScore, chemistryScore, studentId,
						studentClass);
				studentCount++;
			}
			i++;
		}
		System.out.println("Đã nhập thành công " + teacherCount + " giáo viên và " + studentCount + " sinh viên.");
	}

	// Phương thức xuất
	public static void print(Person[] persons) {
		for (Person person : persons) {
			if (person instanceof Teacher) {
				Teacher teacher = (Teacher) person;
				System.out.println("Giáo viên: " + teacher.getName() + ", Tuổi: " + teacher.getAge() + ", Số ĐT: "
						+ teacher.getPhoneNumber() + ", Lương: " + teacher.tinhLuong());
			} else if (person instanceof Student) {
				Student student = (Student) person;
				System.out.println("Sinh viên: " + student.getName() + ", Tuổi: " + student.getAge() + ", Số ĐT: "
						+ student.getPhoneNumber() + ", ĐTB: " + student.diemTrungBinh());
			}
		}
	}

	// Tìm giáo viên có lương cao nhất
	public static Teacher findTeacher(Person[] persons) {
		Teacher highestPaidTeacher = null;
		double highestSalary = 0;

		for (Person person : persons) {
			if (person instanceof Teacher) {
				Teacher teacher = (Teacher) person;
				double salary = teacher.tinhLuong();
				if (salary > highestSalary) {
					highestSalary = salary;
					highestPaidTeacher = teacher;
				}
			}
		}
		return highestPaidTeacher;
	}

	// Tìm sinh viên có điểm trung bình cao nhất
	public static Student findStudent(Person[] persons) {
		Student highestScoreStudent = null;
		double highestAverageScore = 0;

		for (Person person : persons) {
			if (person instanceof Student) {
				Student student = (Student) person;
				double averageScore = student.diemTrungBinh();
				if (averageScore > highestAverageScore) {
					highestAverageScore = averageScore;
					highestScoreStudent = student;
				}
			}
		}
		return highestScoreStudent;
	}

}
