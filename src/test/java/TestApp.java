import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestApp {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        //Navigate to http://duotify.us-east-2.elasticbeanstalk.com/register.php
        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        //Verify the title is "Welcome to Duotify!"
        String expected = "Welcome to Duotify!";
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
        System.out.println(actual);
        //Click on Signup here
        driver.findElement(By.id("hideLogin")).click();
        //Fill out the form with the required info
        String firstName =  generateFirstName();
        String userName = generateUserName();
        String lastName = generateLastName();
        String email = generateEmail();
        String password = generatePassword();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("email2")).click();
        driver.findElement(By.id("email2")).sendKeys(email);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password2")).click();
        driver.findElement(By.id("password2")).sendKeys(password);
        //Click on Sign up
        driver.findElement(By.name("registerButton")).click();
        //Once logged in to the application, verify that the URL is:
        String expectedUrl = "http://duotify.us-east-2.elasticbeanstalk.com/browse.php?";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        //In the left navigation bar, verify that your first and last name matches the first and last name that you used when signing up.
        String expectedFullName = firstName + " " + lastName;
        String actualFullName = String.valueOf(driver.findElement(By.id("nameFirstAndLast")));
        Assert.assertEquals(actualFullName, expectedFullName);
        //Click on the username on the left navigation bar and verify the username on the main window is correct and then click logout.
        driver.findElement(By.id("nameFirstAndLast")).click();
        String actualFullNameMain = String.valueOf(driver.findElement(By.className("userInfo")));
        Assert.assertEquals(actualFullNameMain, expectedFullName);
        driver.findElement(By.id("rafael")).click();
        //Verify that you are logged out by verifying the URL is:
        String expectedUrl2 = "http://duotify.us-east-2.elasticbeanstalk.com/register.php";
        String actualUrl2 = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl2, expectedUrl2);
        //Login using the same username and password when you signed up.
        driver.findElement(By.id("loginUsername")).click();
        driver.findElement(By.id("loginUsername")).sendKeys(userName);
        driver.findElement(By.id("loginPassword")).click();
        driver.findElement(By.id("loginPassword")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
        //Verify successful login by verifying that the home page contains the text "You Might Also Like".
        String expectedText = "You Might Also Like";
        String actualText = String.valueOf(driver.findElement(By.className("pageHeadingBig")));
        Assert.assertEquals(actualText, expectedText);
        //Log out once again and verify that you are logged out.
        driver.findElement(By.id("nameFirstAndLast")).click();
        driver.findElement(By.id("rafael")).click();
        String actualUrl3 = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl3, expectedUrl2);
    }

    public static String generateUserName(){
        String userName;
        for(int i =0; i<5; i++){
            userName += (char)(97+(int)(Math.random()*26));
        } return userName;
    }

    public static String generateFirstName() {
        String firstName;
        for (int i = 0; i < 6; i++) {
            firstName += (char) (97 + (int) (Math.random() * 26));
        }
        return firstName;
    }

    public static String generateLastName(){
        String lastName;
        for (int i = 0; i < 7; i++) {
            lastName += (char) (97 + (int) (Math.random() * 26));
        }
        return lastName;
    }

    public static String generateEmail(){
        String email;
        for (int i = 0; i < 5; i++) {
            email += (char) (97 + (int) (Math.random() * 26));
        }
        return email+"@gmail.com";
    }
    public static String generatePassword(){
        String password;
        for (int i = 0; i < 8; i++) {
            password += (char) (97 + (int) (Math.random() * 26));
        }
        return password;
    }
}
