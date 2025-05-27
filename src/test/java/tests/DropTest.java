package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropTest extends BaseTest {


    @Test
    public void DroppableTest(){
        choseMenu();
        choseSubMenu();
        pickAndDropElement();
    }

//    public void openBrowser() {
//        driver = new ChromeDriver(); // Navigam catre pagina website-ului
//        driver.get("https://demoqa.com/");
//        driver.manage().window().maximize(); // Facem fereastra maxima
//    }

    // Identificam meniul dorit si facem click pe el
    public void choseMenu() {
        WebElement interactionMenu = driver.findElement(By.xpath("//h5[text()='Interactions']"));
        scrollToElement(interactionMenu);
        interactionMenu.click(); // Actionam butonul din meniul de mai sus
    }

    // Facem o metoda care sa faca scroll
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void choseSubMenu() {
        WebElement droppableSubMenu = driver.findElement(By.xpath("//span[text()='Droppable']"));
        droppableSubMenu.click();
    }

//    public void closeBrowser(){
//        driver.quit();
//    }

    public void pickAndDropElement(){
        WebElement draggableElement = driver.findElement(By.id("draggable"));
        WebElement droppableElement = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(droppableElement));
        String initialTargetText = droppableElement.getText();
        Actions action = new Actions(driver);
        action.dragAndDrop(draggableElement, droppableElement).release().perform();//drag de la draggableElement pana la droppableElement, lasam + perform
        Assert.assertNotEquals(droppableElement.getText(), initialTargetText, "Initial text is the same with actual text after element dropped");
        System.out.println("Initial text is: " + initialTargetText + ". Text after successful drop: " + droppableElement.getText());
    }
}
