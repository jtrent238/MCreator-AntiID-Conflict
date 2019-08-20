package com.jtrent238.mcreatoraidc;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class MCreatorClassFinder {

	static class ClassFinder{
		  public static final String[] searchPackages = {
		    "net.mcreator",
		  	"mod.mcreator",
		  	};

		  public static Class<?> findClassByName(String name) {
		    for(int i=0; i<searchPackages.length; i++){
		        try {
					return Class.forName(searchPackages[i] + "." + name);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    //nothing found: return null or throw ClassNotFoundException
		    return null;
		  }

		public static void searchPackages(String string) {
			String foundPackage = "";
			ArrayList foundPackages = new ArrayList();

	        System.out.println (Pattern.matches("MCreator", "MCreator" + string));
	        
	        for(int i = 0; i < foundPackages.size() + 1; i++) {
	        	foundPackage = string;
	        	System.out.println(foundPackage);
	        	foundPackages.add(i, foundPackage);
	        }
		}
	}
	
}
