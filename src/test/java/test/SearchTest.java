package test;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;
import steps.SearchPageSteps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;


@RunWith(SerenityRunner.class)
public class SearchTest extends PageObject{

    @Managed(driver = "chrome")



    public WebDriver driver;

    @Steps
    SearchPageSteps searchPageSteps;

    @Before
    public void before(){
        searchPageSteps.openSearchPage();
        driver.manage().window().maximize();
        setImplicitTimeout(120, TimeUnit.SECONDS);
    }


    @Title("Поиск по слову Selenium")
    @Features("Поиск")
    @Stories("Поиск по слову ")
    @TestCaseId("1")
    @Test
    public void searchTest(){
        String firstTimeLink;
        String secondtTimeLink;
        searchPageSteps.typeSearchWord("selenium");
        firstTimeLink = searchPageSteps.firstLinkCheck(driver);
        searchPageSteps.chechImagePage(driver);
        secondtTimeLink = searchPageSteps.firstLinkCheck(driver);
        assertEquals(secondtTimeLink,firstTimeLink);









    }

}
