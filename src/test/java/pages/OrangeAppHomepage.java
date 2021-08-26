package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrangeAppHomepage {
    public OrangeAppHomepage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="txtUsername")
    public WebElement userName;
    @FindBy(id="txtPassword")
    public  WebElement password;
    @FindBy(id="btnLogin")
    public WebElement loginbutton;

}
