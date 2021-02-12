package plugin.adodvstudios.skyblock.utils;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import plugin.adodvstudios.skyblock.Main;

public class Config implements Listener {
	
	private static Main plugin = (Main)Main.getPlugin(Main.class);
	public static FileConfiguration cfg = plugin.getConfig();
	
	public static String prefix = ChatColor.AQUA + "" + ChatColor.BOLD + "[AdodvSkyBlock] ";
	
	public static File getMainFolder() {
		return plugin.getDataFolder();
	}
	
	public static void notEnoughtCoins(Player p)
	{
		p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', "&c&lНе хватает монет!")); 
		p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', "&e&lВалюта &6&lсервера&7&l: &a&lИзумруды!"));
	}
	
	public static void toCfgScoreboardAll()
	{
		cfg.set("NameScoreBoard", "&e&lAdodv SkyBlock");
		cfg.set("line1", "&7&lГлавная команда: &c&l/ais");
		cfg.set("line2", "&7&lВалюта сервера: &a&lИзумруды");
		cfg.set("line3", "&7&lГлавная команда: &c&l/ais");
		
		cfg.set("line4", "&7&lВаше имя: &c&l#player#");
		
		cfg.set("line5", "&7&lУбийства мобов: &c&l#kills_mobs#");
		
		cfg.set("line6", "&7&lТекущий онлайн: &a&l#online_players#");
		cfg.set("line7", "&ewww.adodvstudios.webtm.ru");
		
		cfg.set("#Место где будет спавниться босс", "tutorial");
		cfg.set("BossX", 1);
		cfg.set("BossY", 1);
		cfg.set("BossZ", 1);
		
		cfg.set("#Место где будет арена для боссов и игроков", "tutorial");
		cfg.set("ArenaX", 1);
		cfg.set("ArenaY", 1);
		cfg.set("ArenaZ", 1);
		
		cfg.set("TaxiLocation1X", 1);
		cfg.set("TaxiLocation1Y", 1);
		cfg.set("TaxiLocation1Z", 1);
		
		cfg.set("TaxiLocation2X", 1);
		cfg.set("TaxiLocation2Y", 1);
		cfg.set("TaxiLocation2Z", 1);
		
		cfg.set("TaxiLocation3X", 1);
		cfg.set("TaxiLocation3Y", 1);
		cfg.set("TaxiLocation3Z", 1);
		
		plugin.saveConfig();
	}
	
	//----Taxi----//
	public static int FromTaxi1X()
	{
		return cfg.getInt("TaxiLocation1X");
	}
	
	public static int FromTaxi1Y()
	{
		return cfg.getInt("TaxiLocation1X");
	}
	
	public static int FromTaxi1Z()
	{
		return cfg.getInt("TaxiLocation1Z");
	}
	
	public static int FromTaxi2X()
	{
		return cfg.getInt("TaxiLocation2X");
	}
	
	public static int FromTaxi2Y()
	{
		return cfg.getInt("TaxiLocation2X");
	}
	
	public static int FromTaxi2Z()
	{
		return cfg.getInt("TaxiLocation2Z");
	}
	
	public static int FromTaxi3X()
	{
		return cfg.getInt("TaxiLocation3X");
	}
	
	public static int FromTaxi3Y()
	{
		return cfg.getInt("TaxiLocation3X");
	}
	
	public static int FromTaxi3Z()
	{
		return cfg.getInt("TaxiLocation3Z");
	}
	//----Taxi Done----//
	
	//----arenas----//
	
	public static int FromArenaX()
	{
		return cfg.getInt("ArenaX");
	}
	
	public static int FromArenaY()
	{
		return cfg.getInt("ArenaY");
	}
	
	public static int FromArenaZ()
	{
		return cfg.getInt("ArenaZ");
	}
	//----Done Arenas----//
	
	//----Boss----//
	public static int FromBossX()
	{
		return cfg.getInt("BossX");
	}
	
	public static int FromBossY()
	{
		return cfg.getInt("BossY");
	}
	
	public static int FromBossZ()
	{
		return cfg.getInt("BossZ");
	}
	//----done Bosses----//
	
	public static String FromSBName()
	{
		return cfg.getString("NameScoreBoard");
	}
	public static String FromLine1()
	{
		return cfg.getString("line1");
	}
	public static String FromLine2()
	{
		return cfg.getString("line2");
	}
	public static String FromLine3()
	{
		return cfg.getString("line3");
	}
	public static String FromLine4()
	{
		return cfg.getString("line4");
	}
	public static String FromLine5()
	{
		return cfg.getString("line5");
	}
	public static String FromLine6()
	{
		return cfg.getString("line6");
	}
	public static String FromLine7()
	{
		return cfg.getString("line7");
	}

}
