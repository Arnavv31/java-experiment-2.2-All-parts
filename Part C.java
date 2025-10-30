import java.io.*;
import java.util.Scanner;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name, designation;
    double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        File file = new File("employees.dat");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, true))) {
                        sc.nextLine(); // consume newline
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Employee Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Designation: ");
                        String designation = sc.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        Employee emp = new Employee(id, name, designation, salary);
                        oos.writeObject(emp);
                        System.out.println("Employee added successfully.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    if (!file.exists()) {
                        System.out.println("No employees found.");
                        break;
                    }
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        System.out.println("Employee Records:");
                        while (true) {
                            try {
                                Employee emp = (Employee) ois.readObject();
                                System.out.println(emp);
                            } catch (EOFException e) {
                                break;
                            }
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
