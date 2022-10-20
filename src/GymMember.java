import java.time.LocalDate;
import java.time.Period;


public class GymMember {

    private final String personNumber;
    private final String fullName;
    private final String dateLastPayment;

    public GymMember(String personNumber, String fullName, String dateLastPayment) {
        this.personNumber = personNumber;
        this.fullName = fullName;
        this.dateLastPayment = dateLastPayment;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDateLastPayment() {
        return dateLastPayment;
    }

    public String nameToLowerCase() {
        return fullName.toLowerCase();
    }

    public String gymMemberToString() {
        return personNumber + ", " + fullName;
    }

    //TODO----------------------------------------LÄSER IN OCH PARSAR DATUM-------------------------------------------------
    public boolean isActiveMember(boolean test) {

        if (test) {
            return Period.between
                    (LocalDate.parse(dateLastPayment),
                            LocalDate.of(2022, 10, 17)).getYears() == 0;

        } else
            return Period.between
                    (LocalDate.parse(dateLastPayment), LocalDate.now()).getYears() == 0;
    }
}
