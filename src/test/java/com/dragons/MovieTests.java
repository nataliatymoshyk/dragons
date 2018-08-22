package com.dragons;

import com.dragons.pages.MovieHomePage;
import org.junit.Test;


/**
 * Created by natalia on 8/22/18.
 */
public class MovieTests extends BaseTest {

    @Test
    public void verifyActors(){
        MovieHomePage page = MovieHomePage.open();
        page.assertCastingInMovie();

    }

}

