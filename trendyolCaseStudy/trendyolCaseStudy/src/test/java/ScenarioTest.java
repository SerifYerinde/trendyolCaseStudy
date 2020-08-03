import org.apache.log4j.MDC;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners ({Listener.class})
public class ScenarioTest extends BaseTest {
    public String baseUrl="http://www.trendyol.com";

    @Test
    public void scenarioTestCase() throws InterruptedException {


            driver.get(baseUrl);
            log.info("Trendyol anasayfasına giriş yapıldı");
            homePagesFunctions homePagesFunctions=new homePagesFunctions(driver);
            menuPagesFunctions menuPagesFunctions=new menuPagesFunctions(driver);
            butiquePagesFunctions butiquePagesFunctions=new butiquePagesFunctions(driver);
            productPagesFunctions productPagesFunctions=new productPagesFunctions(driver);

            homePagesFunctions.popUp();
            homePagesFunctions.userNavigationMenu();
            menuPagesFunctions.menusImgLoad();
            homePagesFunctions.randomMenuSelect();
            menuPagesFunctions.randombutiqueSelect();
            butiquePagesFunctions.butiqueImgLoad();
            butiquePagesFunctions.productSelect();
            productPagesFunctions.productAddToBasket();




    }
}
