import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

//-------------------------------------------------BEST GYM EVER--------------------------------------------------------

public class Main {

    public Path inDataPath = Paths.get("src/customers.txt");
    FilterUtilities filterUtilities = new FilterUtilities();
    IOUtilities ioUtilities = new IOUtilities();

//--------------------------------------------------HUVUDPROGRAM--------------------------------------------------------

    Main() {

        Scanner scanner = new Scanner(System.in);
        List<GymMember> gymMemberList = ioUtilities.readFromFileToList(inDataPath);
        List<GymMember> filteredList;


        while (true) {

            try {

                System.out.println("""
                        ╔***************************************╗
                        ║      ~Welcome to Best Gym Ever!~      ║
                        ║                                       ║
                        ║ Enter your full name or person number ║
                        ║                                       ║
                        ║   Type "exit" to close the program    ║
                        ╚***************************************╝
                        """);

                String input = scanner.nextLine().toLowerCase().trim();

                // Exit command
                if (input.equals("exit")){
                    System.exit(0);
                }


                if (filterUtilities.isObjectInList(gymMemberList, input)) {
                    filteredList = filterUtilities.addMemberToNewList(gymMemberList, input);
                    ioUtilities.printTofile(filteredList.get(0), LocalDate.now(), false);
                    if(!filteredList.isEmpty())
                        System.out.println("You currently have an active membership at Best Gym Ever!\n" +
                                "You are checked in and free to proceed in to the gym!\n");
                }

//TODO---------------------------------------------FELHANTERING---------------------------------------------------------

                // Catch eller else? Båda fungerar
            }catch (IndexOutOfBoundsException e) {
                System.out.println("You are in the list but you do not have an active membership\n");
            }
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {

        Main main = new Main();
    }
}