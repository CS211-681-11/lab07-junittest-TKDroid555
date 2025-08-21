package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    @Test
    @DisplayName("Test constructor")
    void testStudentList()
    {
        StudentList sList = new StudentList();
        assertNotNull(sList.getStudents());
    }

    @Test
    @DisplayName("Test constructor by comparing each student in the list with their ID")
    void testAddNewStudent()
    {
        ArrayList<Student> testList = new ArrayList<>();
        StudentList sList = new StudentList();
        sList.addNewStudent("6710000001","A");
        sList.addNewStudent("6710000002","B",5);
        sList.addNewStudent("6710000003","C",65);

        testList = sList.getStudents();
        String s1ID = testList.get(0).getId();
        double s1Score = testList.get(0).getScore();
        String s2Name = testList.get(1).getName();
        double s3Score = testList.get(2).getScore();

        assertEquals("6710000001", s1ID);
        assertEquals(0, s1Score);
        assertEquals("B", s2Name);
        assertEquals(65.0, s3Score);
    }

    @Test
    @DisplayName("Test find student by ID by see if Student object is null or not")
    void testFindStudentById()
    {
        StudentList sList = new StudentList();
        sList.addNewStudent("6710000001","A");
        sList.addNewStudent("6710000002","B",5);
        sList.addNewStudent("6710000003","C",65);

        Student sNULL = sList.findStudentById("6710000009");
        Student s1 = sList.findStudentById("6710000001");
        Student s2 = sList.findStudentById("6710000002");

        assertNull(sNULL);
        assertNotNull(s1);
        assertNotNull(s2);
    }

    @Test
    @DisplayName("Test FilterByName by filter with 'CD' to remove first student of the list then compare name of each list first student by their name")
    void testFilterByName()
    {
        //Test with filter "CD"
        StudentList sList = new StudentList();
        sList.addNewStudent("6710000001","ABC");
        sList.addNewStudent("6710000002","BCD",5);
        sList.addNewStudent("6710000003","CDE",65);

        StudentList sListExpected = new StudentList();
        sListExpected.addNewStudent("6710000002","BCD",5);
        sListExpected.addNewStudent("6710000003","CDE",65);

        StudentList filteredSList = sList.filterByName("CD");

        String firstSListName = sList.getStudents().getFirst().getName();
        String firstSListExpectedName = sListExpected.getStudents().getFirst().getName();
        String firstFilteredListName = filteredSList.getStudents().getFirst().getName();

        assertNotEquals(firstSListName,firstFilteredListName);
        assertEquals(firstSListExpectedName,firstFilteredListName);
    }

    @Test
    @DisplayName("Test GiveScoreToId by adding score to 2 students then check scores of 3 accordingly")
    void testGiveScoreToId()
    {
        StudentList sList = new StudentList();
        sList.addNewStudent("6710000001","ABC");
        sList.addNewStudent("6710000002","BCD",5);
        sList.addNewStudent("6710000003","CDE",65);

        sList.giveScoreToId("6710000001",25);
        sList.giveScoreToId("6710000002",25);

        Student s1 = sList.getStudents().get(0);
        Student s2 = sList.getStudents().get(1);
        Student s3 = sList.getStudents().get(2);

        assertEquals(25, s1.getScore());
        assertEquals(30, s2.getScore());
        assertEquals(65, s3.getScore());
    }

    @Test
    @DisplayName("Test ViewGradeOfId by assigning score to each student and then check their grade accordingly")
    void testViewGradeOfId()
    {
        StudentList sList = new StudentList();
        sList.addNewStudent("6710000001","ABC"); //F
        sList.addNewStudent("6710000002","BCD",50); //D
        sList.addNewStudent("6710000003","CDE",95); //A

        String s1Grade = sList.viewGradeOfId("6710000001");
        String s2Grade = sList.viewGradeOfId("6710000002");
        String s3Grade = sList.viewGradeOfId("6710000003");

        assertEquals("F",s1Grade);
        assertEquals("D",s2Grade);
        assertEquals("A",s3Grade);
    }
}