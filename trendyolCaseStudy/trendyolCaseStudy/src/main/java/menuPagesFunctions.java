import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class menuPagesFunctions extends BasePage {
    public menuPagesFunctions(WebDriver driver) {
        super(driver);
    }
    private int i=0;
    private By activeMenuText=By.xpath("//li[@class='tab-link active']");
    private By menuErrorImgLoad=By.cssSelector("[src='https://cdn.dsmcdn.com//web/production/large_boutique_placeholder.png']");
    private By menuBody=By.xpath("/html/body");
    private String menuName;
    private By butiqueName=By.cssSelector(".breadcrumb > li:nth-child(3)");

    public void menusImgLoad() throws InterruptedException {
/* --Menu img leri yüklendimi kontrolu
*  1. Sayfanın sonuna kadar inerek sayfasının yüklenmesi bekleniyor
*  2. Try-catch hata olsa bile fail vermemesi için kullanılmıştır
*  3. errorImgLoad elementi ise sayfadaki resimlerin img src alanına "undefined" yazılarak(yüklenmeme durumu için) çıkan sonuç ile beslenmektedir.
*  4. İşlem bittikten sonra sıradaki methodda tıklanmış işlemi görebilmek için sayfa başına gidilir ve kısa süre beklemektedir.
*/
        for(i=1; i<10; i++) {
            element(menuBody).sendKeys(Keys.HOME);
            Thread.sleep(50);
            By menuClick=By.xpath("//div[@id='navigation-wrapper']/nav/ul/li["+i+"]/a");
            element(menuClick).sendKeys(Keys.ENTER);
            menuName=element(activeMenuText).getText();
            log.info("Bulunduğunuz menü -->"+menuName);

            element(menuBody).sendKeys(Keys.END);
            Thread.sleep(150);
            try{
                element(menuErrorImgLoad).isDisplayed();
                log.info(menuName+" menüsünde yüklenmeyen resim bulunmaktadır.");

            }catch (Exception e){

            }
        }element(menuBody).sendKeys(Keys.HOME);
        Thread.sleep(50);


    }



    public void randombutiqueSelect() throws InterruptedException {
/*Butik elementi her butik sayfası için list olarak değişik sayıda girdiye sahiptir. Bu yüzden 1-9 dahil random sayı üretilmiştir.
Bu random sayılar ile butik elementine tıklanarak butik sayfasına gidilir. Aktif sayfanın ismi loglanır
*/
        Random r=new Random();
        i=r.nextInt(9)+1;
        element(menuBody).sendKeys(Keys.END);
        Thread.sleep(100);
        By butiqueSelect=By.cssSelector(".component-item:nth-child("+i+") img");
        clicks(butiqueSelect);
        element(menuBody).sendKeys(Keys.HOME);
        Thread.sleep(50);
        try {
            log.info("Bulunduğunuz butik -->"+element(butiqueName).getText());
        }catch (Exception e){}

    }

}
