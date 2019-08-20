package com.jtrent238.mcreatoraidc;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;

public class MCreatorModIDList {

	public static final String lmlm = null;
	public static String modlisturl = "https://file.wine/hz2.txt"; // TODO Change Link
	public static String modlistfile = "MCreatorModIDS.txt";
	
	public MCreatorModIDList() {
		super();
		this.getModIDList();
	}


	public void getModIDList() {
		try (BufferedInputStream in = new BufferedInputStream(new URL(modlisturl).openStream());
				  FileOutputStream fileOutputStream = new FileOutputStream(modlistfile)) {
				    byte dataBuffer[] = new byte[1024];
				    int bytesRead;
				    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
				        fileOutputStream.write(dataBuffer, 0, bytesRead);
				    }
				} catch (IOException e) {
				    // handle exception
					System.out.println("Something happened when trying to download the modlist. Will use internal one instead.");
					File file = new File("newname.ext");
					if (!file.exists()) {
					     InputStream link = (getClass().getResourceAsStream(modlistfile));
					     try {
							Files.copy(link, file.getAbsoluteFile().toPath());
						} catch (IOException e1) {
							System.out.println("Something happened when extracting internal modlist.");
							e1.printStackTrace();
						}
					}
				}
	}


}
