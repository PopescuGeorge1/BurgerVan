package com.example.burgervan;

public class FoodBase {
    //Sub-Menus
    private final String [] burgers_menu_names = {"Normal burger", "Healthy burger", "Deluxe burger"};
    private final int [] burgers_menu_img = {R.drawable.hamburger_simple, R.drawable.hamburger_healthy, R.drawable.hamburger_premium};
    private final double []burgers_menu_price = {1.5, 2.5, 4};
    private final String [] menus_menu_names = {"DoubleTrouble", "Happy Belly", "King"};
    private final int [] menus_menu_img = {R.drawable.doubletrouble_menu, R.drawable.happybelly_menu, R.drawable.king_menu};
    private final double []menus_menu_price = {4, 5.5, 8};
    private final String [] drinks_menu_names = {"Coca-Cola", "7Up", "Water"};
    private final int [] drinks_menu_img = {R.drawable.drink_menu_cola, R.drawable.drink_menu_7up, R.drawable.drink_menu_water};
    private final double []drinks_menu_price = {0.75, 0.75, 1.25};

    //Menus
    private final String [] menuNames = new String[]{"Burger", "Menus", "Drinks"};
    private final int [] imgMenuRes = {R.drawable.burgers_menu_icon, R.drawable.menus_menu_icon, R.drawable.drinks_menu_icon};

    //Extras
    private final String [] extraItemNames = {"Garlic Sauce", "Tomato sauce", "Barbeque sauce", "French Fries", "Mustard", "Tzatziki"};
    private final double [] extraItemPrices = {0.5, 0.5, 0.75, 1.25, 0.5, 0.75};
    private final int [] extraImgRes = {R.drawable.garlic_sauce, R.drawable.tomato_sauce, R.drawable.barbeque_sauce, R.drawable.french_fries, R.drawable.mustard_sauce, R.drawable.tzatziki_sauce};

    public double[] getExtraItemPrices() {return extraItemPrices;}

    public String[] getExtraItemNames() {
        return extraItemNames;
    }

    public int[] getExtraImgRes() {
        return extraImgRes;
    }

    public int[] getImgMenuRes() {
        return imgMenuRes;
    }

    public String[] getMenuNames() {
        return menuNames;
    }

    public String[] getBurgers_menu_names() {
        return burgers_menu_names;
    }

    public int[] getBurgers_menu_img() {
        return burgers_menu_img;
    }

    public double[] getBurgers_menu_price() {
        return burgers_menu_price;
    }

    public String[] getMenus_menu_names() {
        return menus_menu_names;
    }

    public int[] getMenus_menu_img() {
        return menus_menu_img;
    }

    public double[] getMenus_menu_price() {
        return menus_menu_price;
    }

    public String[] getDrinks_menu_names() {
        return drinks_menu_names;
    }

    public int[] getDrinks_menu_img() {
        return drinks_menu_img;
    }

    public double[] getDrinks_menu_price() {
        return drinks_menu_price;
    }
}
