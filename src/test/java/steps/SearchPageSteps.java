package steps;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SearchPage;

import java.util.List;

import static junit.framework.Assert.assertEquals;


public class SearchPageSteps extends PageObject {

    SearchPage searchPage;

    @Step("Открытие страницы поиска")
    public void openSearchPage() {
        searchPage.open();
    }


    @Step("Ввод данных в поле поиска")
    public void typeSearchWord (String searchWord) {
        searchPage.searchField.clear();
        searchPage.searchField.typeAndEnter(searchWord);

    }

    @Step("Получение первой ссылки и проверка что она связана с сайтом Selenium")
    public String firstLinkCheck (WebDriver driver) {
        String firstLink;

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("selenium");
            }
        });

        List<WebElement> links = searchPage.links(driver);

        firstLink = links.get(0).getAttribute("href");
        assertEquals(true,firstLink.contains("http://www.seleniumhq.org/"));
        System.out.println("Первая ссылка в поиске - " + firstLink + ",содержит текст http://www.seleniumhq.org/");

        return firstLink;

    }

    @Step("Переход на страницу Image, проверка что первая картинка связана с сайтом Selenium и возврат назад")
    public void chechImagePage(WebDriver driver){

        String firstImageLink;

        searchPage.imagesIcon.waitUntilEnabled().click();
        List<WebElement> imageLinks = searchPage.imageLinks(driver);
        firstImageLink = imageLinks.get(0).getAttribute("href");
        assertEquals(true,firstImageLink.contains("www.seleniumhq.org"));
        System.out.println("Первая ссылка в поиске по картинкам - " + firstImageLink + ",содержит ссылку на сайт www.seleniumhq.org");
        System.out.println(firstImageLink);
        searchPage.allIcon.waitUntilEnabled().click();




    }


}
