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

public class Pickaxes {
	
	public static void PickaxesShop(CommandSender sender, Player p) {
		
		String name = sender.getName();
		MenuAPI api = AsyncMenu.getApi();
		
		Menu pic = api.create(ChatColor.AQUA + "�����", 2)
                .setRemoveOnClose(true)

                
                .setItem(2, new ItemUtil(Material.IRON_PICKAXE, 1).setNamed("&a&l����� �� �������� 2").setLore("&c���!").build(), (player, type) -> {
                	addItem.addItem1Enchant(p, Enchantment.DIG_SPEED, "�������� ������� 2, ����������� �� ��������", 65, Material.IRON_PICKAXE);
				})
                
                
				.setItem(3, new ItemUtil(Material.DIAMOND_PICKAXE, 1).setNamed("&a&l����� �� �������� 2").setLore("&c���!").build(), (player, type) -> {
					addItem.addItem1Enchant(p, Enchantment.DIG_SPEED, "�������� ������� 2, ����������� �� ��������", 108, Material.DIAMOND_PICKAXE);
					//
				})
				
				.setItem(4, new ItemUtil(Material.DIAMOND_PICKAXE, 1).setNamed("&a&l����� �� ظ������ ������� 2").setLore("&c���!").build(), (player, type) -> {
					addItem.addItem1Enchant(p, Enchantment.SILK_TOUCH, "Silk Touch 2, ����������� �� ��������", 135, Material.DIAMOND_PICKAXE);
				})
				
				.setItem(5, new ItemUtil(Material.DIAMOND_PICKAXE, 1).setNamed("&a&l����� �� ����� � �������� 2").setLore("&c���!").build(), (player, type) -> {
					addItem.addItem2Enchant(p, Enchantment.DIG_SPEED, Enchantment.LOOT_BONUS_BLOCKS, "�������� ������� 2, ����� 2, ����������� ������ �����", 150, Material.DIAMOND_PICKAXE);
				})
				
				.setItem(6, new ItemUtil(Material.DIAMOND_PICKAXE, 1).setNamed("&a&l����� �� �������� 2 � ������� 2").setLore("&c���!").build(), (player, type) -> {
					addItem.addItem2Enchant(p, Enchantment.DIG_SPEED, Enchantment.MENDING, "�������� ������� 2, ������� 2, ����������� ������ �����", 150, Material.DIAMOND_PICKAXE);
				})
				
				.setItem(13, new ItemUtil(Material.BARRIER, 1).setNamed("&4&l�����").setLore("&c���!").build(), (player, type) -> {
					CategoriesMenu.EnchantementsShop(sender, p);
				});
			
               

		pic.open(Bukkit.getPlayer(name));
		
	}

}
