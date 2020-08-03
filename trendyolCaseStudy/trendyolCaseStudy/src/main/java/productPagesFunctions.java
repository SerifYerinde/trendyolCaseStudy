import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class productPagesFunctions extends BasePage {
    public productPagesFunctions(WebDriver driver) {
        super(driver);
    }

    private By productSizeComboboxClick=By.xpath("//div[@class='pr-in-sz-pk']");
    private By productSizeClick = By.cssSelector(".vrn-item:nth-child(1)");
    private By addToBasketButton = By.xpath("//div[@class='add-to-bs-tx']");
    private By productName=By.xpath("//span[@class='pr-nm']");
    public void productAddToBasket() throws InterruptedException {
/*---Sepete ekleme durumu
Ürün ismi loglanmaktadır
Beden seçimi comboboxı mevcutsa ilk seçimi seçip sepete ekle demesi beklenmektedir.(Bazılarında tek beden olduğu için ilki tercih edilmiştir.)
Beden seçim comboboxı yoksa eğer direkt sepete ekle butonuna tıklanacaktır
 */
        Thread.sleep(150);
        log.info("Detayına gittiğiniz ürün -->"+element(productName).getText());
        try {
            element(productSizeClick).isDisplayed();
            clicks(productSizeComboboxClick);
            clicks(productSizeClick);
            Thread.sleep(150);
            clicks(addToBasketButton);


        } catch (Exception e) {
            clicks(addToBasketButton);
        }
    }
}
