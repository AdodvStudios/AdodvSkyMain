package plugin.adodvstudios.skyblock.menus;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import vk.com.korne3v.AsyncMenu.AsyncMenu;
import vk.com.korne3v.AsyncMenu.api.MenuAPI;
import vk.com.korne3v.AsyncMenu.menu.Menu;
import vk.com.korne3v.AsyncMenu.utils.ItemUtil;

public class SettingsMenu {
	
	public static void SettingsOpen(Player p) {
		
		MenuAPI api = AsyncMenu.getApi();
		
		String time = ChatColor.translateAlternateColorCodes('&', "&e&lСмена &6&lвремени");
		String weather = ChatColor.translateAlternateColorCodes('&', "&e&lСмена &6&lпогоды");
		
		Menu categories = api.create("Настройки", 1)
                .setRemoveOnClose(true)
                
                .setItem(3, new ItemUtil(Material.WATCH).setNamed(time).build(), (player, type) -> {
                	if(type == ClickType.LEFT)
                	{
                		TimesMenu.TimesOpen(p);
                	}
                })
                .setItem(5, new ItemUtil(Material.WATCH).setNamed(weather).build(), (player, type) -> {
                	if(type == ClickType.LEFT)
                	{
                		WeatherMenu.SettingsOpen(p);
                	}
                });
		
               

		categories.open(p);
		
	}

}
