package com.github.dsh105.echopet.entity.pet;

import com.github.dsh105.echopet.EchoPet;
import com.github.dsh105.echopet.data.PetType;

public enum SizeCategory {
	
	TINY(1),
	REGULAR(1),
	LARGE(3),
	GIANT(4),
	OVERSIZE(10);
	
	private int mod;
	SizeCategory(int modifier) {
		this.mod = modifier;
	}
	
	public float getStartWalk(PetType petType) {
		return ((Integer) (EchoPet.getPluginInstance().options.getConfigOption("pets." + petType.toString().toLowerCase().replace("_", " ") + ".startFollowDistance", 12))) * this.mod;
	}
	
	public float getStopWalk(PetType petType) {
		return ((Integer) (EchoPet.getPluginInstance().options.getConfigOption("pets." + petType.toString().toLowerCase().replace("_", " ") + ".stopFollowDistance", 8))) * this.mod;
	}
	
	public float getTeleport(PetType petType) {
		return ((Integer) (EchoPet.getPluginInstance().options.getConfigOption("pets." + petType.toString().toLowerCase().replace("_", " ") + ".teleportDistance", 50))) * this.mod;
	}
}