package plugin.adodvstudios.skyblock;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import plugin.adodvstudios.skyblock.commands.MainCommand;
import plugin.adodvstudios.skyblock.core.EnchantBlocks;
import plugin.adodvstudios.skyblock.menus.BossesMenu;
import plugin.adodvstudios.skyblock.systems.Taxi;
import plugin.adodvstudios.skyblock.utils.ActionBar;
import plugin.adodvstudios.skyblock.utils.Coins;
import plugin.adodvstudios.skyblock.utils.Config;
import plugin.adodvstudios.skyblock.utils.DownloadSchematics;
import plugin.adodvstudios.skyblock.utils.boss.PumpkinScarecrow;
import plugin.adodvstudios.skyblock.utils.boss.ZombieLevel1;
import plugin.adodvstudios.skyblock.utils.chat.ChatMain;

public class Main extends JavaPlugin implements Listener {
	
	public void onEnable() {
		loadclass(new EnchantBlocks());
		
		//----Main Command----//
		getCommand("ais").setExecutor(new MainCommand());
		
		//----Chat----//
		loadclass(new ChatMain());
		
		//----ScoreBoard----//
		loadclass(new ScoreBoard());
		
		//----Bosses----//
		loadclass(new ZombieLevel1());
		loadclass(new PumpkinScarecrow());
		loadclass(new BossesMenu());
		
		//----Taxi----//
		loadclass(new Taxi());
		
		//----ActionBar Util----//
		Bukkit.getPluginManager().registerEvents(new ActionBar(null), this);
		
		//----Coins file----//
		loadclass(new Coins());
		
		//----Stop lagging----//
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stoplag");
		
		//----DonwloadSchematics----//
		try {
			DownloadSchematics.Download();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(Config.FromSBName() == null)
		{
			Config.toCfgScoreboardAll();
		}
	}
	
	public void loadclass(Listener c)
	{
		Bukkit.getPluginManager().registerEvents(c, this);
	}

}
