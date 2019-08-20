package com.jtrent238.mcreatoraidc;

import com.jtrent238.mcreatoraidc.MCreatorClassFinder.ClassFinder;

public class MCreatorIDFinder {

	public static void findDimIDS() {
		
		ClassFinder.searchPackages("Dim");
		//ClassFinder.searchClass("");
		Main.logger.log(Main.logger.getLevel().INFO, "Found Dimension ID: %d from mod %s.");
	}

	public static void findBiomeIDS() {
		
		Main.logger.log(Main.logger.getLevel().INFO, "Found Biome ID: %d from mod %s.");
	}
	
	public static void findEnchantmentIDS() {
		
		Main.logger.log(Main.logger.getLevel().INFO, "Found Enchantment ID: %d from mod %s.");
	}
	
	public static void findPotionIDS() {
		
		Main.logger.log(Main.logger.getLevel().INFO, "Found Potion ID: %d from mod %s.");
	}
	
	public static void findEntityIDS() {
		
		Main.logger.log(Main.logger.getLevel().INFO, "Found Entity ID: %d from mod %s.");
	}
	
	public static void findOtherIDS() {
		
		Main.logger.log(Main.logger.getLevel().INFO, "Found Other ID: %d from mod %s.");
	}
}
