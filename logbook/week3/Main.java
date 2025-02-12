package logbook.week3;

public class Main {

    // Step 1: Student class with attributes for ID and name
    public static class Student {
        // Declaring the attributes
        private int id;
        private String name;
        private Course course; // Attribute for Course object

        // Step 2: Constructor to assign values to id, name, and course
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        // Step 9: Method to enrol in a course
        public void enrol(Course newCourse) {
            this.course = newCourse; // Assigning the course to the student
            System.out.println(name + " has been enrolled in " + newCourse.getName() + " (" + newCourse.getCode() + ")");
        }

        // Step 10: Modified print method to print both student and course details
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

    // Step 6: Course class with attributes for code and name
    public static class Course {
        private String code;
        private String name;

        // Step 7: Constructor to initialize course code and name
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

        // Step 7: Print method for course details
        public void printCourseDetails() {
            System.out.println("Course Code: " + code);
            System.out.println("Course Name: " + name);
        }
    }

    // Step 11 and Step 12: Main method to test Student and Course classes
    public static void main(String[] args) {
        // Step 4: Instantiate the Course class
        Course course1 = new Course("CS101", "Introduction to Computer Science");

        // Step 4: Instantiate the Student class
        Student student1 = new Student(12345678, "khaled");

        // Step 5: Call the print method to see initial student details
        student1.print();

        // Step 11: Enrol the student in the course
        student1.enrol(course1);

        // Step 12: Call the print method again to show updated student and course details
        student1.print();
    }
}
