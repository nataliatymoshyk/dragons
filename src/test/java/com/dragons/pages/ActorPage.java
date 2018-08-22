package com.dragons.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import sun.jvm.hotspot.utilities.Assert;


/**
 * Created by natalia on 8/22/18.
 */
public class ActorPage {
    public static ActorPage page() {return Selenide.page(ActorPage.class);}


    @FindBy(xpath = "//span[@id ='Selected_filmography']/following::ul[1]")
    private ElementsCollection selectedFilmographyList;

    @FindBy(xpath = "//span[@id ='Filmography']/following::ul[1]")
    private ElementsCollection filmographyList;

    @FindBy(xpath = "//table/tbody/tr/TH[contains(text(),'Film')]/following::tr")
    private ElementsCollection tableFilmographyList;

    ElementsCollection moviesList;


    public boolean isKillDragonActor(){

            moviesList = getFilmographyType();

            for (SelenideElement element : moviesList) {
                if (element.getText().contains("To Kill a Dragon")) {
                    return true;
                }
            }
        return false;
    }

    public ElementsCollection getFilmographyType() {

        if (selectedFilmographyList.size() != 0) { //check if selected filmography is present on page, if yes, use it
            return selectedFilmographyList;
        }

        if (filmographyList.size() != 0) {  // check if filmography is present on page,
            if (tableFilmographyList.size()!=0){ //check if it has built in table with movies
                return tableFilmographyList; //if yes, return table
            }
            return filmographyList; // if no return list
        }

        return null;
    }


}
