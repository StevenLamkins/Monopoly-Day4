package com.monopoly;

import java.util.List;

public class Card {
	String goToTarget, goToTypeTarget, moneyAmount;
	boolean fixHouses, jailFree, backThree, payFifty;
	
	public Card(String input){
		String[] split = input.split(":");
		if(split[0].equals("goTo")){
			goToTarget = split[1].split(",")[0];
		}
		else if(split[0].equals("goToType")){
			goToTypeTarget = split[1].split(",")[0];
		}
		else if(split[0].equals("money")){
			moneyAmount = split[1];
		}
		else if(split[0].equals("fixHouses")){
			fixHouses=true;
		}
		else if(split[0].equals("jailFree")){
			jailFree=true;
		}
		else if(split[0].equals("backThree")){
			backThree=true;
		}
		else if(split[0].equals("payAllFifty")){
			payFifty=true;
		}
	}
	
	public boolean drawThisCard(Player player){
		boolean stillInGame = true;
		if(fixHouses){
			System.out.println("Chance! " + player.getToken() + " needs to fix his houses up!");
			for (Property property : player.ownedProperties) {
				if(property.houseCount*50<=player.money)
					player.removeMoney(property.houseCount*50);
				else
					stillInGame = false;
			}
		}
		else if (jailFree){
			System.out.println("Chance! " + player.getToken() + " Has earned a get out of jail free card!");
			player.addOutOfJailCard();
		}
		else if(backThree){
			System.out.println("Chance! " + player.getToken());
			player.moveSpaces(37, true, false);
		}
		else if(payFifty){
			System.out.println("Chance! " + player.getToken() + " needs to pay everyone 50$");
			if((MonopolyGame.players.size()-1)*50 <= player.money){
				for (Player player2 : MonopolyGame.players) {
					if(player2!=player){
						player2.addMoney(50);
						player.removeMoney(50);
					}
				}
			}
		}
		else if(moneyAmount!=null){
			System.out.println("Chance! " + player.getToken() + " Will be changing his money by " + moneyAmount);
			player.addMoney(Integer.valueOf(moneyAmount));
		}
		else if(goToTypeTarget!=null){
			System.out.println("Chance! " + player.getToken() + " will be moving to the nearest " + goToTypeTarget);
			player.moveToNearestType(goToTypeTarget);
		}
		else if(goToTarget!=null){
			System.out.println("Chance! " + player.getToken() + " will be moving to " + goToTarget);
			player.moveToSquare(goToTarget, true, true);
		}
		return stillInGame;
	}
}
