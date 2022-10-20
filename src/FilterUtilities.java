
import java.util.ArrayList;
import java.util.List;

public class FilterUtilities{

    public List<GymMember> addMemberToNewList(List<GymMember> gymMemberList, String input) {

        List<GymMember> filteredList = new ArrayList<>();

        String trimmedInput = input.trim().toLowerCase();
        boolean loop = true;


        try {
//-----------------------------------------------------OM NAMN----------------------------------------------------------

            if (isNameValid(trimmedInput) && !isPersonNumberValid(trimmedInput)) {

                while (loop) {

                    for (GymMember gymMember : gymMemberList) {

                        if (gymMember.nameToLowerCase().trim().equals(trimmedInput)) {
                            if (gymMember.isActiveMember(false)) {
                                filteredList.add(gymMember);
                                break;
                            }
                        }
                    }
                    loop = false;
                }
//-------------------------------------------------OM PERSONNUMMER------------------------------------------------------

            } else if (!isNameValid(trimmedInput) && isPersonNumberValid(trimmedInput)) {

                while (loop) {

                    for (GymMember gymMember : gymMemberList) {

                        if (gymMember.getPersonNumber().trim().equals(trimmedInput)) {
                            if (gymMember.isActiveMember(false)) {
                                filteredList.add(gymMember);
                                break;
                            }
                        }
                    }
                    loop = false;
                }
            }
//TODO------------------------------------------------FELHANTERING------------------------------------------------------

        } catch (Exception e) {
            System.out.println("Oops! Something went wrong");
            e.printStackTrace();
        }
        return filteredList;
    }

    public boolean isObjectInList(List<GymMember> gymMemberList, String input) {

        String trimmedInput = input.trim().toLowerCase();
        boolean nameFound = false;
        boolean loop = true;


        try {
//----------------------------------------------------OM NAMN-----------------------------------------------------------

            if (isNameValid(trimmedInput) && !isPersonNumberValid(trimmedInput)) {

                while (loop) {

                    for (GymMember gymMember : gymMemberList) {

                        if (gymMember.nameToLowerCase().trim().equals(trimmedInput)) {
                            nameFound = true;
                            break;
                        }
                    }
                    loop = false;
                }

//------------------------------------------------OM PERSONNUMMER-------------------------------------------------------

            } else if (!isNameValid(trimmedInput) && isPersonNumberValid(trimmedInput)) {

                while (loop) {

                    for (GymMember gymMember : gymMemberList) {

                        if (gymMember.getPersonNumber().trim().equals(trimmedInput)) {
                            nameFound = true;
                            break;
                        }
                    }
                    loop = false;
                }

//TODO---------------------------------------------FELHANTERING---------------------------------------------------------

            } else {
                System.out.println("Wrong format\n");
                return false;
            }


        } catch (IndexOutOfBoundsException e) {
            System.out.println("Oops! Something happened");
            e.printStackTrace();
        }


        if (!nameFound) {
            System.out.println("The name/person-ID you've entered does not exist\n");
        }

//------------------------------------------------OM NAMN HITTAS--------------------------------------------------------
        return nameFound;
    }

    public boolean isNameValid(String input) {

        boolean isValid = true;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                isValid = false;
            }
        }
        return isValid;
    }

    public boolean isPersonNumberValid(String input) {
        boolean isValid = true;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isAlphabetic(input.charAt(i))) {
                isValid = false;
            }
        }
        return isValid;
    }

}

