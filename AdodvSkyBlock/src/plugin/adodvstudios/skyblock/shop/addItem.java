package plugin.adodvstudios.skyblock.shop;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import plugin.adodvstudios.skyblock.utils.Coins;

public class addItem {
	
	
	public static void addItem1Enchant(Player p, Enchantment ench, String lor, int price, Material matSell) {
		if(Coins.getCoins(p.getInventory(), Material.EMERALD) < price)
    	{
    		p.sendMessage(ChatColor.DARK_RED + "Не хватает монет!");
    	}
    	
    	if(Coins.getCoins(p.getInventory(), Material.EMERALD) >= price)
    	{
    		ItemStack c = new ItemStack(Material.EMERALD, price);
    		p.getInventory().removeItem(c);
    		
    		
    		List<String> lore = new ArrayList<>();
    		
    		ItemStack pickaxeLuck2 = new ItemStack(matSell);
    		ItemMeta pLuck2Meta = pickaxeLuck2.getItemMeta();
    		//pLuck2Meta.addEnchant(Enchantment.DIG_SPEED, 2, true);
    		pLuck2Meta.addEnchant(ench, 2, true);
    		lore.add(ChatColor.AQUA + "Чары: ");
    		lore.add(ChatColor.WHITE + "...");
    		lore.add(ChatColor.GREEN + "   " + lor);
    		lore.add(ChatColor.WHITE + "...");
    		pLuck2Meta.setLore(lore);
    		pickaxeLuck2.setItemMeta(pLuck2Meta);
    		
    		p.sendMessage(ChatColor.GREEN + "Предмет куплен!");
    		Inventory invP = p.getInventory();
    		invP.addItem(pickaxeLuck2);
    	}
	}
	
	public static void addItem2Enchant(Player p, Enchantment ench, Enchantment ench2, String lor, int price, Material matSell) {
		if(Coins.getCoins(p.getInventory(), Material.EMERALD) < price)
    	{
    		p.sendMessage(ChatColor.DARK_RED + "Не хватает монет!");
    	}
    	
    	if(Coins.getCoins(p.getInventory(), Material.EMERALD) >= price)
    	{
    		ItemStack c = new ItemStack(Material.EMERALD, price);
    		p.getInventory().removeItem(c);
    		
    		
    		List<String> lore = new ArrayList<>();
    		
    		ItemStack pickaxeLuck2 = new ItemStack(matSell);
    		ItemMeta pLuck2Meta = pickaxeLuck2.getItemMeta();
    		//pLuck2Meta.addEnchant(Enchantment.DIG_SPEED, 2, true);
    		pLuck2Meta.addEnchant(ench, 2, true);
    		pLuck2Meta.addEnchant(ench2, 2, true);
    		lore.add(ChatColor.AQUA + "Чары: ");
    		lore.add(ChatColor.WHITE + "...");
    		lore.add(ChatColor.GREEN + "   " + lor);
    		lore.add(ChatColor.WHITE + "...");
    		pLuck2Meta.setLore(lore);
    		pickaxeLuck2.setItemMeta(pLuck2Meta);
    		
    		p.sendMessage(ChatColor.GREEN + "Предмет куплен!");
    		Inventory invP = p.getInventory();
    		invP.addItem(pickaxeLuck2);
    	}
	}

}
