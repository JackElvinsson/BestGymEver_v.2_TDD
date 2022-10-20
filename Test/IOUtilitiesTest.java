import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class IOUtilitiesTest {

    IOUtilities ioUtils = new IOUtilities();

    Path inDataPath = Paths.get("src/customers.txt");

    List<GymMember> testList = ioUtils.readFromFileToList(inDataPath);




    // Checks if the list generated from the text file is correct.
    @Test
    void readFromFileToListTest() {

        assertEquals("Hilmer Heur", testList.get(7).getFullName());

        assertFalse(testList.get(7).isActiveMember(true));

        assertEquals("9902149834", testList.get(9).getPersonNumber());

        assertEquals(14, testList.size());

        assertNotEquals(18, testList.size());
    }




    // Should print 10 random objects to either the console or a text document.
    // If the object is a paying member it will print to corresponding .txt log file, or create a new one if none exists.
    // If the object is not an active member it will print that the object is not a paying member to the console.
    @Test
    void printToFileTest() {

        int counter = 0;
        while (counter < 10) {
            GymMember testMember = testList.get(randomNumberGenerator());
            if (testMember.isActiveMember(true)) {
                ioUtils.printTofile(testMember, LocalDate.of(2022, 10, 17), true);
            } else {
                System.out.println(testMember.gymMemberToString());
                System.out.println("Not a paying member\n");
            }
            counter ++;
        }

    }

    int randomNumberGenerator() {
        Random r = new Random();
        int low = 0;
        int high = 13;
        return r.nextInt(high - low) + low;
    }
}