package com.monopoly;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	List<Card> cards = new ArrayList<Card>();
	int currentCard=0;
	
	public Deck(){
		try {
			List<String> lines = Files.readAllLines(Paths.get("config/Chance.prop"));
			for (String line : lines) {
				cards.add(new Card(line));
			}
		} catch (Exception e) {
		}
		for(int i=0; i<10; i++){
			shuffle();
		}
	}
	
	private void shuffle(){
		int counter = 0;
		List<Card> tempCards = new ArrayList<Card>();
		Random rand = new Random();
		while(counter<cards.size()){
			int index = rand.nextInt(cards.size());
			if(!tempCards.contains(cards.get(index))){
				tempCards.add(cards.get(index));
				counter++;
			}
		}
	}
	
	public Card draw(){
		int returnIndex = currentCard;
		currentCard++;
		if(currentCard==cards.size())
			currentCard=0;
		return cards.get(returnIndex);
	}
}
