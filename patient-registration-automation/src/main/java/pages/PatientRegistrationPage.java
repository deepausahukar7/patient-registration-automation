package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class PatientRegistrationPage {

    WebDriver driver;

    public PatientRegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="name")
    WebElement name;

    @FindBy(id="age")
    WebElement age;

    @FindBy(id="mobile")
    WebElement mobile;

    @FindBy(id="register")
    WebElement registerBtn;

    @FindBy(id="message")
    WebElement message;

    public void registerPatient(String n, String a, String m){

        name.clear();
        age.clear();
        mobile.clear();

        if (!n.isEmpty()) name.sendKeys(n);
        if (!a.isEmpty()) age.sendKeys(a);
        if (!m.isEmpty()) mobile.sendKeys(m);

        registerBtn.click();
    }



    public String getMessage(){
        return message.getText();
    }
}
