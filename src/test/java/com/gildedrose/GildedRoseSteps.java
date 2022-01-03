package com.gildedrose;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GildedRoseSteps {
	GildedRose gr;
	Item item;
	int sellInDays;
	
	@Given("an item named {string} with quality {int} and which has to be sold in {int} days")
	public void anItemNamedWithQualityAndWhichHasToBeSoldInDays(String name, Integer quality, Integer sellInDays) {
		guildedRoseWithItem(name,sellInDays,quality);
	}
	
	private void guildedRoseWithItem(String name, Integer sellIn, Integer quality) {
		item = new Item(name,sellIn,quality);
		gr = new GildedRose(new Item[] {item});
	}

	@When("a day has passed")
	public void aDayHasPassed() {
	    gr.updateQuality();
	}
	
	@When("{int} days have passed")
	public void daysHavePassed(int days) {
		for (int i = 0; i < days; i++) 
			gr.updateQuality();
	    
	}
	
	@Then("it has to be sold in {int} days")
	public void itHasToBeSoldInDays(Integer sellInDays) {
	    assertEquals((int) sellInDays, item.sellIn);
	}
	
	@Then("its quality is {int}")
	public void itsQualityIs(Integer int1) {
	    assertEquals((int) int1, item.quality);
	}

}
