import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class WebTableTest {

    WebDriver driver;
    public int initialTableSize = 0;
    String firstName= "Firicel";
    String lastName= "Celentano";
    String email= "test@gmail.com";
    String age= "25";
    String salary= "100000";
    String department= "Testing";

    @Test
    public void webTableTest(){
        openBrowser();
        chooseElemensMenu();
        chooseElemensSubMenWebTables();
        getTableSize();
        clickToAddNewRecord();
        fillFormValues();
        WebDriver driver;
    }
    //facem o metoda ce deschide un browser
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/"); //deschide pagina "https://demoqa.com/"
        driver.manage().window().maximize(); //  maximizeaza fereastra
    }
    //facem, un meniu care alege meniul Elements
    public void chooseElemensMenu() {
        WebElement FromMeniu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        //actionam butonul de mai sus
        FromMeniu.click();
    }
    //facem, un meniu care alege meniul web Tables
    public void chooseElemensSubMenWebTables(){
        //identificam sub-meniul dorit si facem click pe el
        WebElement PracticeFormSubMenu = driver.findElement(By.xpath("//*[@id=\"item-3\"]/span"));
        PracticeFormSubMenu.click();
    }
    //facem o metoda care sa ia numarul de runduri initial, din tabel
    public int getTableSize(){
        List<WebElement>tableRowList= driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        initialTableSize = tableRowList.size();
        System.out.println("Numarul initial de randuri este" + initialTableSize);
        return initialTableSize;
    }
    public void clickToAddNewRecord(){
        WebElement addNewRecordBtn = driver.findElement(By.id("addNewRecordButton"));
        addNewRecordBtn.click();
    }

    public void fillFormValues(){
        WebElement firstNameField= driver.findElement(By.id("firstName"));
        firstNameField.sendKeys("Firicel");
        WebElement lastNameField= driver.findElement(By.id("lastName"));
        lastNameField.sendKeys("Celentano");
        WebElement emailAddressField= driver.findElement(By.id("userEmail"));
        emailAddressField.sendKeys("test@gmail.com");
        WebElement ageField= driver.findElement(By.id("age"));
        ageField.sendKeys("25");
        WebElement salaryField= driver.findElement(By.id("salary"));
        salaryField.sendKeys("1000000");
        WebElement departmentField= driver.findElement(By.id("department"));
        departmentField.sendKeys("Testing");
        WebElement submitButtonField= driver.findElement(By.id("submit"));
        submitButtonField.click();
    }
    //facem o metoda care sa valideze ca am adaugat o intrare noua in tabel si sa verifice valorile pe care le-am dat;
    public void validateThatNewRecordsAreAddedProperly() {
        List<WebElement> tableRowList = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertTrue(tableRowList.size() > initialTableSize, "There are no new entries in the table!, initial table size: " +
                initialTableSize + " is the same with actual table size: " + tableRowList.size());
        String actualTableValues = tableRowList.get(tableRowList.size()-1).getText();
        System.out.println("New record values are: " + actualTableValues);
        Assert.assertTrue(actualTableValues.contains(firstName),"First name value is not correct. Expected first Name: " + firstName);
        Assert.assertTrue(actualTableValues.contains(lastName),"Last name value is not correct. Expected last Name: " + lastName);
        Assert.assertTrue(actualTableValues.contains(email),"Email value is not correct. Expected email: " + email);
        Assert.assertTrue(actualTableValues.contains(age),"Age value is not correct. Expected age: " + age);
        Assert.assertTrue(actualTableValues.contains(salary),"Salary value is not correct. Expected salary: " + salary);
        Assert.assertTrue(actualTableValues.contains(department),"Department value is not correct. Expected department: " + department);
    }
}
