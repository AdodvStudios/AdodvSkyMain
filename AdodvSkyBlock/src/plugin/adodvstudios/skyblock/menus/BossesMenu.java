package plugin.adodvstudios.skyblock.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import plugin.adodvstudios.skyblock.utils.Config;
import plugin.adodvstudios.skyblock.utils.Schedulers;
import vk.com.korne3v.AsyncMenu.AsyncMenu;
import vk.com.korne3v.AsyncMenu.api.MenuAPI;
import vk.com.korne3v.AsyncMenu.menu.Menu;
import vk.com.korne3v.AsyncMenu.utils.ItemUtil;

public class BossesMenu implements Listener {
	
	public static Location arena = new Location(Bukkit.getWorld("duels02"), Config.FromArenaX(), Config.FromArenaY(), Config.FromArenaZ());
	
	
	@SuppressWarnings("deprecation")
	public static void open(Player p) {
		ItemStack Boss1 = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta Boss1Meta = (SkullMeta) Boss1.getItemMeta();
		Boss1Meta.setOwner("NickAndChris");
		Boss1.setItemMeta(Boss1Meta);
	
		ItemStack Boss2 = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta Boss2Meta = (SkullMeta) Boss2.getItemMeta();
		Boss2Meta.setOwner("harryweb");
		Boss2.setItemMeta(Boss2Meta);
		
		MenuAPI api = AsyncMenu.getApi();
		
		String name = ChatColor.translateAlternateColorCodes('&', "&e&lÁîññû &6&lÒÅÐÌÈÍÀË");
		
		String boss1Name = ChatColor.translateAlternateColorCodes('&', "&c&lÁîññ &7&lÇîìáè &a&lÓðîâåíü &2&l1");
		String boss2Name = ChatColor.translateAlternateColorCodes('&', "&c&lÁîññ &e&l×ó÷åëî &a&lÓðîâåíü &2&l2");
		
		Menu categories = api.create(name, 2)
                .setRemoveOnClose(true)
                
                .setItem(12, new ItemUtil(Boss1).setNamed(boss1Name).build(), (player, type) -> {
                	if(type == ClickType.LEFT)
                	{
                		p.teleport(arena);
                		Schedulers.Waiting.add(p);
                		Schedulers.startSpawnBoss1(p);
                	}
                })
                
                .setItem(14, new ItemUtil(Boss2).setNamed(boss2Name).build(), (player, type) -> {
                	if(type == ClickType.LEFT)
                	{
                		p.teleport(arena);
                		Schedulers.Waiting.add(p);
                		Schedulers.startSpawnBoss2(p);
                	}
                });
		

		categories.open(p);
		
	}
	
	@EventHandler
	public void antiMove(PlayerMoveEvent e)
	{
		for(Player p : Schedulers.Waiting)
		{
			p.teleport(arena);
		}
	}

}
