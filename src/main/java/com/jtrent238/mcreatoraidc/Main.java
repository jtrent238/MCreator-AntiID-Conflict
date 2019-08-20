package com.jtrent238.mcreatoraidc;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.util.Random;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import com.jtrent238.mcreatoraidc.MCreatorClassFinder.ClassFinder;
import com.jtrent238.mcreatoraidc.MCreatorModIDList;
import com.jtrent238.mcreatoraidc.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.MODVERSION, useMetadata = true)
public class Main {

    public static final String MODID = "mcreatoraidc";
	public static final String MODNAME = "jtrent238's MCreator AntiID Conflict";
	public static final String MODAUTHOR = "jtrent238";
	public static final String MODVERSION = "1.0.0.0-indev";
	public static final String MC = "1.12.2";

    @SidedProxy(clientSide = "com.jtrent238.mcreatoraidc.proxy.ClientProxy", serverSide = "com.jtrent238.mcreatoraidc.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static Main instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
        
        //MCreatorIDFinder.findDimIDS();

        getModIDList();
    }

    public void getModIDList() {
		try (BufferedInputStream in = new BufferedInputStream(new URL(MCreatorModIDList.modlisturl).openStream());
				  FileOutputStream fileOutputStream = new FileOutputStream(MCreatorModIDList.modlistfile)) {
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
					     InputStream link = (getClass().getResourceAsStream(MCreatorModIDList.modlistfile));
					     try {
							Files.copy(link, file.getAbsoluteFile().toPath());
						} catch (IOException e1) {
							System.out.println("Something happened when extracting internal modlist.");
							e1.printStackTrace();
						}
					}
				}
	}

	@Mod.EventHandler
    public void init(FMLInitializationEvent e, ModelRegistryEvent mre){
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) throws IOException {
        proxy.postInit(e);   
    }

}