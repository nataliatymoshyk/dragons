package com.dragons.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Created by natalia on 8/22/18.
 */
public class MovieHomePage {

    public static MovieHomePage open() {return Selenide.open("To_Kill_a_Dragon", MovieHomePage.class);}
    public static MovieHomePage page() {return Selenide.page(MovieHomePage.class);}

    @FindBy(xpath = "//span[@id='Cast']/following::ul[1]/li")
    private ElementsCollection castingList;

    ElementsCollection visitedPages;

    public void assertCastingInMovie(){
        for (int i = 1; i <= castingList.size();i++){
            SelenideElement element = $x(String.format("//span[@id='Cast']/following::ul[1]/li[%s]",i));
            System.out.println("Opening the personal page of :"+ element.toString());
            ActorPage page = getActorPersonalPage(element);
            System.out.println("Checking if actor played in movie");
            Assert.assertEquals(page.isKillDragonActor(),true);
            System.out.println("Back to movie homep page to continue check");
            open();
        }

        System.out.println("All actors verified");

    }

    public ActorPage getActorPersonalPage(SelenideElement element){
        SelenideElement link =  $(element).find("a");
        link.click();
        return ActorPage.page();
    }
}
