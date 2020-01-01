package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void update() {
        if (!name.equals("Aged Brie")
                && !name.equals("Backstage passes to a TAFKAL80ETC concert")
                && name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            quality = quality - 1;
            sellIn = sellIn - 1;
            if (sellIn < 0) {
                if (quality > 0) {
                    quality = quality - 1;
                }
            }
            return;
        }

        if (!name.equals("Aged Brie")
                && !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            // Normal or Sulfuras
            if (quality > 0) {
                if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                    // Normal
                    quality = quality - 1;
                }
            }
        } else {
            // Aged Brie or Backstage passes
            if (quality < 50) {
                quality = quality + 1;

                if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    // Backstage passes
                    if (sellIn < 11) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }

                    if (sellIn < 6) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }
                }
            }
        }

        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
            // Normal or Aged Brie or Backstage passes
            sellIn = sellIn - 1;
        }

        if (sellIn < 0) {
            if (!name.equals("Aged Brie")) {
                // Normal or Sulfuras or Backstage passes
                if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    // Normal or Sulfuras
                    if (quality > 0) {
                        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                            // Normal
                            quality = quality - 1;
                        }
                    }
                } else {
                    // Backstage passes
                    quality = quality - quality;
                }
            } else {
                // Aged Brie
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }
    }
}
