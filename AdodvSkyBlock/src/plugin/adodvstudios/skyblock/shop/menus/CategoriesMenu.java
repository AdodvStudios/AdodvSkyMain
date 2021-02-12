package plugin.adodvstudios.skyblock.shop.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import plugin.adodvstudios.skyblock.shop.menus.categories.Pickaxes;
import plugin.adodvstudios.skyblock.shop.menus.categories.Sword;
import vk.com.korne3v.AsyncMenu.AsyncMenu;
import vk.com.korne3v.AsyncMenu.api.MenuAPI;
import vk.com.korne3v.AsyncMenu.menu.Menu;
import vk.com.korne3v.AsyncMenu.utils.ItemUtil;

public class CategoriesMenu {
	
	public static void EnchantementsShop(CommandSender sender, Player p) {
		
		String name = sender.getName();
		MenuAPI api = AsyncMenu.getApi();
		
		Menu categories = api.create(ChatColor.AQUA + "Магазин " + ChatColor.GOLD + ">> " + ChatColor.GREEN + "Categories", 1)
                .setRemoveOnClose(true)

                .setItem(0, new ItemUtil(Material.DIAMOND_PICKAXE, 1).setNamed("&b&lКирки").setLore("&cЛевый клик для просмотра категории").build(), (player, type) -> {

                    if (type == ClickType.LEFT) 
                    {
                    	Pickaxes.PickaxesShop(sender, p);
                    }
                        
                })
		
                
				.setItem(1, new ItemUtil(Material.DIAMOND_SWORD, 1).setNamed("&a&lМечи").setLore("&cЛевый клик для просмотра категории").build(), (player, type) -> {
					
					if(type == ClickType.LEFT)
					{
						Sword.SwordsShop(sender, p);
					}
					
				});
		
               

		categories.open(Bukkit.getPlayer(name));
		
	}

}
