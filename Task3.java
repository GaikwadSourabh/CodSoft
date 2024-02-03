
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;
   
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

   
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }

	public int getRollNumber() {
		
		return 0;
	}
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (ArrayList<Student>) ois.readObject();
            System.out.println("Data loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    Student student = new Student(name, rollNumber, grade);
                    sms.addStudent(student);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int removeRollNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    sms.removeStudent(removeRollNumber);
                    System.out.println("Student removed successfully.");
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRollNumber = scanner.nextInt();
                    scanner.nextLine();  
                    Student foundStudent = sms.searchStudent(searchRollNumber);
                    if (foundStudent != null) {
                        System.out.println("Student found:");
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    sms.displayAllStudents();
                    break;

                case 5:
                    System.out.print("Enter filename to save: ");
                    String saveFilename = scanner.nextLine();
                    sms.saveToFile(saveFilename);
                    break;

                case 6:
                    System.out.print("Enter filename to load: ");
                    String loadFilename = scanner.nextLine();
                    sms.loadFromFile(loadFilename);
                    break;

                case 7:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
