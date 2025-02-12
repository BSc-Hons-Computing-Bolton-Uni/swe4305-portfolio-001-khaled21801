package logbook.week3;

public class Main {

    // Student class
    public static class Student {
        // Declaring the attributes as final (immutable)
        private final int id;
        private final String name;
        private Course course; // Course object (can change if needed)

        // Constructor to assign values to id, name
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        // Method to enrol in a course
        public void enrol(Course newCourse) {
            this.course = newCourse; // Assigning the course to the student
            System.out.println(name + " has been enrolled in " + newCourse.getName() + " (" + newCourse.getCode() + ")");
        }

        // Modified print method to print both student and course details
        public void print() {
            System.out.println("Student ID: " + id);
            System.out.println("Student Name: " + name);
            if (course != null) {
                course.printCourseDetails(); // Calling course's print method
            } else {
                System.out.println("No course assigned.");
            }
        }
    }

    // Course class
    public static class Course {
        // Declaring the attributes as final (immutable)
        private final String code;
        private final String name;

        // Constructor to initialize course code and name
        public Course(String code, String name) {
            this.code = code;
            this.name = name;
        }

        // Getters for course details
        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        // Print method for course details
        public void printCourseDetails() {
            System.out.println("Course Code: " + code);
            System.out.println("Course Name: " + name);
        }
    }

    // Main method to test Student and Course classes
    public static void main(String[] args) {
        // Instantiate the Course class
        Course course1 = new Course("CS101", "Introduction to Computer Science");

        // Instantiate the Student class
        Student student1 = new Student(12345678, "khaled");

        // Call the print method to see initial student details
        student1.print();

        // Enrol the student in the course
        student1.enrol(course1);

        // Call the print method again to show updated student and course details
        student1.print();
    }
}
