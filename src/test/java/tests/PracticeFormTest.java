package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;


public class PracticeFormTest extends BaseTests{

    @Test
    public void practiceFormTest() {
//        driver = new ChromeDriver();
//        driver.get("https://demoqa.com/"); //deschide pagina "https://demoqa.com/"
//        driver.manage().window().maximize(); //  maximizeaza fereastra
        //identificam meniul dorit si facem click pe el
        WebElement FromMeniu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        //actionam butonul de mai sus
        FromMeniu.click();
        //identificam sub-meniul dorit si facem click pe el
        WebElement PracticeFormSubMenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        PracticeFormSubMenu.click();
        //identificam elementewle din formular si facem actiuni pe fiecare
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameText = "Eugen";
        firstNameField.sendKeys(firstNameText);
        // completam field-ul de last name
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameText = "Emacu";
        lastNameField.sendKeys(lastNameText);
        // completam field-ul de email
        WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailText = "eugen.emacu@gmail.com";
        emailField.sendKeys(emailText);
        // selectam gender
        WebElement genderMale = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement genderFemale = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement genderOther = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        String genderValueText = "Male";
        List<WebElement> genderList = List.of(genderMale, genderFemale, genderOther); // o alta metoda de a declara o lista
        for (int i = 0; i < genderList.size(); i++) {
            if (genderList.get(i).getText().equals(genderValueText)) {
                genderList.get(i).click();
                break;
            }
        }

        // completam field-ul de mobile phone
        WebElement mobilePhoneField = driver.findElement(By.id("userNumber"));
        String mobilePhoneText = "0761974803";
        mobilePhoneField.sendKeys(mobilePhoneText);

        // completam field-ul de date of birth
        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInput.click();
        WebElement monthOfBirthElement = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        Select selectMonth = new Select(monthOfBirthElement);
        String monthValueText = "October";
        selectMonth.selectByVisibleText(monthValueText);
        WebElement yearOfBirthElement = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        Select selectYear = new Select(yearOfBirthElement);
        String yearValueText = "1984";
        selectYear.selectByVisibleText(yearValueText);
        List<WebElement> dayOfBirthList = driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day')]"));
        String dayValueText = "27";
        for (int i = 0; i < dayOfBirthList.size(); i++) {
            if (dayOfBirthList.get(i).getText().equals(dayValueText)) {
                dayOfBirthList.get(i).click();
                break;
            }
        }
        // completam subject
        WebElement subjectInputElement = driver.findElement(By.id("subjectsInput"));
        String mathsSubjectText = "Maths";
        subjectInputElement.sendKeys(mathsSubjectText);
        subjectInputElement.sendKeys(Keys.ENTER);
        String physicsSubjectText = "Physics";
        subjectInputElement.sendKeys(physicsSubjectText);
        subjectInputElement.sendKeys(Keys.ENTER);
        // selectam check box-urile de hobbies
        WebElement sportHobbyElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        WebElement readingHobbyElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
        WebElement musicHobbyElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));
        List<WebElement> hobbiesList = List.of(sportHobbyElement, musicHobbyElement, readingHobbyElement);
        String sportHobbysText = "Sports";
        String readingHobbysText = "Reading";
        String musicHobbysText = "Music";
        List<String> hobbyValueTextList = List.of(sportHobbysText, musicHobbysText, readingHobbysText);
        for (String hobby : hobbyValueTextList) {
            for (int i = 0; i < hobbiesList.size(); i++) {
                if (hobbiesList.get(i).getText().equals(hobby)) {
                    hobbiesList.get(i).click();
                    break;
                }
            }
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        WebElement uploadFileElement = driver.findElement(By.id("uploadPicture"));
        String pictureFileTest = "TestImage.png";
        String pictureFilePath = "src/test/resources/pictures/" + pictureFileTest;
        File file = new File(pictureFilePath);
        uploadFileElement.sendKeys(file.getAbsolutePath());
        WebElement addressField = driver.findElement(By.id("currentAddress"));
        String adressValueText = "Adresa Testare 1";
        addressField.sendKeys(adressValueText);
        //      Aleg tara - statul din lista disponibila prin tastarea textului "NCR" si apoi apas tasta Enter
        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValueText = "NCR";
        stateInputElement.sendKeys(stateValueText);
        stateInputElement.sendKeys(Keys.ENTER);
//      Aleg orasul din lista disponibila prin tastarea textului "Delhi" si apoi apas tasta Enter
        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValueText = "Delhi";
        cityInputElement.sendKeys(cityValueText);
        cityInputElement.sendKeys(Keys.ENTER);
//      Apas butonul Submit
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // facem un hash map cu expected values
        HashMap<String, String> expectedValues = new HashMap<>();
        expectedValues.put("Student Name", firstNameText + " " + lastNameText);
        expectedValues.put("Address", adressValueText);
        expectedValues.put("State and City", stateValueText + " " + cityValueText);
        expectedValues.put("Picture", pictureFileTest);
        expectedValues.put("Student Email", emailText);
        expectedValues.put("Date of Birth", dayValueText + " " + monthValueText + "," + yearValueText);
        expectedValues.put("Gender", genderValueText);
        expectedValues.put("Mobile", mobilePhoneText);
        expectedValues.put("Subjects", mathsSubjectText + ", " + physicsSubjectText);
        expectedValues.put("Hobbies", sportHobbysText + ", " + musicHobbysText + ", " + readingHobbysText);





        //declaram listele cu valorile actuale din tabel
        List<WebElement> submitTableKeys = driver.findElements(By.xpath("//tbody//td[1]"));
        List<WebElement> submitTableValues = driver.findElements(By.xpath("//tbody//td[2]"));
        HashMap<String, String> actualValues = new HashMap<>();
        for (int i = 0; i < submitTableValues.size(); i++) {
            actualValues.put(submitTableKeys.get(i).getText(), submitTableValues.get(i).getText());
        }
        //assert = validare
        Assert.assertEquals(actualValues, expectedValues, "Actual valuers: " + actualValues + "are not the same with the aspected values: " + expectedValues);
    }
}