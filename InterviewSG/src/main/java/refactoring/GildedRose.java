package refactoring;

import java.util.List;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }
    public void updateQuality() {
        List<String> itemList = List.of(AGED_BRIE, BACKSTAGE);
        for (Item item : items) {
            String itemName = item.name;
            if (!itemList.contains(itemName)) {
                item.quality = qualityDecrement(item);
            } else {
                sellInCalculator(item, itemName);
            }
            if (!itemName.equals(SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }
            qualityCheck(item, itemName);
        }
    }
    private void qualityCheck(Item item, String itemName) {
        if (item.sellIn < 0) {
            if (!itemName.equals(AGED_BRIE)) {
                item.quality = !itemName.equals(BACKSTAGE) ? qualityDecrement(item) : 0;

            } else {
                qualityIncrement(item);
            }
        }
    }
    private void sellInCalculator(Item item, String itemName) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
            if (itemName.equals(BACKSTAGE) && item.sellIn < 11) {
                qualityIncrement(item);
                if (item.sellIn < 6) {
                    qualityIncrement(item);
                }
            }
        }
    }
    private void qualityIncrement(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
    private int qualityDecrement(Item item) {
        if (item.quality > 0 && !item.name.equals(SULFURAS)) {
            return item.quality - 1;
        }
        return item.quality;
    }
}
