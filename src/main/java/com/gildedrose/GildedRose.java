package com.gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItem(items[i]);
        }
    }

    private void updateItem(Item item) {
        if (item.name.equals("Aged Brie")) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
            item.sellIn = item.sellIn - 1;
            if (item.sellIn < 0) {
                // Aged Brie
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
            return;
        }

        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            // Normal or Sulfuras
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    // Normal
                    item.quality = item.quality - 1;
                }
            }
        } else {
            // Aged Brie or Backstage passes
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    // Backstage passes
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            // Normal or Aged Brie or Backstage passes
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                // Normal or Sulfuras or Backstage passes
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    // Normal or Sulfuras
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            // Normal
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    // Backstage passes
                    item.quality = item.quality - item.quality;
                }
            } else {
                // Aged Brie
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }
}