import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterUtilitiesTest {

    IOUtilities ioUtils = new IOUtilities();
    FilterUtilities filterUtils = new FilterUtilities();
    Path inDataPath = Paths.get("src/customers.txt");
    List<GymMember> testList = ioUtils.readFromFileToList(inDataPath);

    String testInput1 = "Elmer Ekorrsson";
    String testInput2 = "7605021234";
    String testInput3 = "Elmer 123";
    String testInput4 = "7605021234 Elmer Ekorrsson";
    String testInput5 = "Jack Elvinsson";


    // Checks if given object is in the object list
    @Test
    void isObjectInListTest() {

        assertTrue(filterUtils.isObjectInList(testList, testInput1));

        assertTrue(filterUtils.isObjectInList(testList, testInput2));

        assertFalse(filterUtils.isObjectInList(testList, testInput3)); //should print "Wrong format"

        assertFalse(filterUtils.isObjectInList(testList, testInput4)); //should print "Wrong format"

        assertFalse(filterUtils.isObjectInList(testList, testInput5)); // should print "The name/person-ID does not exist"
    }

    // Checks if input is letters only
    @Test
    void isNameValidTest() {

        assertTrue(filterUtils.isNameValid(testInput1));

        assertFalse(filterUtils.isNameValid(testInput2));

        assertFalse(filterUtils.isNameValid(testInput3));

        assertFalse(filterUtils.isNameValid(testInput4));

        assertTrue(filterUtils.isNameValid(testInput5));
    }

    // Checks if input is numbers only
    @Test
    void isPersonNumberValidTest() {

        assertFalse(filterUtils.isPersonNumberValid(testInput1));

        assertTrue(filterUtils.isPersonNumberValid(testInput2));

        assertFalse(filterUtils.isPersonNumberValid(testInput3));

        assertFalse(filterUtils.isPersonNumberValid(testInput4));

        assertFalse(filterUtils.isPersonNumberValid(testInput5));
    }

    // Checks if given object is successfully added to new list
    @Test
    void addMemberToNewList() {

        List <GymMember> newTestList = filterUtils.addMemberToNewList(testList, testInput1); // Should add GymMember("7605021234","Elmer Ekorrsson","2021-11-07") to the new list

        assertEquals ("7605021234", newTestList.get(0).getPersonNumber());

        assertEquals("Elmer Ekorrsson", newTestList.get(0).getFullName());

        assertEquals("2021-11-07", newTestList.get(0).getDateLastPayment());

    }
}
