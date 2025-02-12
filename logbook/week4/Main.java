package logbook.week4;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

// Step 1: Module class
class Module {
    private final String moduleName;
    private final String moduleCode;

    // Constructor for module
    public Module(String moduleName, String moduleCode) {
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
    }

    // Enum for Grade
    public enum Grade {
        A, B, C, D, F
    }

    // Step 8: Convert mark to letter grade
    public Grade markToGrade(int mark) {
        if (mark >= 85) return Grade.A;
        else if (mark >= 70) return Grade.B;
        else if (mark >= 50) return Grade.C;
        else if (mark >= 40) return Grade.D;
        else return Grade.F;
    }

    // Print module details
    public void printModuleDetails() {
        System.out.println("Module Code: " + moduleCode + ", Module Name: " + moduleName);
    }

    // Step 7: Random number generator to generate marks between 0-100
    public static int generateRandomMark() {
        Random random = new Random();
        return random.nextInt(101); // Returns a number between 0 and 100
    }
}

// Step 2: Course class with ArrayList of modules
class Course {
    private final ArrayList<Module> modules;

    // Constructor to initialize course and add modules
    public Course() {
        this.modules = new ArrayList<>();

        // Add four modules to the ArrayList
        modules.add(new Module("Mathematics", "MATH101"));
        modules.add(new Module("Computer Science", "CS101"));
        modules.add(new Module("Physics", "PHYS101"));
        modules.add(new Module("Chemistry", "CHEM101"));
    }

    public ArrayList<Module> getModules() {
        return modules;
    }
}

// Step 4: Student class with marks array
class Student {
    private final int id;
    private final String name;
    private final int[] marks; // Array to store marks for each module
    private Course course;

    // Constructor to initialize student and marks
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.marks = new int[4]; // Array to hold four marks for four modules
    }

    // Step 5: Assign marks to each module
    public void assignMarks(Course course) {
        this.course = course;
        ArrayList<Module> modules = course.getModules();
        for (int i = 0; i < modules.size(); i++) {
            marks[i] = Module.generateRandomMark(); // Generate random marks between 0-100
        }
    }

    // Step 6: Print student details, course modules, and marks
    public void print() {
        System.out.println("Student ID: " + id + ", Student Name: " + name);
        for (int i = 0; i < course.getModules().size(); i++) {
            Module module = course.getModules().get(i);
            int mark = marks[i];
            module.printModuleDetails();
            System.out.println("Mark: " + mark + ", Grade: " + module.markToGrade(mark));
        }
    }

    // Getter method to access marks (since it's private)
    public int[] getMarks() {
        return marks;
    }
}

// Step 11: Descriptive Statistics
class Statistics {
    public static void calculateStatistics(List<Student> students) {
        int minMark = Integer.MAX_VALUE;
        int maxMark = Integer.MIN_VALUE;
        int totalMarks = 0;
        int count = 0;

        for (Student student : students) {
            for (int mark : student.getMarks()) { // Accessing marks through getter
                minMark = Math.min(minMark, mark);
                maxMark = Math.max(maxMark, mark);
                totalMarks += mark;
                count++;
            }
        }

        double meanMark = (double) totalMarks / count;

        System.out.println("Minimum Mark: " + minMark);
        System.out.println("Maximum Mark: " + maxMark);
        System.out.println("Mean Mark: " + meanMark);
    }
}

// Main class to run everything
public class Main {
    public static void main(String[] args) {
        // Create Course and Student objects
        Course course = new Course();
        Student student = new Student(12345678, "John Doe");

        // Assign marks for each module
        student.assignMarks(course);

        // Print details
        student.print();

        // Create a list of students for descriptive statistics
        List<Student> students = new ArrayList<>();
        students.add(student);
        Statistics.calculateStatistics(students);
    }
}
