import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Student Grade System (DB) =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 3);
    }

    private static void addStudent() {
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Roll No: ");
        int roll = scanner.nextInt();

        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter marks of Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        Student s = new Student(name, roll, marks);
        DBHandler.addStudent(s);
    }

    private static void viewStudents() {
        List<Student> students = DBHandler.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }

        System.out.printf("\n%-10s %-15s %-10s %-10s\n", "Roll No", "Name", "Total", "Grade");
        for (Student s : students) {
            System.out.printf("%-10d %-15s %-10d %-10s\n",
                    s.getRollNo(), s.getName(), s.getTotalMarks(), s.getGrade());
        }
    }
}
