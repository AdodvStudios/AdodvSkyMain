package plugin.adodvstudios.skyblock.shop.menus.categories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import plugin.adodvstudios.skyblock.shop.menus.CategoriesMenu;
import plugin.adodvstudios.skyblock.shop.addItem;
import vk.com.korne3v.AsyncMenu.AsyncMenu;
import vk.com.korne3v.AsyncMenu.api.MenuAPI;
import vk.com.korne3v.AsyncMenu.menu.Menu;
import vk.com.korne3v.AsyncMenu.utils.ItemUtil;

public class Sword {
	
	public static void SwordsShop(CommandSender sender, Player p) {
		
		String name = sender.getName();
		MenuAPI api = AsyncMenu.getApi();
		
		Menu armor = api.create(ChatColor.AQUA + "Ìå÷è", 2)
                .setRemoveOnClose(true)

                
                .setItem(2, new ItemUtil(Material.IRON_SWORD, 1).setNamed("&a&lÌå÷ íà Îãîíü 2").setLore("&cËÊÌ!").build(), (player, type) -> {
                	addItem.addItem1Enchant(p, Enchantment.FIRE_ASPECT, "Fire Aspect 2, Shop Enchant", 30, Material.IRON_SWORD);
				})
                
                
				.setItem(3, new ItemUtil(Material.IRON_SWORD, 1).setNamed("&a&lÌå÷ íà ïðî÷íîñòü 2").setLore("&cËÊÌ!").build(), (player, type) -> {
					addItem.addItem1Enchant(p, Enchantment.DIG_SPEED, "Durability 2, Shop Enchant", 25, Material.IRON_SWORD);
				})
				
				.setItem(4, new ItemUtil(Material.DIAMOND_SWORD, 1).setNamed("&a&lÌå÷ íà Îãîíü 2 è Äîáû÷ó 2").setLore("&cËÊÌ!").build(), (player, type) -> {
					addItem.addItem2Enchant(p, Enchantment.LOOT_BONUS_MOBS, Enchantment.FIRE_ASPECT, "Loot Bonus Mobs 2, Fire Aspect 2, Special Shop Edition", 75, Material.DIAMOND_SWORD);
				})
				
				.setItem(5, new ItemUtil(Material.DIAMOND_SWORD, 1).setNamed("&a&lÌå÷ íà Îãîíü 2 è Îòäà÷ó 2").setLore("&cËÊÌ!").build(), (player, type) -> {
					addItem.addItem2Enchant(p, Enchantment.KNOCKBACK, Enchantment.FIRE_ASPECT, "Fire Aspect 2, Knockback 2, Special Shop Edition", 75, Material.DIAMOND_SWORD);
				})
				
				.setItem(13, new ItemUtil(Material.BARRIER, 1).setNamed("&4&lÂÛÕÎÄ").setLore("&cËÊÌ!").build(), (player, type) -> {
					CategoriesMenu.EnchantementsShop(sender, p);
				});
			
               

		armor.open(Bukkit.getPlayer(name));
		
	}

}
