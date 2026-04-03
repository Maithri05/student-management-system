import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter course: ");
                    String course = sc.next();

                    StudentDAO.addStudent(new Student(0, name, age, course));
                    break;

                case 2:
                    StudentDAO.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new name: ");
                    name = sc.next();
                    System.out.print("Enter new age: ");
                    age = sc.nextInt();
                    System.out.print("Enter new course: ");
                    course = sc.next();

                    StudentDAO.updateStudent(id, name, age, course);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    StudentDAO.deleteStudent(id);
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}