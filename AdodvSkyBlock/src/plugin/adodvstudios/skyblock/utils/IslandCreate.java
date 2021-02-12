package plugin.adodvstudios.skyblock.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;

public class IslandCreate {
	
	public static HashMap<Player, Location> players = new HashMap<Player, Location>();
	
	public static int islandX; 
	public static int islandY;
	public static int islandZ;
	public static int OT = 100;
	public static int DO = 200;
	public static Location location = new Location(Bukkit.getWorld("islands"), islandX, islandY, islandZ);
	
	@SuppressWarnings("deprecation")
	public static void defaultIsland(Player p) {
		
		islandX = OT + (int) (Math.random() * DO);
		islandY = OT + (int) (Math.random() * DO);
		islandZ = OT + (int) (Math.random() * DO);
		
		WorldEditPlugin we = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
		
		p.teleport(new Location(Bukkit.getWorld("islands"), islandX, islandY, islandZ));

		File schematic = new File("plugins/AdodvSkyBlock/" + "default.schematic");
		
		EditSession session = we.getWorldEdit()
		    .getEditSessionFactory()
		    .getEditSession(
		        new BukkitWorld(Bukkit.getWorld("islands")), 1000000
		    );
		try {
		   MCEditSchematicFormat.getFormat("mcedit").load(schematic)
		        .paste(session, new Vector(islandX, islandY, islandZ), false);
		} catch (MaxChangedBlocksException|com.sk89q.worldedit.data.DataException | IOException e2) {
		    e2.printStackTrace();
		}
		
		if(p.getWorld() == Bukkit.getWorld("islands")) {
			p.sendMessage(Config.prefix + "Вы вошли на свой остров!");
		}
		players.put(p, location);
	}
	
	@SuppressWarnings("deprecation")
	public static void vipIsland(Player p) {
		
		islandX = OT + (int) (Math.random() * DO);
		islandY = OT + (int) (Math.random() * DO);
		islandZ = OT + (int) (Math.random() * DO);
		
		WorldEditPlugin we = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
		
		p.teleport(new Location(Bukkit.getWorld("islands"), islandX, islandY, islandZ));

		File schematic = new File("plugins/AdodvSkyBlock/" + "vip.schematic");
		
		EditSession session = we.getWorldEdit()
		    .getEditSessionFactory()
		    .getEditSession(
		        new BukkitWorld(Bukkit.getWorld("islands")), 1000000
		    );
		try {
		   MCEditSchematicFormat.getFormat("mcedit").load(schematic)
		        .paste(session, new Vector(islandX, islandY, islandZ), false);
		} catch (MaxChangedBlocksException|com.sk89q.worldedit.data.DataException | IOException e2) {
		    e2.printStackTrace();
		}
		
		if(p.getWorld() == Bukkit.getWorld("islands")) {
			p.sendMessage(Config.prefix + "Вы вошли на свой остров!");
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void santaIsland(Player p) {
		
		islandX = OT + (int) (Math.random() * DO);
		islandY = OT + (int) (Math.random() * DO);
		islandZ = OT + (int) (Math.random() * DO);
		
		WorldEditPlugin we = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
		
		p.teleport(new Location(Bukkit.getWorld("islands"), islandX, islandY, islandZ));

		File schematic = new File("plugins/AdodvSkyBlock/" + "santa.schematic");
		
		EditSession session = we.getWorldEdit()
		    .getEditSessionFactory()
		    .getEditSession(
		        new BukkitWorld(Bukkit.getWorld("islands")), 1000000
		    );
		try {
		   MCEditSchematicFormat.getFormat("mcedit").load(schematic)
		        .paste(session, new Vector(islandX, islandY, islandZ), false);
		} catch (MaxChangedBlocksException|com.sk89q.worldedit.data.DataException | IOException e2) {
		    e2.printStackTrace();
		}
		
		if(p.getWorld() == Bukkit.getWorld("islands")) {
			p.sendMessage(Config.prefix + "Вы вошли на свой остров!");
		}
		players.put(p, location);
	}
	
	@SuppressWarnings("deprecation")
	public static void cubIsland(Player p) {
		
		islandX = OT + (int) (Math.random() * DO);
		islandY = OT + (int) (Math.random() * DO);
		islandZ = OT + (int) (Math.random() * DO);
		
		WorldEditPlugin we = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
		
		p.teleport(new Location(Bukkit.getWorld("islands"), islandX, islandY, islandZ));

		File schematic = new File("plugins/AdodvSkyBlock/" + "cub.schematic");
		
		EditSession session = we.getWorldEdit()
		    .getEditSessionFactory()
		    .getEditSession(
		        new BukkitWorld(Bukkit.getWorld("islands")), 1000000
		    );
		try {
		   MCEditSchematicFormat.getFormat("mcedit").load(schematic)
		        .paste(session, new Vector(islandX, islandY, islandZ), false);
		} catch (MaxChangedBlocksException|com.sk89q.worldedit.data.DataException | IOException e2) {
		    e2.printStackTrace();
		}
		
		if(p.getWorld() == Bukkit.getWorld("islands")) {
			p.sendMessage(Config.prefix + "Вы вошли на свой остров!");
		}
		players.put(p, location);
	}

}
