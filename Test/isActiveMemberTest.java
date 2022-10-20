import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class isActiveMemberTest {

    GymMember Alhambra = new GymMember("7703021234","Alhambra Aromes","2022-07-01");

    GymMember Elmer = new GymMember("7605021234","Elmer Ekorrsson","2021-11-07");

    GymMember Fritjoff = new GymMember("7911061234","Fritjoff Flacon","2016-12-16");

    GymMember Chamade = new GymMember("8512021234","Chamade Coriola","2018-03-12");


    List <GymMember> gymMemberList = List.of(Alhambra, Elmer, Fritjoff, Chamade);

    // Checks if the given object is an active member
    @Test
    void isActiveMember() {

        assert(gymMemberList.get(0).isActiveMember(true));

        assert(gymMemberList.get(1).isActiveMember(true));

        assertFalse(gymMemberList.get(2).isActiveMember(true));

        assertFalse(gymMemberList.get(3).isActiveMember(true));
    }
}