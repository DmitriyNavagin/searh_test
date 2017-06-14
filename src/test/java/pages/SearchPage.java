package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


import java.util.List;


@DefaultUrl("http://google.com/ncr")
public class SearchPage extends PageObject {

    @FindBy(id = "lst-ib")
    public WebElementFacade searchField;




    public List<WebElement> links(WebDriver driver){
        List<WebElement> listLinks = driver.findElements(By.xpath(".//div[contains(@class,'srg')]//h3[contains(@class,'r')]//a"));
        return listLinks;
    }


    @FindBy(xpath = "//*[@id=\"hdtb-msb-vis\"]//a[contains(text(), 'Images')]")
    public WebElementFacade imagesIcon;


    public List<WebElement> imageLinks(WebDriver driver){
        List<WebElement> listImageLinks = driver.findElements(By.xpath(".//div[contains(@id,'isr')]//div[contains(@class,'rg')]//a"));
        return listImageLinks;
    }


    @FindBy(xpath = "//*[@id=\"hdtb-msb-vis\"]//a[contains(text(), 'All')]")
    public WebElementFacade allIcon;





}
