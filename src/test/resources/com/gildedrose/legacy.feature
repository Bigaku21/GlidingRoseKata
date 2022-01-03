Feature: Gilded Rose behaviour of the legacy code


Scenario: At the end of each day our system lowers both values for every item
	Given an item named "Apples" with quality 10 and which has to be sold in 10 days
	When a day has passed
	Then it has to be sold in 9 days
	And its quality is 9
	

Scenario: Once the sell by date has passed, Quality degrades twice as fast
	Given an item named "Apples" with quality 5 and which has to be sold in 1 days
	When 2 days have passed
	Then it has to be sold in -1 days
	And its quality is 2


Scenario: The Quality of an item is never negative
	Given an item named "Apples" with quality 0 and which has to be sold in 0 days
	When a day has passed
	Then it has to be sold in -1 days
	And its quality is 0


Scenario: "Aged Brie" actually increases in Quality the older it gets
	Given an item named "Aged Brie" with quality 9 and which has to be sold in 11 days
	When a day has passed
	Then it has to be sold in 10 days
	And its quality is 10


Scenario: The Quality of an item is never more than 50
	Given an item named "Aged Brie" with quality 45 and which has to be sold in 15 days
	When 10 days have passed
	Then it has to be sold in 5 days
	And its quality is 50


Scenario: "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	Given an item named "Sulfuras, Hand of Ragnaros" with quality 80 and which has to be sold in 0 days
	When a day has passed
	Then it has to be sold in 0 days
	And its quality is 80


Scenario: "Sulfuras", being a legendary item, never has to be sold or decreases in Quality 2
	Given an item named "Sulfuras, Hand of Ragnaros" with quality 80 and which has to be sold in -1 days
	When 10 days have passed
	Then it has to be sold in -1 days
	And its quality is 80
	
	
Scenario: "Backstage passes" decreases in quality if there are more than 10 days left
	Given an item named "Backstage passes" with quality 10 and which has to be sold in 25 days
	When 5 days have passed
	Then it has to be sold in 20 days
	And its quality is 5
	
	
#Functionality is not working yet
#Scenario: "Backstage passes" increases by 2 in quality if there are 10 or less days left, but more than 5
#	Given an item named "Backstage passes" with quality 10 and which has to be sold in 10 days
#	When 3 days have passed
#	Then it has to be sold in 7 days
#	And its quality is 16
#
#Scenario: "Backstage passes" increases by 3 in quality if there are 5 or less days left, but more than 0
#	Given an item named "Backstage passes" with quality 5 and which has to be sold in 5 days
#	When 4 days have passed
#	Then it has to be sold in 1 days
#	And its quality is 17
#
#Scenario: "Backstage passes" quality drops to 0 after the concert
#	Given an item named "Backstage passes" with quality 50 and which has to be sold in 2 days
#	When 4 days have passed
#	Then it has to be sold in -2 days
#	And its quality is 0
