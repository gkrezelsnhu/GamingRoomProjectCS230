package com.gamingroom;


// class should be abstract to prevent instancing
public abstract class Entity {
	protected long id;
	protected String name;

	
	// Constructors
	protected Entity() {
	}

	public Entity(long id, String name) {
		this.id = id;
		this.name = name;
	}

	
	
	
	// Accessors
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Entity: [ID: " + id + ", Name: " + name + "]";
	}
}
