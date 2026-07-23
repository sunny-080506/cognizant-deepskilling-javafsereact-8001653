class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "ID: " + employeeId + " | Name: " + name + " | Position: " + position + " | Salary: $" + salary;
    }
}

class EmployeeManagement {
    private Employee[] employees;
    private int size;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public boolean addEmployee(Employee emp) {
        if (size >= employees.length) {
            System.out.println("Error: Cannot add employee. Array is full!");
            return false;
        }
        employees[size] = emp;
        size++;
        System.out.println("Employee added successfully: " + emp.getName());
        return true;
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employee records found.");
            return;
        }
        System.out.println("\n--- Current Employee Records ---");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
        System.out.println("--------------------------------");
    }

    public boolean deleteEmployee(int employeeId) {
        int indexToDelete = -1;

        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Error: Employee with ID " + employeeId + " not found.");
            return false;
        }

        for (int i = indexToDelete; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[size - 1] = null;
        size--;
        System.out.println("Employee with ID " + employeeId + " deleted successfully.");
        return true;
    }
}

public class question4 {
    public static void main(String[] args) {
        EmployeeManagement manager = new EmployeeManagement(5);

        System.out.println("--- Testing Add Operations ---");
        manager.addEmployee(new Employee(101, "Alice Smith", "Software Engineer", 85000));
        manager.addEmployee(new Employee(102, "Bob Jones", "Product Manager", 95000));
        manager.addEmployee(new Employee(103, "Charlie Brown", "UX Designer", 75000));

        manager.traverseEmployees();

        System.out.println("\n--- Testing Search Operation ---");
        int targetId = 102;
        Employee found = manager.searchEmployee(targetId);
        if (found != null) {
            System.out.println("Found Record: " + found);
        } else {
            System.out.println("Employee with ID " + targetId + " not found.");
        }

        System.out.println("\n--- Testing Delete Operation ---");
        manager.deleteEmployee(102);

        manager.traverseEmployees();
    }
}