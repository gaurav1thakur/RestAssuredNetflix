public class Application {

    private String AppName;
    private int MembershipID;
    private String MembershipStatus;
    private Profile profile[];

    public String getAppName() {
        return AppName;
    }

    public void setAppName(String appName) {
        AppName = appName;
    }

    public int getMembershipID() {
        return MembershipID;
    }

    public void setMembershipID(int membershipID) {
        MembershipID = membershipID;
    }

    public String getMembershipStatus() {
        return MembershipStatus;
    }

    public void setMembershipStatus(String membershipStatus) {
        MembershipStatus = membershipStatus;
    }

    public Profile[] getProfile() {
        return profile;
    }

    public void setProfile(Profile[] profile) {
        this.profile = profile;
    }
}
