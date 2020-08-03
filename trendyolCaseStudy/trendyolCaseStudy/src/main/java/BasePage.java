import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


public class BasePage {
    protected WebDriver driver;//web driver tanımlandı
    public Logger log= LogManager.getLogger(getClass().getName());
    public BasePage(WebDriver driver) {
        //Function classlarındaki loglama için properties dosyasının yolu gösterilmiştir.
        PropertyConfigurator.configure("C:\\Users\\SerifYerinde\\IdeaProjects\\trendyolCaseStudy\\trendyolCaseStudy\\src\\test\\java\\resources\\log4j.properties");
        //Testten gelen web driver için null dönmemesi gerektiğinden ve program ilk yüklendiğinde driver hazır olması için (constructor) tanımlandı.
        this.driver = driver;
        }

    public WebElement element(By Locator){
        //Web element için global değişken tanımlandı. Parametre olarak verdiğimiz locatorı bulup o web elementi bize dönecektir
        return driver.findElement(Locator);


    }
    public void sendKeys(By Locator, String value){
        //Element içine yazı yazma için global değişken tanımlandı
        element(Locator).sendKeys(value);
    }

    public void clicks(By Locator){
        //Elementlere tıklama için global değişken tanımlandı
        element(Locator).click();
    }




}
