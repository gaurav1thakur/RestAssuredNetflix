import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.Reporter;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.RestAssured.given;
//import Rest Assured as static to access static methods directly

public class PostDataCall {
    public static void main (String args[])
    {   Application application = new Application();
        Profile profile[] = new Profile[4];
        //initialize all profile
        profile[0] = new Profile();
        profile[1] = new Profile();
        profile[2] = new Profile();
        profile[3] = new Profile();

        //creating 4 profile for Netflix
        profile[0].setImage("Dad_Image");
        profile[0].setName("Dad");
        Reporter.log("Profile 0 Name "+ profile[0].getName(),true);
        Reporter.log("Profile 0 Image "+ profile[0].getImage(),true);

        profile[1].setName("Mom");
        profile[1].setImage("Mom_Image");

        Reporter.log("Profile 1 Name "+ profile[1].getName(),true);
        Reporter.log("Profile 1 Image "+ profile[1].getImage(),true);

        profile[2].setImage("Brother");
        profile[2].setName("Brother_Image");

        Reporter.log("Profile 2 Name "+ profile[2].getName(),true);
        Reporter.log("Profile 2 Image "+ profile[2].getImage(),true);

        profile[3].setName("Sister");
        profile[3].setImage("Sister_Image");

        Reporter.log("Profile 3 Name "+ profile[3].getName(),true);
        Reporter.log("Profile 3 Image "+ profile[3].getImage(),true);

        //Membership Details
        application.setProfile(profile);
        application.setAppName("Netflix");
        application.setMembershipID(4567);
        application.setMembershipStatus("valid");

        Response res =
                 given()
                .body(application)
                .contentType(ContentType.JSON)
                .when()
                .post("http:// :3000/Application");

        Reporter.log("Status Code is " + res.getStatusCode(),true);
        Reporter.log("Status Line is " + res.getStatusLine(),true);
        Reporter.log("JSON DATA is "+  res.asString(),true);
    }}
