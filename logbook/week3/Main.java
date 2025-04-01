package logbook.week3;

import java.util.*;

class Student {
    private String studentID;
    private String name;
    private Map<String, Integer> moduleMarks; // Module code -> Marks

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.moduleMarks = new HashMap<>();
    }

    public String getStudentID() { return studentID; }
    public String getName() { return name; }
    public Map<String, Integer> getModuleMarks() { return moduleMarks; }

    public void addModuleMark(String moduleCode, int mark) {
        moduleMarks.put(moduleCode, mark);
    }
}

class Module {
    private String moduleCode;
    private String moduleName;
    private List<Integer> marks;

    public Module(String moduleCode, String moduleName) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.marks = new ArrayList<>();
    }

    public String getModuleCode() { return moduleCode; }
    public String getModuleName() { return moduleName; }
    public List<Integer> getMarks() { return marks; }

    public void addMark(int mark) {
        marks.add(mark);
    }

    public double calculateMean() {
        return marks.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public int getMinMark() {
        return marks.stream().mapToInt(Integer::intValue).min().orElse(0);
    }

    public int getMaxMark() {
        return marks.stream().mapToInt(Integer::intValue).max().orElse(0);
    }
}

class MarksAndGrades {
    public static String getGrade(int mark) {
        if (mark >= 70) return "A First Class";
        else if (mark >= 60) return "B Upper Second Class";
        else if (mark >= 50) return "C Lower Second Class";
        else if (mark >= 40) return "Third Class";
        else return "F Fail";
    }
}

public class Main {
    private static List<Student> students = new ArrayList<>();
    private static List<Module> modules = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Add Module");
            System.out.println("3. Assign Marks");
            System.out.println("4. Display Student Grades");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    students.add(new Student(studentID, name));
                    break;
                case 2:
                    System.out.print("Enter Module Code: ");
                    String moduleCode = scanner.nextLine();
                    System.out.print("Enter Module Name: ");
                    String moduleName = scanner.nextLine();
                    modules.add(new Module(moduleCode, moduleName));
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextLine();
                    System.out.print("Enter Module Code: ");
                    moduleCode = scanner.nextLine();
                    System.out.print("Enter Mark: ");
                    int mark = scanner.nextInt();
                    for (Student s : students) {
                        if (s.getStudentID().equals(studentID)) {
                            s.addModuleMark(moduleCode, mark);
                        }
                    }
                    for (Module m : modules) {
                        if (m.getModuleCode().equals(moduleCode)) {
                            m.addMark(mark);
                        }
                    }
                    break;
                case 4:
                    for (Student s : students) {
                        System.out.println("Student: " + s.getName());
                        for (Map.Entry<String, Integer> entry : s.getModuleMarks().entrySet()) {
                            System.out.println("Module: " + entry.getKey() + ", Mark: " + entry.getValue() + ", Grade: " + MarksAndGrades.getGrade(entry.getValue()));
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
