package plugin.adodvstudios.skyblock.utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import plugin.adodvstudios.skyblock.Main;
import plugin.adodvstudios.skyblock.menus.BossesMenu;
import plugin.adodvstudios.skyblock.utils.boss.PumpkinScarecrow;
import plugin.adodvstudios.skyblock.utils.boss.ZombieLevel1;

public class Schedulers {
	
	public static ArrayList<Player> Waiting = new ArrayList<Player>();
	
	public static void startSpawnBoss1(Player p)
	{
		Main plugin = (Main)Main.getPlugin(Main.class);
		Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				p.sendTitle(ChatColor.RED + "5", null);
				Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
					
					@Override
					public void run() {
						p.sendTitle(ChatColor.RED + "4", null);
						Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
							
							@Override
							public void run() {
								p.sendTitle(ChatColor.RED + "3", null);
								Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
									
									@Override
									public void run() {
										p.sendTitle(ChatColor.RED + "2", null);
										Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
											
											@Override
											public void run() {
												p.sendTitle(ChatColor.GREEN + "Погнали!", "Нужно убить босса!");
												Waiting.clear();
												ZombieLevel1.killsThisMob.add(p);
												ZombieLevel1.spawn();
												Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stoplag -c");
											}
										}, 5*5);
									}
								}, 15*4);
							}
						}, 15*3);
					}
				}, 15*2);
			}
		}, 15*1);
	}
	
	public static void startSpawnBoss2(Player p)
	{
		Main plugin = (Main)Main.getPlugin(Main.class);
		Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				p.sendTitle(ChatColor.RED + "5", null);
				Waiting.add(p);
				Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
					
					@Override
					public void run() {
						p.sendTitle(ChatColor.RED + "4", null);
						Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
							
							@Override
							public void run() {
								p.sendTitle(ChatColor.RED + "3", null);
								Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
									
									@Override
									public void run() {
										p.sendTitle(ChatColor.RED + "2", null);
										Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
											
											@Override
											public void run() {
												p.sendTitle(ChatColor.GREEN + "Погнали!", "Нужно убить босса!");
												Waiting.clear();
												Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stoplag -c");
												PumpkinScarecrow.killsThisMob.add(p);
												PumpkinScarecrow.spawn();
											}
										}, 5*5);
									}
								}, 15*4);
							}
						}, 15*3);
					}
				}, 15*2);
			}
		}, 15*1);
	}

	
}
