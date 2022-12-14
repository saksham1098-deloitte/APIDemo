goitpackage Page;
import Base_Class.Base_Class;
import Utility.MyException;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.restassured.response.Response;
import org.testng.Assert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import java.io.IOException;
import java.util.List;
import static io.restassured.RestAssured.given;
public class GetRequest extends Base_Class {
    public void get_products() throws IOException {

try {
    extent.attachReporter(htmlReporter);
    ExtentTest test = extent.createTest("Test No.1","This is  get_product API ");
    Response response = given().
            spec(setup()).
            when().
            get(prop.getProperty(("end_apiGetProducts"))).
            then().
            log().body().
            extract().
            response();

     if  (!(response.getStatusCode()==(Integer.parseInt(prop.getProperty("unauthorized_response_code"))))) ;
     else {
         throw new MyException("Error Occured");

     }

//    test.log(Status.PASS, "Assertion for response code of get_products ");
//    List<String> GenderResponse = response.path("products.category.gender");
//    List<String> CategoryResponse = response.path("products.category.category");
//    Assert.assertTrue(GenderResponse.contains("Women"));
//    test.log(Status.PASS, "Assertion for Women Category of get_products ");
//    Assert.assertTrue(GenderResponse.contains("Men"));
//    test.log(Status.PASS, "Assertion for Men Category of get_products ");
//    Assert.assertTrue(CategoryResponse.contains("Top Wear"));
//    test.log(Status.PASS, "Assertion for Wear Category of get_products ");





}
catch (MyException ex) {


    System.out.println(ex.getMessage());
}
    }
    public void get_products3() throws IOException {
        extent.attachReporter(htmlReporter);
        ExtentTest test = extent.createTest("Test No.2 ","This is get products3 API");

        try {
            Response response = given().
                    spec(setup()).
                    when().
                    get(prop.getProperty("end_apiGetProducts3")).
                    then().
                    log().body().
                    extract().
                    response();
            assertThat(response.getStatusCode(), equalTo(Integer.parseInt(prop.getProperty("response_code"))));
            test.log(Status.PASS, "Assertion for response code of get_products3 ");
            int Id = response.path("id");
            System.out.println(Id);
            String GenderResponse = response.path("category.gender");
            String CategoryResponse = response.path("category.category");
            System.out.println(GenderResponse);
            System.out.println(CategoryResponse);
            Assert.assertTrue(GenderResponse.contains("Women"));
            test.log(Status.PASS, "Assertion for Women Category under get_products3 ");
            Assert.assertTrue(CategoryResponse.contains("Top Wear"));
            test.log(Status.PASS, "Assertion for Wear Category under get_products3 ");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void get_productsWomen() throws IOException {
        extent.attachReporter(htmlReporter);
        ExtentTest test = extent.createTest("Test No.3","This is get products Women API ");
        try {
            Response response = given().
                    spec(setup()).
                    when().
                    get(prop.getProperty("end_apiGetProductsWomen")).
                    then().
                    log().body().
                    extract().
                    response();
            assertThat(response.getStatusCode(), equalTo(Integer.parseInt(prop.getProperty("response_code"))));
            test.log(Status.PASS, "Assertion for response code of get_productsWomen ");

            List<String> GenderResponse = response.path("products.category.gender");
            List<String> CategoryResponse = response.path("products.category.category");
            System.out.println(GenderResponse);
            System.out.println(CategoryResponse);
            Assert.assertTrue(GenderResponse.contains("Women"));
            test.log(Status.PASS, "Assertion for Women Category under get_productsWomen  ");
            Assert.assertTrue(CategoryResponse.contains("Top Wear"));
            test.log(Status.PASS, "Assertion for Wear Category under get_productsWomen ");


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }




}
