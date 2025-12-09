package abc;

import java.util.ArrayList;
import java.util.Scanner;

class Person {
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;}
    public void setId(int id) {
        this.id = id;}
    public String getName() {
        return name;}
    public void setName(String name) {
        this.name = name;}
    public int getAge() {
        return age;}

    public void setAge(int age) {
        this.age = age;
    }
    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
    }
}

class Student extends Person {
    private String grade;

    public Student(int id, String name, int age, String grade) {
        super(id, name, age);
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void displayInfo() {
        System.out.println("Student -> ID: " + getId() + ", Name: " + getName() + ", Age: " + getAge() + ", Grade: " + grade);
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(int id, String name, int age, String subject) {
        super(id, name, age);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void displayInfo() {
        System.out.println("Teacher -> ID: " + getId() + ", Name: " + getName() + ", Age: " + getAge() + ", Subject: " + subject);
    }
}

public class ManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- School Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Search Student");
            System.out.println("4. Search Teacher");
            System.out.println("5. Remove Student");
            System.out.println("6. Remove Teacher");
            System.out.println("7. Display All Students");
            System.out.println("8. Display All Teachers");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> addTeacher();
                case 3 -> searchStudent();
                case 4 -> searchTeacher();
                case 5 -> removeStudent();
                case 6 -> removeTeacher();
                case 7 -> displayAllStudents();
                case 8 -> displayAllTeachers();
                case 9 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 9);
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();
        students.add(new Student(id, name, age, grade));
        System.out.println("Student added successfully!");
    }

    private static void addTeacher() {
        System.out.print("Enter Teacher ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Teacher Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Teacher Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Teacher Subject: ");
        String subject = scanner.nextLine();
        teachers.add(new Teacher(id, name, age, subject));
        System.out.println("Teacher added successfully!");
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();
        for (Student s : students) {
            if (s.getId() == id) {
                s.displayInfo();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    private static void searchTeacher() {
        System.out.print("Enter Teacher ID to search: ");
        int id = scanner.nextInt();
        for (Teacher t : teachers) {
            if (t.getId() == id) {
                t.displayInfo();
                return;
            }
        }
        System.out.println("Teacher not found!");
    }

    private static void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        int id = scanner.nextInt();
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student removed successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    private static void removeTeacher() {
        System.out.print("Enter Teacher ID to remove: ");
        int id = scanner.nextInt();
        for (Teacher t : teachers) {
            if (t.getId() == id) {
                teachers.remove(t);
                System.out.println("Teacher removed successfully!");
                return;
            }
        }
        System.out.println("Teacher not found!");
    }

    private static void displayAllStudents() {
        System.out.println("\n--- All Students ---");
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student s : students) {
                s.displayInfo();
            }
        }
    }

    private static void displayAllTeachers() {
        System.out.println("\n--- All Teachers ---");
        if (teachers.isEmpty()) {
            System.out.println("No teachers to display.");
        } else {
            for (Teacher t : teachers) {
                t.displayInfo();
            }
        }
    }
}
