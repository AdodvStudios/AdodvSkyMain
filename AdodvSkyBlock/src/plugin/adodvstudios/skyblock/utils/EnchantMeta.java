package plugin.adodvstudios.skyblock.utils;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EnchantMeta implements Listener {
	
	public static void addMeta(ItemStack stack, String material) {
		
		ItemMeta meta = stack.getItemMeta();
		
		ArrayList<String> lore = new ArrayList<String>();
	    lore.add(ChatColor.translateAlternateColorCodes('&', "&7&l" + material + " &f&l1 уровень"));
	    
	    meta.setLore(lore);
	    meta.addEnchant(Enchantment.DURABILITY, 1, true);
	    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    stack.setItemMeta(meta);
	}

}
