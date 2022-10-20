import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOUtilities {


    public List<GymMember> readFromFileToList(Path inDataPath) {

        List<GymMember> gymMemberList = new ArrayList<>();

        String firstLine = "";
        String secondLine = "";


//TODO --------------------------------------------TRY-WITH-RESOURCES---------------------------------------------------

        try (Scanner scanner = new Scanner(inDataPath)) {

//TODO ---------------------------------------------LÄSER FRÅN FIL------------------------------------------------------

            while (scanner.hasNextLine()) {

                if (scanner.hasNextLine()) {
                    firstLine = scanner.nextLine();
                    if (scanner.hasNextLine()) {
                        secondLine = scanner.nextLine();
                    }

                    String[] firstLineArray = firstLine.trim().split(",");
                    String[] secondLineArray = new String[]{secondLine.trim()};


//---------------------------------------CREATES OBJECT AND ADDS IT TO THE LIST-----------------------------------------

                    GymMember gymMember = new GymMember(firstLineArray[0].trim(),firstLineArray[1].trim(),
                            secondLineArray[0].trim());

                    gymMemberList.add(gymMember);

//--------------------------------------------------FELHANTERING--------------------------------------------------------
                }
            }
        }catch(IOException e){
            System.out.println("Oops! Something went wrong");
            e.printStackTrace();
        }


        return gymMemberList;
    }

    public void printTofile(GymMember gymMember, LocalDate date, boolean test) {

        String filename = "src/" + gymMember.getPersonNumber() + ".txt";
        Path writeToFilePath = Paths.get(filename);

        //Test variables
        String filenameTest = "src/" + gymMember.getPersonNumber() + "_test.txt";
        Path writeToTestPath = Paths.get(filenameTest);

        if(test) {
            filename = filenameTest;
            writeToFilePath = writeToTestPath;
        }

        boolean newFile = !Files.exists(writeToFilePath);

//TODO-------------------------------------------SKRIVER TILL FIL-------------------------------------------------------

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true))) {

            if(newFile) {
                bufferedWriter.write(gymMember.gymMemberToString() + "\n"
                        + date.toString() + "\n");

            } else
                bufferedWriter.write(date.toString() + "\n");

//TODO---------------------------------------------FELHANTERING---------------------------------------------------------

        } catch (
                FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();

        } catch (
                IOException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();

        } catch (
                Exception e) {
            System.out.println("Oops! Something went wrong");
            e.printStackTrace();
        }
    }

    // TEST PRINTER
//    public void printToFileTest (GymMember gymMember) {
//
//        String testFileName = "src/" + gymMember.getPersonNumber() + "_test.txt";
//        Path testFilePath = Paths.get(testFileName);
//        LocalDate testDate = LocalDate.of(2022, 10, 17);
//        boolean newTestFile = !Files.exists(testFilePath);
//
////---------------------------------------------------PRINTER------------------------------------------------------------
//
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(testFileName))) {
//
//            if (newTestFile) {
//                bufferedWriter.write(gymMember.gymMemberToString() + "\n"
//                        + testDate + "\n");
//
//            } else
//                bufferedWriter.write(testDate + "\n");
//
////TODO---------------------------------------------FELHANTERING---------------------------------------------------------
//
//        } catch (
//                FileNotFoundException e) {
//            System.out.println("File not found");
//            e.printStackTrace();
//
//        } catch (
//                IOException e) {
//            System.out.println("Could not write to file");
//            e.printStackTrace();
//
//        } catch (
//                Exception e) {
//            System.out.println("Oops! Something went wrong");
//            e.printStackTrace();
//        }
//    }
}
