package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    @Test
    @DisplayName("Test ReadData by comparing ID with each student is the list")
    void testReadData()
    {
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        StudentList sList = datasource.readData();

        assertEquals("6710400001",sList.getStudents().getFirst().getId());
        assertEquals("6710400002",sList.getStudents().get(1).getId());
        assertEquals("6710400003",sList.getStudents().get(2).getId());
    }
}