package com.monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum Square {
	Go                   (SquareType.GO, SquareGroup.NONE, 0, 0),
	MediterraneanAvenue  (SquareType.PROPERTY, SquareGroup.PURPLE, 60, 2),
	CommunityChest1      (SquareType.CHEST, SquareGroup.NONE, 0, 0),
	BalticAvenue         (SquareType.PROPERTY, SquareGroup.PURPLE, 60, 4),
	IncomeTax            (SquareType.TAX, SquareGroup.NONE, 0, 0),
	ReadingRailroad      (SquareType.PROPERTY, SquareGroup.RAILROAD, 200, 0),
	OrientalAvenue       (SquareType.PROPERTY, SquareGroup.LIGHT_GREEN, 100, 6),
	Chance1              (SquareType.CHANCE, SquareGroup.NONE, 0, 0),
	VermontAvenue        (SquareType.PROPERTY, SquareGroup.LIGHT_GREEN, 100, 6),
	ConnecticutAvenue    (SquareType.PROPERTY, SquareGroup.LIGHT_GREEN, 120, 8),
	Jail                 (SquareType.JAIL, SquareGroup.NONE, 0, 0),
	SaintCharlesPlace    (SquareType.PROPERTY, SquareGroup.VIOLET, 140, 10),
	ElectricCompany      (SquareType.PROPERTY, SquareGroup.UTILITIES, 150, 0),
	StatesAvenue         (SquareType.PROPERTY, SquareGroup.VIOLET, 140, 10),
	VirginiaAvenue       (SquareType.PROPERTY, SquareGroup.VIOLET, 160, 12),
	PennsylvaniaRailroad (SquareType.PROPERTY, SquareGroup.RAILROAD, 200, 0),
	SaintJamesPlace      (SquareType.PROPERTY, SquareGroup.ORANGE, 180, 14),
	CommunityChest2      (SquareType.CHEST, SquareGroup.NONE, 0, 0),
	TennesseeAvenue      (SquareType.PROPERTY, SquareGroup.ORANGE, 180, 14),
	NewYorkAvenue        (SquareType.PROPERTY, SquareGroup.ORANGE, 200, 16),
	FreeParking          (SquareType.FREE_PARKING, SquareGroup.NONE, 0, 0),
	KentuckyAvenue       (SquareType.PROPERTY, SquareGroup.RED, 220, 18),
	Chance2              (SquareType.CHANCE, SquareGroup.NONE, 0, 0),
	IndianaAvenue        (SquareType.PROPERTY, SquareGroup.RED, 220, 18),
	IllinoisAvenue       (SquareType.PROPERTY, SquareGroup.RED, 240, 20),
	BAndORailroad        (SquareType.PROPERTY, SquareGroup.RAILROAD, 200, 0),
	AtlanticAvenue       (SquareType.PROPERTY, SquareGroup.YELLOW, 260, 22),
	VentnorAvenue        (SquareType.PROPERTY, SquareGroup.YELLOW, 260, 22),
	WaterWorks           (SquareType.PROPERTY, SquareGroup.UTILITIES, 150, 0),
	MarvinGardens        (SquareType.PROPERTY, SquareGroup.YELLOW, 280, 22),
	GoToJail             (SquareType.GO_TO_JAIL, SquareGroup.NONE, 0, 0),
	PacificAvenue        (SquareType.PROPERTY, SquareGroup.DARK_GREEN, 300, 26),
	NorthCarolinaAvenue  (SquareType.PROPERTY, SquareGroup.DARK_GREEN, 300, 26),
	CommunityChest3      (SquareType.CHEST, SquareGroup.NONE, 0, 0),
	PennsylvaniaAvenue   (SquareType.PROPERTY, SquareGroup.DARK_GREEN, 350, 28),
	ShortLineRailroad    (SquareType.PROPERTY, SquareGroup.RAILROAD, 200, 0),
	Chance3              (SquareType.CHANCE, SquareGroup.NONE, 0, 0),
	ParkPlace            (SquareType.PROPERTY, SquareGroup.DARK_BLUE, 350, 35),
	LuxuryTax            (SquareType.TAX, SquareGroup.NONE, 0, 0),
	Boardwalk            (SquareType.PROPERTY, SquareGroup.DARK_BLUE, 400, 50);
	
	private static Map<SquareGroup, Set<Square>> monopolyMap;
	
	static {
		monopolyMap = new HashMap<>();
		
		for (Square s : Square.values()) {
			if (!monopolyMap.containsKey(s.getGroup())) {
				monopolyMap.put(s.getGroup(), new HashSet<Square>());
			}
			
			monopolyMap.get(s.getGroup()).add(s);
		}
	}
	
	public static List<SquareGroup> getMonopolies(List<Square> properties) {
		List<SquareGroup> monopolies = new ArrayList<>();
		
		Map<SquareGroup, Set<Square>> monopolyMap = new HashMap<>();
		
		for (Square s : properties) {
			if (!monopolyMap.containsKey(s.getGroup())) {
				monopolyMap.put(s.getGroup(), new HashSet<Square>());
			}
			
			monopolyMap.get(s.getGroup()).add(s);
		}
		
		for (SquareGroup group : Square.monopolyMap.keySet()) {
			Set<Square> playerSquares = monopolyMap.get(group);
			Set<Square> squares = Square.monopolyMap.get(group);
			
			if (playerSquares != null && playerSquares.containsAll(squares)) {
				monopolies.add(group);
				System.out.println("FOUND MONOPOLY "+group.name());
			}
		}
		
		return monopolies;
	}
	
	private SquareType type;
	private SquareGroup group;
	private int price;
	private int rent;
	private int houseBuildingCost;
	private int numHouses;
	
	private Square(SquareType type, SquareGroup group, int price, int rent) {
		this.type = type;
		this.group = group;
		this.price = price;
		this.rent = rent;
		
		switch (group) {
			case PURPLE:
			case LIGHT_GREEN:
				houseBuildingCost = 50;
				break;
			case VIOLET:
			case ORANGE:
				houseBuildingCost = 100;
				break;
			case RED:
			case YELLOW:
				houseBuildingCost = 150;
				break;
			case DARK_GREEN:
			case DARK_BLUE:
				houseBuildingCost = 200;
				break;
			default:
				break;
		}
	}
	
	public SquareType getType() {
		return type;
	}
	
	public SquareGroup getGroup() {
		return group;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getRent() {
		return (int) (rent + (rent * 1.25) * numHouses);
	}
	
	public int getNumHouses() {
		return numHouses;
	}
	
	public int getHouseBuildingCost() {
		return houseBuildingCost;
	}
	
	public int addHouse() {
		return ++numHouses;
	}
	
	public int removeHouse() {
		if (numHouses > 0) numHouses--;
		
		return numHouses;
	}
}
