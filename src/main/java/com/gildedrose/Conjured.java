package com.gildedrose;

public class Conjured extends Item {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        int temp = quality - 2;
        quality = temp >= 0 ? temp : 0;
        sellIn = sellIn - 1;
        if (sellIn < 0) {
            temp = quality - 2;
            quality = temp >= 0 ? temp : 0;
        }
    }
}
