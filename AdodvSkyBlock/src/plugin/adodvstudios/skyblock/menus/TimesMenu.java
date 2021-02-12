package plugin.adodvstudios.skyblock.menus;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import vk.com.korne3v.AsyncMenu.AsyncMenu;
import vk.com.korne3v.AsyncMenu.api.MenuAPI;
import vk.com.korne3v.AsyncMenu.menu.Menu;
import vk.com.korne3v.AsyncMenu.utils.ItemUtil;

public class TimesMenu {
	
public static void TimesOpen(Player p) {
		
		MenuAPI api = AsyncMenu.getApi();
		
		String day = ChatColor.translateAlternateColorCodes('&', "&e&l��&6&l��");
		String vosxod = ChatColor.translateAlternateColorCodes('&', "&e&l���&6&l���");
		String night = ChatColor.translateAlternateColorCodes('&', "&b&l��&9&l��");
		
		Menu categories = api.create(ChatColor.YELLOW + "��������� " + ChatColor.GOLD + "�������", 3)
                .setRemoveOnClose(true)
                
                .setItem(0, new ItemUtil(Material.WATCH).setNamed(vosxod).build(), (player, type) -> {
                	if(type == ClickType.LEFT)
                	{
                		p.setPlayerTime(1000, false);
                	}
                })
                
                .setItem(8, new ItemUtil(Material.WATCH).setNamed(day).build(), (player, type) -> {
                	if(type == ClickType.LEFT)
                	{
                		p.setPlayerTime(1200, false);
                	}
                })
                
                .setItem(22, new ItemUtil(Material.WATCH).setNamed(night).build(), (player, type) -> {
                	if(type == ClickType.LEFT)
                	{
                		p.setPlayerTime(1300, true);
                	}
                });
		
               

		categories.open(p);
		
	}

}
