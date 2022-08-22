package com.example.burgervan;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    //options to test:
    /*
    ?main_menu TOTAL doesn't display negative values(how would that happen)?
    main_menu item_quantity doesn't go below "1" (when item_quantity reaches 0, a pop-up will appear asking if item will be deleted)
    main_menu there can't be 2 same items on the list( when an existing item is selected, it will add to the item_quantity) (TO BE IMPLEMENTED)
    main_menu clicking an item from the shopping list (on the right) will take you to the description of the item (TO BE IMPLEMENTED)

    sub_menu title will always correspond to the selected menu name

    item_window will always correspond with the selected item from the sub_menu
    item_window back button will open the sub-menu from which the item is part of

     */
}