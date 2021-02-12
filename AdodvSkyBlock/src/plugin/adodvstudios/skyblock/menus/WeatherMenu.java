package plugin.adodvstudios.skyblock.menus;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import vk.com.korne3v.AsyncMenu.AsyncMenu;
import vk.com.korne3v.AsyncMenu.api.MenuAPI;
import vk.com.korne3v.AsyncMenu.menu.Menu;
import vk.com.korne3v.AsyncMenu.utils.ItemUtil;

public class WeatherMenu {

	public static void SettingsOpen(Player p) {
		
		MenuAPI api = AsyncMenu.getApi();
		
		String weather = ChatColor.translateAlternateColorCodes('&', "&a&lСмена &2&lпогоды");
		
		Menu categories = api.create(weather, 1)
                .setRemoveOnClose(true)
                
                .setItem(3, new ItemUtil(Material.WATCH).setNamed(ChatColor.RED + "Убрать всё!").build(), (player, type) -> {
                	if(type == ClickType.LEFT)
                	{
                		p.setPlayerWeather(WeatherType.CLEAR);
                	}
                })
                .setItem(4, new ItemUtil(Material.WATCH).setNamed(ChatColor.RED + "Рандом").build(), (player, type) -> {
                	if(type == ClickType.LEFT)
                	{
                		p.setPlayerWeather(WeatherType.DOWNFALL);
                	}
                });
		
		

		categories.open(p);
		
	}
	
}
