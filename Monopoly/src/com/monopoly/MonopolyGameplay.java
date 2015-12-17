package com.monopoly;

import java.util.List;

public interface MonopolyGameplay {

	public abstract void playRound();
	
	public abstract List<PlayerData> getPlayerData();

}