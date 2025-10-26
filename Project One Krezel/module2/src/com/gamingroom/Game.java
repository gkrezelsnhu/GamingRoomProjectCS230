package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires an id and name to be passed
 * when creating. Also note that no mutators (setters) defined so these values
 * cannot be changed once a game is created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {

	private List<Team> teams = new ArrayList<Team>();

	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	private Game() {
	}

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		this();
		this.id = id;
		this.name = name;

	}

	/**
	 * Creates a new team and adds it to the teams list.
	 * 
	 * @param name
	 * @return returns the created team or null if no team was created
	 */
	public Team addTeam(String name) {

		// Search for an existing team with the provided name
		for (Team t : teams) {
			// return null if there is an existing team, which will allow checking invalid
			// names.
			if (t.getName().equals(name))
				return null;
		}

		long nextId = GameService.getInstance().getNextTeamId();

		Team t = new Team(nextId, name);

		teams.add(t);
		return t;

	}

	// helper function for debugging
	public int getPlayerCount() {
		int playerCount = 0;

		for (Team t : teams) {
			playerCount += t.getPlayerCount();
		}
		
		return playerCount;
	}

	@Override
	public String toString() {

		return "Game [id=" + id + ", name=" + name + "]\n\tConnected Players: " + getPlayerCount();
	}

}
