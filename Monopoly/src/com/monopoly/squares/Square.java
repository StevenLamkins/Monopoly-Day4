package com.monopoly.squares;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.monopoly.board.Move;
import com.monopoly.player.Player;
import com.monopoly.player.PlayerInfo;

public enum Square {
	Go                   (new GoSquare(SquareGroup.NONE, 0, 0)),
	MediterraneanAvenue  (new PropertySquare(SquareGroup.PURPLE, 60, 2)),
	CommunityChest1      (new ChestSquare(SquareGroup.NONE, 0, 0)),
	BalticAvenue         (new PropertySquare(SquareGroup.PURPLE, 60, 4)),
	IncomeTax            (new TaxSquare(SquareGroup.NONE, 0, 0)),
	ReadingRailroad      (new RailroadSquare(SquareGroup.RAILROAD, 200, 0)),
	OrientalAvenue       (new PropertySquare(SquareGroup.LIGHT_GREEN, 100, 6)),
	Chance1              (new ChanceSquare(SquareGroup.NONE, 0, 0)),
	VermontAvenue        (new PropertySquare(SquareGroup.LIGHT_GREEN, 100, 6)),
	ConnecticutAvenue    (new PropertySquare(SquareGroup.LIGHT_GREEN, 120, 8)),
	Jail                 (new JailSquare(SquareGroup.NONE, 0, 0)),
	SaintCharlesPlace    (new PropertySquare(SquareGroup.VIOLET, 140, 10)),
	ElectricCompany      (new UtilitySquare(SquareGroup.UTILITIES, 150, 0)),
	StatesAvenue         (new PropertySquare(SquareGroup.VIOLET, 140, 10)),
	VirginiaAvenue       (new PropertySquare(SquareGroup.VIOLET, 160, 12)),
	PennsylvaniaRailroad (new RailroadSquare(SquareGroup.RAILROAD, 200, 0)),
	SaintJamesPlace      (new PropertySquare(SquareGroup.ORANGE, 180, 14)),
	CommunityChest2      (new ChestSquare(SquareGroup.NONE, 0, 0)),
	TennesseeAvenue      (new PropertySquare(SquareGroup.ORANGE, 180, 14)),
	NewYorkAvenue        (new PropertySquare(SquareGroup.ORANGE, 200, 16)),
	FreeParking          (new FreeParkingSquare(SquareGroup.NONE, 0, 0)),
	KentuckyAvenue       (new PropertySquare(SquareGroup.RED, 220, 18)),
	Chance2              (new ChanceSquare(SquareGroup.NONE, 0, 0)),
	IndianaAvenue        (new PropertySquare(SquareGroup.RED, 220, 18)),
	IllinoisAvenue       (new PropertySquare(SquareGroup.RED, 240, 20)),
	BAndORailroad        (new RailroadSquare(SquareGroup.RAILROAD, 200, 0)),
	AtlanticAvenue       (new PropertySquare(SquareGroup.YELLOW, 260, 22)),
	VentnorAvenue        (new PropertySquare(SquareGroup.YELLOW, 260, 22)),
	WaterWorks           (new UtilitySquare(SquareGroup.UTILITIES, 150, 0)),
	MarvinGardens        (new PropertySquare(SquareGroup.YELLOW, 280, 22)),
	GoToJail             (new GoToJailSquare(SquareGroup.NONE, 0, 0)),
	PacificAvenue        (new PropertySquare(SquareGroup.DARK_GREEN, 300, 26)),
	NorthCarolinaAvenue  (new PropertySquare(SquareGroup.DARK_GREEN, 300, 26)),
	CommunityChest3      (new ChestSquare(SquareGroup.NONE, 0, 0)),
	PennsylvaniaAvenue   (new PropertySquare(SquareGroup.DARK_GREEN, 350, 28)),
	ShortLineRailroad    (new RailroadSquare(SquareGroup.RAILROAD, 200, 0)),
	Chance3              (new ChanceSquare(SquareGroup.NONE, 0, 0)),
	ParkPlace            (new PropertySquare(SquareGroup.DARK_BLUE, 350, 35)),
	LuxuryTax            (new TaxSquare(SquareGroup.NONE, 0, 0)),
	Boardwalk            (new PropertySquare(SquareGroup.DARK_BLUE, 400, 50));
	
	private static Map<SquareGroup, LinkedHashSet<Square>> monopolyMap;
	private static Map<Square, Player> ownerMap;
	
	public static void setup() {
		monopolyMap = new HashMap<SquareGroup, LinkedHashSet<Square>>();
		ownerMap = new HashMap<Square, Player>();
		
		for (Square s : Square.values()) {
			SquareGroup group = s.getType().getGroup();
			
			if (!monopolyMap.containsKey(group)) {
				monopolyMap.put(group, new LinkedHashSet<Square>());
			}
			
			monopolyMap.get(group).add(s);
		}
	}
	
	public static List<SquareGroup> getMonopolies(List<Square> properties) {
		List<SquareGroup> monopolies = new ArrayList<SquareGroup>();
		
		Map<SquareGroup, Set<Square>> monopolyMap = new HashMap<SquareGroup, Set<Square>>();
		
		for (Square s : properties) {
			SquareGroup group = s.getType().getGroup();
			if (!monopolyMap.containsKey(group)) {
				monopolyMap.put(group, new HashSet<Square>());
			}
			
			monopolyMap.get(group).add(s);
		}
		
		for (SquareGroup group : Square.monopolyMap.keySet()) {
			Set<Square> playerSquares = monopolyMap.get(group);
			Set<Square> squares = Square.monopolyMap.get(group);
			
			if (playerSquares != null && playerSquares.containsAll(squares)) {
				monopolies.add(group);
			}
		}
		
		return monopolies;
	}
	
	public static Square getSquareWithLeastHousesInGroup(SquareGroup group) {
		Square square = null;
		int minNumHouses = Integer.MAX_VALUE;
		
		for (Square s : monopolyMap.get(group)) {
			int numHouses = s.getType().getNumHouses();
			
			if (numHouses < minNumHouses) {
				minNumHouses = numHouses;
				square = s;
			}
		}
		
		return square;
	}
	
	public static Player getSquareOwner(Square s) {
		return ownerMap.get(s);
	}
	
	/**
	 * Adds given square to player's property list, updates owner map
	 * @param p
	 * @param square
	 */
	public static void setSquareOwner(Player p, Square square) {
		p.addProperty(square);
		ownerMap.put(square, p);
	}
	
	public static int getNumRailroadsOwned(PlayerInfo p) {
		return (getSquareOwner(Square.BAndORailroad) == p ? 1 : 0) +
			   (getSquareOwner(Square.PennsylvaniaRailroad) == p ? 1 : 0) +
			   (getSquareOwner(Square.ReadingRailroad) == p ? 1 : 0) +
			   (getSquareOwner(Square.ShortLineRailroad) == p ? 1 : 0);
	}
	
	private SquareType type;
	private int boardPosition;
	
	private Square(SquareType type) {
		this.type = type;
	}
	
	public SquareType getType() {
		return type;
	}
	
	public int getBoardPosition() {
		return boardPosition;
	}
	
	public void setBoardPosition(int boardPosition) {
		this.boardPosition = boardPosition;
	}	
	
	public void handleMove(Move move) {
		type.handleMove(move);
	}

	public static boolean hasHouses(Square square) {
		return square.getType().getNumHouses() > 0;
	}
}
