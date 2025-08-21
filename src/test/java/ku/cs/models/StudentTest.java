package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("Test Constructor")
    void testStudent()
    {
        Student s = new Student("6710000001","Boy1");
        assertEquals("6710000001",s.getId());
        assertEquals("Boy1",s.getName());
        assertEquals(0,s.getScore());

        Student s2 = new Student("6710000002","Boy2",25);
        assertEquals("6710000002",s2.getId());
        assertEquals("Boy2",s2.getName());
        assertEquals(25.0,s2.getScore());
    }

    @Test
    @DisplayName("Test changing name of student")
    void testChangeName()
    {
        Student s = new Student("6710000001","Boy1");
        s.changeName("Boi2");
        assertEquals("Boi2",s.getName());
    }

    @Test
    @DisplayName("Test adding score by 50.05")
    void testAddScore()
    {
        Student s = new Student("6710000001", "StudentA");
        s.addScore(50.05);
        assertEquals(50.05, s.getScore());
    }

    @Test
    @DisplayName("Test check grade from score")
    void testCalculateGrade()
    {
        Student s = new Student("6710000002", "StudentA");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("Test isId")
    void testIsId()
    {
        Student s = new Student("6710000001", "A");
        assertTrue(s.isId("6710000001"));
        assertFalse(s.isId("6710000005"));
    }

    @Test
    @DisplayName("Test isNameContains by comparing multiple strings")
    void testIsNameContains()
    {
        Student s = new Student("6710000001", "HelloWorldBoy");

        assertTrue(s.isNameContains("Hel"));
        assertTrue(s.isNameContains("Hello"));
        assertTrue(s.isNameContains("WorldB"));
        assertTrue(s.isNameContains("HelloWorldBoy"));

        assertFalse(s.isNameContains("HelloWorldBoys"));
        assertFalse(s.isNameContains("Wordl"));
        assertFalse(s.isNameContains("George"));
    }

    @Test
    @DisplayName("Test toString")
    void testToString()
    {
        Student s1 = new Student("6710000001", "ABCD");
        Student s2 = new Student("6710000002", "Gurt Yo", 25.2);
        Student s3 = new Student("6710000003", "LimmaB", 80.67);

        String s1String = s1.toString();
        String s2String = s2.toString();
        String s3String = s3.toString();

        assertEquals("{" + "id: '" + "6710000001" + '\'' + ", name: '" + "ABCD" + '\'' + ", score: " + "0.0" + '}', s1String);
        assertEquals("{" + "id: '" + "6710000002" + '\'' + ", name: '" + "Gurt Yo" + '\'' + ", score: " + "25.2" + '}', s2String);
        assertEquals("{" + "id: '" + "6710000003" + '\'' + ", name: '" + "LimmaB" + '\'' + ", score: " + "80.67" + '}', s3String);
    }
}