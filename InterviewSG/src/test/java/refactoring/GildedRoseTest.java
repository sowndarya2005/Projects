package refactoring;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class GildedRoseTest {



    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assert.assertEquals("foo", app.items[0].name);
    }

    @Test
    public void sellintest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 38) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assert.assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
    }

    @Test
    void testToString() {
        Item item= new Item("test",2,34);
        Assert.assertNotEquals("test",item.toString());
    }
}