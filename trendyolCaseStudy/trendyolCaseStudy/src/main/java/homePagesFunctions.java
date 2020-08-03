import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Random;

public class homePagesFunctions extends BasePage{
    public homePagesFunctions(WebDriver driver) {
        super(driver);
    }
    private By activeRandomMenuText=By.xpath("//li[@class='tab-link active']");
    private By homePopUp=By.xpath("//div[@class='homepage-popup']");
    private By popUpCloseButton=By.xpath("//a[@title='Close']");
    private By logInText=By.xpath("//span[contains(text(),'Giriş Yap')]");
    private By logInControl=By.xpath("//span[contains(text(),'Hesabım')]");
    private By userName=By.xpath("//input[@class='authentication-input email']");
    private By password=By.xpath("//input[@class='authentication-input password']");
    private By logInPopUpButton=By.xpath("//div[@class='submit-button-container']");
    private int i=0;

    public  void  popUp(){
//sayfa açıldığında chrome da pop-up gelirken edge de gelmemektedir. Burada pop-up geldiğinde kapatma fonksiyonu kullanılmıştır
        try{
            element(homePopUp).isDisplayed();
            clicks(popUpCloseButton);
            System.out.println("pop-up kapatıldı");

        }catch (Exception e){}
    }

    public  void userNavigationMenu(){
/*Kullanıcı oturumu açık değilse eğer "Giriş yap" butonuna tıklanarak kullanıcı giriş bilgilerin açıldığı pop-up fonksiyonu gelmektedir.
Pop-up geldiğinde ise giriş bilgilerinin girileceği logInPopUp() fonksiyonu çağırılmaktadır
Kullanıcı oturumu açıksa eğer herhangi bir tıklama yapılmayacaktır
*/
        try {
            clicks(logInText);
            log.info("Oturum açmaya yönlendiriliyor");
            logInPopUp();
        }catch (Exception e){
            log.info("Kullanıcı oturumu önceden açılmış");
        }

    }


    public void logInPopUp() throws InterruptedException {
//Kullanıcı girişi için gerekli bilgiler girilmektedir. Giriş yapılırken işlem uzun sürebileceği için sonraki methoda geçmeden bekleme konulmuştur
        clicks(userName);
        sendKeys(userName, "syerinde34@gmail.com");
        sendKeys(password, "Sey03428");
        clicks(logInPopUpButton);

        try {
            element(logInControl).isDisplayed();
            log.info("Kullanıcı oturumu açılmıştır");

        }catch (Exception e){
            log.error("Oturum açma işlemi başarısız");
        }Thread.sleep(300);

    }
    public void randomMenuSelect() {
/*Menu elementi list olarak 9 girdiye sahiptir. Bu yüzden 1-9 dahil random sayı üretilmiştir.
Bu random sayılar ile menü elementine tıklanarak menü sayfasına gidilir. Aktif sayfanın ismi loglanır
*/
        Random r=new Random();
        i=r.nextInt(9)+1;
        By randomMenuClick=By.xpath("//div[@id='navigation-wrapper']/nav/ul/li["+i+"]/a");
        element(randomMenuClick).sendKeys(Keys.ENTER);
        log.info("Random olarak bulunduğunuz menü -->"+element(activeRandomMenuText).getText());
    }

}
