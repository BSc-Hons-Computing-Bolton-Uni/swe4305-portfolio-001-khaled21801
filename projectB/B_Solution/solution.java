package projectB.B_Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Enum for Grade Classification
enum Grade {
    A("First Class"),
    B("Upper Second Class"),
    C("Lower Second Class"),
    D("Third Class"),
    F("Fail");

    private final String classification;

    Grade(String classification) {
        this.classification = classification;
    }

    public String getClassification() {
        return classification;
    }
}

// Class to Represent Marks and Calculate Grades
class Mark {
    private final int markValue;

    public Mark(int markValue) {
        if (markValue < 0 || markValue > 100) {
            throw new IllegalArgumentException("Mark must be between 0 and 100.");
        }
        this.markValue = markValue;
    }

    public int getMarkValue() {
        return markValue;
    }

    // Method to calculate grade based on predefined range
    public Grade calculateGrade() {
        if (markValue >= 70) {
            return Grade.A;
        } else if (markValue >= 60) {
            return Grade.B;
        } else if (markValue >= 50) {
            return Grade.C;
        } else if (markValue >= 40) {
            return Grade.D;
        } else {
            return Grade.F;
        }
    }
}

// Class to Represent a Student
class Student {
    private final int studentId;
    private final String name;
    private final List<Mark> marks;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.marks = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void addMark(Mark mark) {
        marks.add(mark);
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public Grade getGradeForModule(int index) {
        if (index >= 0 && index < marks.size()) {
            return marks.get(index).calculateGrade();
        }
        return null;
    }
}

// Class to Represent a Module and Handle Stats
class Module {
    private final int moduleCode;
    private final String moduleName;
    private final List<Student> students;

    public Module(int moduleCode, String moduleName) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.students = new ArrayList<>();
    }

    public int getModuleCode() {
        return moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    // Method to calculate the mean, max, and min marks for the module
    public void calculateStats() {
        double total = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (Student student : students) {
            for (Mark mark : student.getMarks()) {
                int markValue = mark.getMarkValue();
                total += markValue;
                if (markValue > max) max = markValue;
                if (markValue < min) min = markValue;
                count++;
            }
        }

        if (count > 0) {
            double mean = total / count;
            System.out.println("Module: " + moduleName);
            System.out.println("Mean Mark: " + mean);
            System.out.println("Max Mark: " + max);
            System.out.println("Min Mark: " + min);
        } else {
            System.out.println("No marks available to calculate stats.");
        }
    }
}

// Main Class to Run the Application and Interface with the User
class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Module> modules = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getIntInput("Choose an option: ");
            switch (choice) {
                case 1:
                    addStudentToModule();
                    break;
                case 2:
                    updateMarks();
                    break;
                case 3:
                    displayGrades();
                    break;
                case 4:
                    calculateModuleStats();
                    break;
                case 5:
                    return; // Exit program
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== Student Management System ===");
        System.out.println("1. Add student to module");
        System.out.println("2. Update student marks");
        System.out.println("3. Display student grades");
        System.out.println("4. Calculate module stats");
        System.out.println("5. Exit");
    }

    private static void addStudentToModule() {
        int moduleCode = getIntInput("Enter Module Code: ");

        // Check if the module with this code already exists
        if (findModuleByCode(moduleCode) != null) {
            System.out.println("Module with this code already exists. Please enter a different module code.");
            return;
        }

        System.out.print("Enter Module Name: ");
        String moduleName = scanner.nextLine();

        Module module = new Module(moduleCode, moduleName);
        modules.add(module);

        int studentId = getIntInput("Enter Student ID: ");

        // Check if the student ID already exists
        if (findStudentById(studentId) != null) {
            System.out.println("Student with this ID already exists. Please enter a different student ID.");
            return;
        }

        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        Student student = new Student(studentId, studentName);
        module.addStudent(student);

        System.out.println("Student added to module: " + moduleName);
    }

    private static void updateMarks() {
        int moduleCode = getIntInput("Enter Module Code: ");
        Module module = findModuleByCode(moduleCode);

        if (module != null) {
            int studentId = getIntInput("Enter Student ID: ");
            Student student = findStudentById(module, studentId);

            if (student != null) {
                int markValue = getIntInput("Enter Mark (0-100): ");
                try {
                    Mark mark = new Mark(markValue);
                    student.addMark(mark);
                    System.out.println("Mark added for student: " + studentId);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("Module not found.");
        }
    }

    private static void displayGrades() {
        int moduleCode = getIntInput("Enter Module Code: ");
        Module module = findModuleByCode(moduleCode);

        if (module != null) {
            int studentId = getIntInput("Enter Student ID: ");
            Student student = findStudentById(module, studentId);

            if (student != null) {
                System.out.println("Grades for student " + studentId + ":");
                for (Mark mark : student.getMarks()) {
                    Grade grade = mark.calculateGrade();
                    System.out.println("Mark: " + mark.getMarkValue() + ", Grade: " + grade);
                }
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("Module not found.");
        }
    }

    private static void calculateModuleStats() {
        int moduleCode = getIntInput("Enter Module Code: ");
        Module module = findModuleByCode(moduleCode);

        if (module != null) {
            module.calculateStats();
        } else {
            System.out.println("Module not found.");
        }
    }

    // Method to safely get integer input
    private static int getIntInput(String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
                break; // Exit loop when a valid integer is entered
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return input;
    }

    private static Module findModuleByCode(int moduleCode) {
        for (Module module : modules) {
            if (moduleCode == module.getModuleCode()) {
                return module;
            }
        }
        return null;
    }

    private static Student findStudentById(Module module, int studentId) {
        for (Student student : module.getStudents()) {
            if (studentId == student.getStudentId()) {
                return student;
            }
        }
        return null;
    }

    private static Student findStudentById(int studentId) {
        for (Module module : modules) {
            for (Student student : module.getStudents()) {
                if (studentId == student.getStudentId()) {
                    return student;
                }
            }
        }
        return null;
    }
}
