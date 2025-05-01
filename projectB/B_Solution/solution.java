package projectB.B_Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// (Enum for Grade Classification)
enum Grade {
    C("Lower Second Class"),
    D("Third Class"),
    A("First Class"),
    B("Upper Second Class"),
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
}

// Class to Represent a Module
class Module {
    private String moduleCode;
    private String moduleName;
    private List<Student> students;

    public Module(String moduleCode, String moduleName) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.students = new ArrayList<>();
    }

    public Module(int i, String mathematics) {
    }

    public String getModuleCode() {
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

// Main Class
class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Module> modules = new ArrayList<>();

    public static void main(String[] args) {
        initializeModules();

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
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== Student Management System ===");
        System.out.println("1. Add student to existing module");
        System.out.println("2. Update student marks");
        System.out.println("3. Display student grades");
        System.out.println("4. Calculate module stats");
        System.out.println("5. Exit");
    }

    private static void initializeModules() {
        modules.add(new Module("COM4301", "Maths for Computing"));
        modules.add(new Module("COM4302", "Computer Science Fundamentals"));
        modules.add(new Module("SWE4303", "Computing Infrastructure"));
        modules.add(new Module("SWE4304", "Databases"));
        modules.add(new Module("SWE4305", "Object Oriented Programming"));
        modules.add(new Module("SWE5306", "Systems Analysis and Design"));
        modules.add(new Module("SWE5307", "Web Design and Programming"));
        modules.add(new Module("SWE5308", "Cloud Technologies"));
        modules.add(new Module("SWE5304", "Advanced Databases and Big Data"));
        modules.add(new Module("SEC5304", "Advanced Operating Systems"));
        modules.add(new Module("AIN5301", "Introduction to AI"));
        modules.add(new Module("COM6300", "Research and Professional Issues"));
        modules.add(new Module("COM6301", "Undergraduate Project"));
        modules.add(new Module("AIN6301", "Natural Language Processing"));
        modules.add(new Module("SEC6302", "Information Security Management"));
        modules.add(new Module("SEC6305", "Operations Management"));
        modules.add(new Module("SWE6302", "Applied Machine Learning"));
        modules.add(new Module("SWE6303", "Software Quality Management"));
        modules.add(new Module("SWE6304", "Emerging Technologies"));
    }

    private static void addStudentToModule() {
        System.out.print("Enter Module Code (e.g., COM4301): ");
        String moduleCode = scanner.nextLine().trim().toUpperCase();
        Module module = findModuleByCode(moduleCode);

        if (module == null) {
            System.out.println("Module not found.");
            return;
        }

        int studentId = getIntInput("Enter Student ID: ");
        if (findStudentById(studentId) != null) {
            System.out.println("Student with this ID already exists.");
            return;
        }

        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        Student student = new Student(studentId, studentName);
        module.addStudent(student);

        System.out.println("Student added to module: " + module.getModuleName());
    }

    private static void updateMarks() {
        System.out.print("Enter Module Code: ");
        String moduleCode = scanner.nextLine().trim().toUpperCase();
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
        System.out.print("Enter Module Code: ");
        String moduleCode = scanner.nextLine().trim().toUpperCase();
        Module module = findModuleByCode(moduleCode);

        if (module != null) {
            int studentId = getIntInput("Enter Student ID: ");
            Student student = findStudentById(module, studentId);

            if (student != null) {
                System.out.println("Grades for student " + studentId + ":");
                for (Mark mark : student.getMarks()) {
                    Grade grade = mark.calculateGrade();
                    System.out.println("Mark: " + mark.getMarkValue() + ", Grade: " + grade + " (" + grade.getClassification() + ")");
                }
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("Module not found.");
        }
    }

    private static void calculateModuleStats() {
        System.out.print("Enter Module Code: ");
        String moduleCode = scanner.nextLine().trim().toUpperCase();
        Module module = findModuleByCode(moduleCode);

        if (module != null) {
            module.calculateStats();
        } else {
            System.out.println("Module not found.");
        }
    }

    private static int getIntInput(String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return input;
    }

    private static Module findModuleByCode(String moduleCode) {
        for (Module module : modules) {
            if (module.getModuleCode().equalsIgnoreCase(moduleCode)) {
                return module;
            }
        }
        return null;
    }

    private static Student findStudentById(Module module, int studentId) {
        for (Student student : module.getStudents()) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    private static Student findStudentById(int studentId) {
        for (Module module : modules) {
            for (Student student : module.getStudents()) {
                if (student.getStudentId() == studentId) {
                    return student;
                }
            }
        }
        return null;
    }
}
