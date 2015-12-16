package com.monopoly.dice;


public class CoinUtil {
	private static Die die = new Die();
	
	private CoinUtil() {}
	
	/**
	 * For taking chances
	 * @return true or false, whether chance is successful or not
	 */
	public static boolean flipCoin() {
		return die.roll() < 4;
	}
}
