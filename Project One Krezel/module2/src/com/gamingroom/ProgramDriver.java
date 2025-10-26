package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		GameService service = GameService.getInstance();
		
		System.out.println("\nAbout to test initializing game data...");
		System.out.println("========================================");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		
		// init valid team
		Team g1t1 = game1.addTeam("G1T1");
		g1t1.addPlayer("p1");
		g1t1.addPlayer("p2");
		
		
		// test adding invalid player
		g1t1.addPlayer("p1");
		
		// test adding invalid team
		game1.addTeam("G1T1");
		
		
		Game game2 = service.addGame("Game #2");
		
		// test invalid game
		service.addGame("Game #1");
		
		
		// print status
		System.out.println(service);
		System.out.println("========================================");

		System.out.println(game1);
		System.out.println("========================================");
		
		System.out.println(g1t1);
		System.out.println("========================================");
		
		System.out.println(game2);
		System.out.println("========================================");
		
		
		
		
		
		
		
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
