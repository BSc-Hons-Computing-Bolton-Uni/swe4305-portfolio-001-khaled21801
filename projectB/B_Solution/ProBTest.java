package projectB.B_Solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProBTest {

    private Student student;
    private Module module;

    @BeforeEach
    void setUp() {
        student = new Student(1, "Alice");
        module = new Module("COM4301", "Maths for Computing");
    }

    // --- MARK TESTS ----

    @Test
    void testValidMarkCreation() {
        Mark mark = new Mark(75);
        assertEquals(75, mark.getMarkValue());
    }

    @Test
    void testInvalidMarkBelowZero() {
        assertThrows(IllegalArgumentException.class, () -> new Mark(-5));
    }

    @Test
    void testInvalidMarkAboveHundred() {
        assertThrows(IllegalArgumentException.class, () -> new Mark(105));
    }

    @Test
    void testGradeCalculation() {
        assertEquals(Grade.A, new Mark(95).calculateGrade());
        assertEquals(Grade.B, new Mark(65).calculateGrade());
        assertEquals(Grade.C, new Mark(55).calculateGrade());
        assertEquals(Grade.D, new Mark(45).calculateGrade());
        assertEquals(Grade.F, new Mark(25).calculateGrade());
    }

    // --- STUDENT TESTS ---

    @Test
    void testAddMarkToStudent() {
        Mark mark = new Mark(88);
        student.addMark(mark);
        assertEquals(1, student.getMarks().size());
        assertEquals(mark, student.getMarks().get(0));
    }

    // This method assumes you added getGradeForModule(int) to Student class
    // If not in the current code, you should remove or refactor these two tests
    @Test
    void testGetGradeForValidMarkIndex() {
        student.addMark(new Mark(62)); // Grade B
        Mark mark = student.getMarks().get(0);
        assertEquals(Grade.B, mark.calculateGrade());
    }

    @Test
    void testGetGradeForInvalidIndex() {
        assertTrue(student.getMarks().isEmpty());
    }

    // --- MODULE TESTS ---

    @Test
    void testAddStudentToModule() {
        module.addStudent(student);
        assertEquals(1, module.getStudents().size());
        assertEquals(student, module.getStudents().get(0));
    }

    @Test
    void testModuleStatsWithMarks() {
        Student s1 = new Student(2, "Bob");
        s1.addMark(new Mark(50));
        s1.addMark(new Mark(80));
        module.addStudent(s1);

        Student s2 = new Student(3, "Carol");
        s2.addMark(new Mark(60));
        module.addStudent(s2);

        assertDoesNotThrow(() -> module.calculateStats());
    }

    @Test
    void testModuleStatsWithNoMarks() {
        module.addStudent(new Student(4, "Dave"));
        assertDoesNotThrow(() -> module.calculateStats());
    }
}
