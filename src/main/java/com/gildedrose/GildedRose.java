package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void updateBrie(int i) {
    	if (items[i].quality < 50) 
            items[i].quality++;
    }
    
    public void updateConcertTicket(int i) {
    	
    }
    
    public void updateProductsQuality(int i) {
    	if(items[i].name.equals("Sulfuras, Hand of Ragnaros"))
    		return;
    	else if(items[i].name.equals("Aged Brie")) {
    		updateBrie(i);
    		items[i].sellIn--;
    		return;
    	}
    	else if(items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
    		
    	}
    	
    	if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (items[i].quality > 0) 
               items[i].quality--;    
        } 
    	else {
            if (items[i].quality < 50) {
                items[i].quality++;

                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (items[i].sellIn < 11) {
                        if (items[i].quality < 50) 
                            items[i].quality++;
                    }

                    if (items[i].sellIn < 6) {
                        if (items[i].quality < 50) 
                            items[i].quality++;
                    }
                }
            }
        }

        items[i].sellIn--;
        if (items[i].sellIn < 0) {
            if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) 
                        items[i].quality--;
            } 
            else 
                items[i].quality = 0;      
    }
    }
    
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) 
        	updateProductsQuality(i);
    }
}