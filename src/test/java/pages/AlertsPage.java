package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class AlertsPage extends BasePage{
    private By pageTitle= By.xpath("//h1[@class]");
    private By firstAlertButton= By.id("alertButton");
    private By timerAlertButton= By.id("timerAlertButton");
    private By confirmAlertButton=By.id("confirmButton");
    private By alertResultText=By.id("confirmResult");
    private By confirmPromptButton=By.id("promtButton");
    private By promptResult=By.id("promptResult");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @Override

    public void isPageLoaded() {
        Assert.assertEquals(elementMethods.getTextFromElement(pageTitle),"Alerts","Page is not loaded properly");
    }

    public void interactWithFirstAlert() {
        elementMethods.clickElement(firstAlertButton);
        alertsMethods.alertOk();
//        Alert FirstAlert = driver.switchTo().alert();
//        FirstAlert.accept();
    }

    //facem o metoda care sa interactioneze cu prima alerta;
    public void interactWithTimerAlert() {
        elementMethods.clickElement(timerAlertButton);
        alertsMethods.timerAlert();
//        //Inainte sa schimbam focusul pe alerta, trebuie sa punem un wait explicit;
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert timerAlert = driver.switchTo().alert();
//        timerAlert.accept();
    }

    public void interactWithConfirmAlert(String alertValue) {
        elementMethods.clickElement(confirmAlertButton);
        alertsMethods.confirmAlert(alertValue);
        Alert confirmAlert = driver.switchTo().alert();
        Assert.assertTrue(elementMethods.getTextFromElement(alertResultText).contains(alertValue), "You didn't " +
                "select Ok. You selected: " + elementMethods.getTextFromElement(alertResultText));
//        if (alertValue.equals("OK")) {
//            confirmAlert.accept();
//            Assert.assertTrue(elementMethods.getElement(alertResultText).getText().contains(alertValue), "You didn't " +
//                    "select Ok. You selected: " + elementMethods.getElement(alertResultText).getText());
//        }
//        if (alertValue.equals("Cancel")) {
//            confirmAlert.dismiss();
//            Assert.assertTrue(elementMethods.getElement(alertResultText).getText().contains(alertValue), "You didn't "
//                    + "select Cancel. You selected: " + elementMethods.getElement(alertResultText).getText());
//        }
    }

    public void interactWithPromptBox(String alertValue){
        elementMethods.clickElement(confirmAlertButton);
        alertsMethods.promptAlert(alertValue);
//        Alert promptAlert = driver.switchTo().alert();
//        //introduce numele meu in casuta de prompt;
//        promptAlert.sendKeys(alertValue);
//        //apoi apasa pe butonul ok;
//        promptAlert.accept();
        Assert.assertTrue(elementMethods.getTextFromElement(promptResult).contains(alertValue),"You didn't enter the " +
                "right name. In that box " + elementMethods.getTextFromElement(promptResult));
    }
}