package plugin.adodvstudios.skyblock.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import plugin.adodvstudios.skyblock.Main;
import plugin.adodvstudios.skyblock.shop.menus.CategoriesMenu;
import plugin.adodvstudios.skyblock.utils.IslandCreate;
import vk.com.korne3v.AsyncMenu.AsyncMenu;
import vk.com.korne3v.AsyncMenu.api.MenuAPI;
import vk.com.korne3v.AsyncMenu.menu.Menu;
import vk.com.korne3v.AsyncMenu.utils.ItemUtil;

public class MainMenu {
	
	public static int color = 1;
	
	public static MenuAPI menu = AsyncMenu.getApi();
	public static Menu MainMenu = menu.create(ChatColor.YELLOW + "Главное " + ChatColor.GOLD + "меню", 3);
	
	public static void open(Player p)
	{
		InitComponents(MainMenu);
		glass(MainMenu, p);
		
		MainMenu.open(p);
	}
	
	public static void glass(Menu menu, Player p)
	{
		Main plugin = (Main)Main.getPlugin(Main.class);
		
		menu.setItem(0, new ItemUtil(Material.STAINED_GLASS_PANE, 1, (short)color).build(), (player, type) -> {
			
		});
		
		menu.setItem(4, new ItemUtil(Material.STAINED_GLASS_PANE, 1, (short)color).build(), (player, type) -> {
			
		});
		
		menu.setItem(8, new ItemUtil(Material.STAINED_GLASS_PANE, 1, (short)color).build(), (player, type) -> {
			
		});
		
		menu.setItem(18, new ItemUtil(Material.STAINED_GLASS_PANE, 1, (short)color).build(), (player, type) -> {
			
		});
		
		menu.setItem(22, new ItemUtil(Material.STAINED_GLASS_PANE, 1, (short)color).build(), (player, type) -> {
			
		});
		
		menu.setItem(26, new ItemUtil(Material.STAINED_GLASS_PANE, 1, (short)color).build(), (player, type) -> {
			
		});
		
	}
	
	public static void InitComponents(Menu menu)
	{
		String createIsland = ChatColor.translateAlternateColorCodes('&', "&a&lСоздать &2&lОстров");
		String TPIsland = ChatColor.translateAlternateColorCodes('&', "&e&lТелепортироваться &6&lна остров");
		String bosses = ChatColor.translateAlternateColorCodes('&', "&e&lБос&6&lсы");
		String settings = ChatColor.translateAlternateColorCodes('&', "&a&lНаст&2&lройки");
		String shop = ChatColor.translateAlternateColorCodes('&', "&c&lМага&4&lзин");
		menu.setItem(11, new ItemUtil(Material.GRASS, 1).setNamed(createIsland).build(), (player, type) -> {
			if(type == ClickType.LEFT)
			{
				IslandCreatorMenu.open(player);
			}
		});
		menu.setItem(12, new ItemUtil(Material.EMERALD, 1).setNamed(TPIsland).build(), (player, type) -> {
			if(type == ClickType.LEFT)
			{
				player.teleport(new Location(Bukkit.getWorld("islands"), IslandCreate.islandX, IslandCreate.islandY, IslandCreate.islandZ));
			}
		});
		menu.setItem(13, new ItemUtil(Material.PUMPKIN, 1).setNamed(bosses).build(), (player, type) -> {
			if(type == ClickType.LEFT)
			{
				BossesMenu.open(player);
			}
		});
		menu.setItem(14, new ItemUtil(Material.WATCH, 1).setNamed(settings).build(), (player, type) -> {
			if(type == ClickType.LEFT)
			{
				SettingsMenu.SettingsOpen(player);
			}
		});
		menu.setItem(15, new ItemUtil(Material.DIAMOND, 1).setNamed(shop).build(), (player, type) -> {
			if(type == ClickType.LEFT)
			{
				CategoriesMenu.EnchantementsShop(player, player);
			}
		});
	}

}
