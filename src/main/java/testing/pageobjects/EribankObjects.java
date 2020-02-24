package testing.pageobjects;

import org.openqa.selenium.By;

public class EribankObjects {

    public static By Username() {return By.id("usernameTextField");}
    public static By username(String term) {return By.id("usernameTextField");}
    public static By Password() {return By.id("passwordTextField");}
    public static By password(String term) {return By.id("passwordTextField");}
    public static By Login() {return By.id("loginButton");}
    public static By MakePaymentBtn() {return By.id("makePaymentButton");}
    public static By Phone() {return By.id("phoneTextField");}
    public static By Name() {return By.id("nameTextField");}
    public static By Amount() {return By.id("amountTextField");}
    public static By Country() {return By.id("countryTextField");}
    public static By SendPayment() {return By.id("sendPaymentButton");}
    public static By EribankMsgYes() {return By.xpath("//*[@resource-id='android:id/button1']");}
    public static By LogoutBtn() {return By.id("logoutButton");}
    public static By EriMsgBox() {return By.xpath("//*[@resource-id='android:id/button1']");}
}