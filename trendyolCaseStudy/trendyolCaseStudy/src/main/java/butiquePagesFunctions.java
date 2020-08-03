import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class butiquePagesFunctions extends BasePage{
    public butiquePagesFunctions(WebDriver driver) {
        super(driver);
    }

     private By butiqueErrorImgLoad=By.cssSelector("[src='/Content/images/defaultThumb.jpg']");
    private By butiqueBody=By.xpath("/html/body");
    private By productImgClick=By.xpath("//div/img");


    public void butiqueImgLoad() throws InterruptedException {
/* ---Butik içerisindeki ürünlerin img leri yüklendimi kontrolu
*  1. Sayfanın sonuna kadar inerek butik sayfasının yüklenmesi bekleniyor
*  2. Try-catch hata olsa bile fail vermemesi için kullanılmıştır
*  3. errorImgLoad elementi ise sayfadaki resimlerin img src alanına "undefined" yazılarak(yüklenmeme durumu için) çıkan sonuç ile beslenmektedir.
*  4. İşlem bittikten sonra sıradaki methodda tıklanmış işlemi görebilmek için sayfa başına gidilir ve kısa süre beklemektedir.
*/
        element(butiqueBody).sendKeys(Keys.END);
        Thread.sleep(150);
        try{
            element(butiqueErrorImgLoad).isDisplayed();
            log.info("sayfada yüklenemeyen resim bulunmaktadır");
        }catch (Exception e){ }
        element(butiqueBody).sendKeys(Keys.HOME);
        Thread.sleep(50);
    }
    public void productSelect() throws InterruptedException {
//Butik sayfasındaki ilk ürüne gitmek için kullanılmıştır. Bazı butiklerde tek ürün olduğu gözlemlendiği için ilk ürüne gidecek şekilde beslenmektedir.
        clicks(productImgClick);
        Thread.sleep(50);
    }
}


