package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires an id and name to be passed
 * when creating. Also note that no mutators (setters) defined so these values
 * cannot be changed once a team is created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity{
	
	private List<Player> players = new ArrayList<Player>();
	
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Creates a player and adds it to the players list.
	 * 
	 * @param name name of the player
	 * @return created player or null if a player with the provided name exists
	 */
	public Player addPlayer(String name) {

		for (Player p : players) {
			if (p.getName().equals(name))
				return null;
		}

		long pId = GameService.getInstance().getNextPlayerId();
		Player p = new Player(pId, name);

		players.add(p);
		return p;

	}

	
	// this method is not included in the UML diagram, but its purely for debugging and displaying info,
	// so I thought it would be okay
	public int getPlayerCount() {
		return players.size();
	}
	
	
	@Override
	public String toString() {

		String playerList = "";

		if (players.isEmpty()) {
			playerList = "\tNo connected players";
		} else {
			for (Player p : players) {
				playerList += "\t" + p.toString() + "\n";
			}
		}

		return "Team [id=" + id + ", name=" + name + "]\n" + "Players: " + players.size() + "\n" + playerList;

	}
}
