package com.example.demo;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{retailerId}/memberDetails")
public class MemberDetailRestController {

    public static class MemberDetailsResponseModel{

        private String eventId;
        private String memberName;
        private String membershipNumber;
        private Integer membershipLevel;

        public String getEventId() {
            return eventId;
        }

        public void setEventId(String eventId) {
            this.eventId = eventId;
        }

        public String getMemberName() {
            return memberName;
        }

        public void setMemberName(String memberName) {
            this.memberName = memberName;
        }

        public String getMembershipNumber() {
            return membershipNumber;
        }

        public void setMembershipNumber(String membershipNumber) {
            this.membershipNumber = membershipNumber;
        }

        public Integer getMembershipLevel() {
            return membershipLevel;
        }

        public void setMembershipLevel(Integer membershipLevel) {
            this.membershipLevel = membershipLevel;
        }
    }

    private MemberDetailsResponseModel memberDetailsModel = new MemberDetailsResponseModel();

    //init model
    public MemberDetailRestController() {
        memberDetailsModel.setEventId("R000000037");
        memberDetailsModel.setMemberName("Test Standard");
        memberDetailsModel.setMembershipLevel(2);
        memberDetailsModel.setMembershipNumber("INT1000");
    }

    @RequestMapping(method = RequestMethod.GET)
    public MemberDetailsResponseModel getMemberDetails(
            MemberDetailsResponseModel memberDetailsModel) {

        return this.memberDetailsModel;

    }

    @RequestMapping(method = RequestMethod.POST)
    public MemberDetailsResponseModel edit(
            @RequestBody MemberDetailsResponseModel memberDetailsModel) {
        this.memberDetailsModel = memberDetailsModel;
        return  this.memberDetailsModel;
    }
}
