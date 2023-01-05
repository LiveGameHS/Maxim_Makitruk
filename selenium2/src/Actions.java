import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Actions {
    //Усі глобальні змінні 
    private final String RandomName = "MGKely";
    private final Duration load_time_in_seconds = Duration.ofSeconds(5);
    private final String username_for_login = "Admin";
    private final String password_for_login = "admin123";
    private final WebDriver driver = new ChromeDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, 5) ;
    private final String minimum_salary = "123";
    private final String maximum_salary = "321";

    






    //Для кращого розуміння, я розбив кожний пункт завдання на окремий метод, виконуватись вони будть підряд.

    public void LoginToMainPage() { //Перший етап, захождження на сайт.
    driver.manage().window().maximize();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]"))).sendKeys(username_for_login);
    driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password_for_login);
    driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }

    public void Add_New_Record(){ //Викорнуємо перший пункт завдання, а саме переходимо до сторінки додавання нового рекорду та зберігаємо зміни.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=\"Admin\"]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),\"Job\")]"))).click();
        driver.findElement(By.xpath("//a[contains(text(),\"Pay Grades\")]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,\"Add\")]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"oxd-input oxd-input--active\" and not(@placeholder)]"))).sendKeys(RandomName);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    } //Кінець першого пункту

    public void Add_New_Currency(){ //Додаємо куренси та покидаємо цю сторінку.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(., \"Add\")]"))).click();
        WebElement element_in_list_of_currencyes = driver.findElement(By.xpath("//div[@class=\"oxd-select-text-input\"]"));
        element_in_list_of_currencyes.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),\"EUR - Euro\")]"))).click();

        List<WebElement> salary_fields = driver.findElements(By.xpath("//input[@class=\"oxd-input oxd-input--active\"]"));
        salary_fields.get(2).sendKeys(minimum_salary);
        salary_fields.get(3).sendKeys(maximum_salary);

        driver.findElements(By.xpath("//button[contains(.,\"Save\")]")).get(1).click();
        driver.findElement(By.xpath("//button[contains(.,\"Cancel\")]")).click();
    }
       //Перевірка чи з'явився запис.
    public Boolean check_if_changes_are_visible(){
        try {
            new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//div[contains(.,\"%s\")]", RandomName))));
        } catch (TimeoutException exeption) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    } 
        //Видалення створеного у тесті запису.
        public void removeRow() {
            String path_to_created_field = "//div[@class=\"oxd-table-row oxd-table-row--with-border\" and " +
            String.format("./div/div[contains(text(), \"%s\")]]//i[@class=\"oxd-icon bi-trash\"]", RandomName);
    
            driver.findElement(By.xpath(path_to_created_field)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(., \"Yes, Delete\")]"))).click();
            driver.close();
        }


    }

