package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.OrangeAppHomepage;
import pages.OrangeAppTimePage;
import pages.OrangeAppValidationPage;
import pages.WebOrdersOrderPage;
import utilities.ConfigReader;
import utilities.Driver;

public class OrangeHRSteps {
    WebDriver driver = Driver.getDriver();
    OrangeAppHomepage orangeAppHomepage = new OrangeAppHomepage();
    OrangeAppTimePage orangeAppTimePage = new OrangeAppTimePage();
    OrangeAppValidationPage orangeAppValidationPage = new OrangeAppValidationPage();

    @Given("user navigates to OrangeHR application")
    public void user_navigates_to_OrangeHR_application() {
        driver.get(ConfigReader.getProperty("OrangeAppURL"));
    }

    @When("user provides user name {string} and {string} and clicks on login")
    public void user_provides_user_name_and_and_clicks_on_login(String userName, String password) {
        orangeAppHomepage.userName.sendKeys(userName);
        orangeAppHomepage.password.sendKeys(password);
        orangeAppHomepage.loginbutton.click();

    }

    @And("user clicks on Time and chooses Timesheet")
    public void userClicksOnTimeAndChoosesTimesheet() {
        orangeAppTimePage.timeModule.click();
        orangeAppTimePage.timeSheetsModule.click();
        orangeAppTimePage.mySheetsModule.click();
    }

    @And("user click on Edit button, provides data and clicks to add row button")
    public void userClickOnEditButtonProvidesDataAndClicksToAddRowButton() {
        orangeAppValidationPage.editButton.click();
        orangeAppValidationPage.projectName.sendKeys("Global Corp and Co - Global Software phase - 1");
        orangeAppValidationPage.projectActivityName.sendKeys("QA Testing");
        orangeAppValidationPage.monday.sendKeys("5:00");
        orangeAppValidationPage.tuesday.sendKeys("4:00");
        orangeAppValidationPage.AddRowButton.click();

    }

    @And("user selects one sheet and removes it")
    public void userSelectsOneSheetAndRemovesIt() {
        orangeAppValidationPage.firstCheckBox.click();
        orangeAppValidationPage.removeButton.click();
    }

    @Then("user validates that selected row was deleted with success message {string}")
    public void user_validates_that_selected_row_was_deleted_with_success_message(String expectedSuccessMessage) {
        String actualSuccessMessage = orangeAppValidationPage.actualSuccessMessage.getText();
        Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage);
    }

    @And("user clicks on Edit without choosing timesheet and clicks Remove Row")
    public void userClicksOnEditWithoutDataAndClicksRemoveRow() {
        orangeAppValidationPage.editButton.click();
        orangeAppValidationPage.removeButton.click();

    }

    @Then("user validates errorMessage {string}")
    public void userValidatesErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = orangeAppValidationPage.actualErrorMessage.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @And("user clicks on Edit and selects first row without data")
    public void userClicksOnEditAndSelectsFirstRowWithoutData() {
        orangeAppValidationPage.editButton.click();
        orangeAppValidationPage.firstCheckBox.click();
        orangeAppValidationPage.removeButton.click();
    }

    @Then("Validates warning message {string}")
    public void validatesWarningMessage(String expectedMessage) {
        String actualMessage = orangeAppValidationPage.actualMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
