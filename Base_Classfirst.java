package Base_Class;


import Utility.Excel_File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.*;
import java.util.Properties;
import java.util.Random;

public class Base_Class extends Excel_File {

    static RequestSpecBuilder requestSpecBuilder;
    static public String current_path = System.getProperty("user.dir");
    public static ExtentReports extent = new ExtentReports();
    public static ExtentSparkReporter htmlReporter = new ExtentSparkReporter(current_path+"/src/test/report.html");
    public static Properties prop = new Properties();
    public static File configFile;
    public static FileInputStream fis;
    public String random_email_generator() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10000);
        String random_username = "user".concat(String.valueOf(randomInt));
        return random_username.concat("@gmail.com");
    }



    @BeforeTest
    public RequestSpecification setup() throws IOException {
        configFile = new File(current_path+"/src/test/resources.properties");
        fis = new FileInputStream(configFile);
        prop = new Properties();
        prop.load(fis);
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(prop.getProperty("Base_URI"));
        requestSpecBuilder.setContentType(prop.getProperty("content-type"));
        requestSpecBuilder.log(LogDetail.ALL);
        return requestSpecBuilder.build();
    }
    @AfterTest
    public void close()
    {
        extent.flush();
    }

}