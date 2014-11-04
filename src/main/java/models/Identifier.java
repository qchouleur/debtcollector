package models;

import java.util.UUID;

public class Identifier {

	private UUID id;
	
	private Identifier(UUID id) {
		this.id = id;
	}
	
	public static Identifier generate() {
		return new Identifier(UUID.randomUUID());
	}
	
	public static Identifier fromString(String id) {
		return new Identifier(UUID.fromString(id));
		
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Identifier){
			return this.id.compareTo(((Identifier)obj).id) == 0;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return id.toString();
	}
}
