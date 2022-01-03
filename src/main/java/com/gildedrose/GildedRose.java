package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void updateNormalItem(int i) {
    	if (items[i].quality > 0)
    		items[i].quality--;
    	if (items[i].quality > 0&&items[i].sellIn<1)
    		items[i].quality--;
    	items[i].sellIn--;
    }
    
    public void updateBrie(int i) {
    	if (items[i].quality < 50) 
            items[i].quality++;
    }
    
    public void updateConcertTicket(int i) {
    	if(items[i].sellIn<1) {
    		items[i].sellIn--;
    		items[i].quality=0;
    		return;
    	}
    	if (items[i].quality < 50) 
            items[i].quality++;
    	if (items[i].quality < 50&&items[i].sellIn<11) 
            items[i].quality++;
    	if (items[i].quality < 50&&items[i].sellIn<6) 
            items[i].quality++;
    	items[i].sellIn--;
    }
    
    public void updateProductsQuality(int i) {
    	if(items[i].name.equals("Aged Brie")) {
    		updateBrie(i);
    		items[i].sellIn--;
    		return;
    	}
    	else if(items[i].name.equals("Sulfuras, Hand of Ragnaros"))
    		return;
    	else if(items[i].name.contains("Backstage passes")) {
    		updateConcertTicket(i);
    		return;
    	}
    	else 
    		updateNormalItem(i);
    }
    
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) 
        	updateProductsQuality(i);
    }
}