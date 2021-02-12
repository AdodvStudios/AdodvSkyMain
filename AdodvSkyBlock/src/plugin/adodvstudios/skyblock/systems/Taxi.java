package plugin.adodvstudios.skyblock.systems;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import plugin.adodvstudios.skyblock.Main;
import plugin.adodvstudios.skyblock.menus.TimesMenu;
import plugin.adodvstudios.skyblock.menus.WeatherMenu;
import plugin.adodvstudios.skyblock.utils.Config;
import plugin.adodvstudios.skyblock.utils.IslandCreate;
import vk.com.korne3v.AsyncMenu.AsyncMenu;
import vk.com.korne3v.AsyncMenu.api.MenuAPI;
import vk.com.korne3v.AsyncMenu.menu.Menu;
import vk.com.korne3v.AsyncMenu.utils.ItemUtil;

public class Taxi implements Listener {
	
	private static Main plugin = (Main)Main.getPlugin(Main.class);
	public static String taxiMenu = ChatColor.translateAlternateColorCodes('&', "&c&lAdodv™ &7&l| &e&lТакси");
	
	public static Location car = new Location(Bukkit.getWorld("world"), 200, 200, 200);
	public static ArrayList<Player> taxiPlayers1 = new ArrayList<Player>();
	
	public static Location loc1 = new Location(Bukkit.getWorld("world"), Config.FromTaxi1X(), Config.FromTaxi1Y(), Config.FromTaxi1Z()); 
	public static Location loc2 = new Location(Bukkit.getWorld("world"), Config.FromTaxi2X(), Config.FromTaxi2Y(), Config.FromTaxi2Z());
	public static Location loc3 = new Location(Bukkit.getWorld("world"), Config.FromTaxi3X(), Config.FromTaxi3Y(), Config.FromTaxi3Z());
	
	
	public static void openMenu(Player p)
	{
		MenuAPI menuApi = AsyncMenu.getApi();
		
		Menu Taxi = menuApi.create(taxiMenu, 1)
                .setRemoveOnClose(true)
                
                .setItem(3, new ItemUtil(Material.ACACIA_DOOR_ITEM).setNamed(ChatColor.YELLOW + "Остановка №1").build(), (player, type) -> {
                	if(type == ClickType.LEFT)
                	{
                		p.teleport(car);
                		taxiPlayers1.add(player);
                		Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
							
							@SuppressWarnings("deprecation")
							@Override
							public void run() {
								p.sendTitle(ChatColor.GREEN + "Приехали", "");
								p.teleport(loc1);
								taxiPlayers1.remove(p);
							}
						}, 15*5);
                	}
                })
		
                .setItem(4, new ItemUtil(Material.BIRCH_DOOR_ITEM).setNamed(ChatColor.YELLOW + "Остановка №2").build(), (player, type) -> {
                	if(type == ClickType.LEFT)
                	{
                		p.teleport(car);
                		taxiPlayers1.add(player);
                		Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
					
                			@SuppressWarnings("deprecation")
                			@Override
                			public void run() {
                				p.sendTitle(ChatColor.GREEN + "Приехали", "");
                				p.teleport(loc2);
                				taxiPlayers1.remove(p);
                			}
                		}, 15*5);
                	}
                })
                
                .setItem(5, new ItemUtil(Material.DARK_OAK_DOOR_ITEM).setNamed(ChatColor.YELLOW + "Остановка №3").build(), (player, type) -> {
                	if(type == ClickType.LEFT)
                	{
                		p.teleport(car);
                		taxiPlayers1.add(player);
                		Bukkit.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
					
                			@SuppressWarnings("deprecation")
                			@Override
                			public void run() {
                				p.sendTitle(ChatColor.GREEN + "Приехали", "");
                				p.teleport(loc3);
                				taxiPlayers1.remove(p);
                			}
                		}, 15*5);
                	}
                });
		
               

		Taxi.open(p);
	}
	
	@EventHandler
	public static void onMoveCancel(PlayerMoveEvent e)
	{
		for(Player plr : taxiPlayers1)
		{
			Player p = Bukkit.getPlayer(plr.getName());
			p.teleport(car);
		}
	}
	
	@EventHandler
	public void antiDamage(EntityDamageEvent e)
	{
		DamageCause c = e.getCause();
		
		if(c == DamageCause.FALL) {
			e.setCancelled(true);
		}
	}
	

}
