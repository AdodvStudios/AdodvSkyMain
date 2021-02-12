package plugin.adodvstudios.skyblock.core;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import plugin.adodvstudios.skyblock.utils.EnchantMeta;

public class EnchantBlocks implements Listener {
	
	public static ItemStack cobblestone = new ItemStack(Material.COBBLESTONE);
	public static ItemStack stone = new ItemStack(Material.STONE);
	public static ItemStack ironOre = new ItemStack(Material.IRON_ORE);
	
	@EventHandler
	public void enchant(BlockBreakEvent e)
	{
		
		EnchantMeta.addMeta(cobblestone, "&7&lБулыжнык");
		EnchantMeta.addMeta(stone, "&8&lКамень");
		EnchantMeta.addMeta(ironOre, "&e&lЖелезо");
		Block b = e.getBlock();
		
		if (b.getType() == Material.COBBLESTONE) {
            b.setType(Material.AIR);
            b.getLocation().add(0.5, 0.5, 0.5).getWorld().dropItemNaturally(e.getBlock().getLocation(), cobblestone);
        }
		
		if (b.getType() == Material.STONE) {
            b.setType(Material.AIR);
            b.getLocation().add(0.5, 0.5, 0.5).getWorld().dropItemNaturally(e.getBlock().getLocation(), stone);
        }
        
		
		if (b.getType() == Material.IRON_ORE) {
            b.setType(Material.AIR);
            b.getLocation().add(0.5, 0.5, 0.5).getWorld().dropItemNaturally(e.getBlock().getLocation(), ironOre);
        }
		
		if (b.getType() == Material.COAL_ORE) {
            b.setType(Material.AIR);
            b.getLocation().add(0.5, 0.5, 0.5).getWorld().dropItemNaturally(e.getBlock().getLocation(), ironOre);
        }
	}
	
	
}
