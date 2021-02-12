package plugin.adodvstudios.skyblock.utils.boss;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Boss {
	
	static int MaxHealth;
	
	@SuppressWarnings("deprecation")
	static void SetConfigurations(Zombie z)
	{
		z.setMaxHealth(MaxHealth);
		z.setHealth(MaxHealth);
		z.setCanPickupItems(false);
		z.setBaby(false);
		z.setCustomName(ChatColor.translateAlternateColorCodes('&', "&e&lЧучело &7&lУровень &2&l2 &4&lHP:&c&l" + getHp(z)+"&7&l/&a&l"+MaxHealth));
	}
	
	@SuppressWarnings("deprecation")
	static void setArmor(Zombie z, String headName, Material sword, Color c)
	{
		ItemStack Head = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta HeadMeta = (SkullMeta) Head.getItemMeta();
		HeadMeta.setOwner(headName);
		Head.setItemMeta(HeadMeta);
		
		ItemStack AmongVictim = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta AVMeta = (SkullMeta) AmongVictim.getItemMeta();
		AVMeta.setOwner("0AmongUs_XW_JIA0");
		AmongVictim.setItemMeta(AVMeta);
		
		ItemStack Sword = new ItemStack(sword);
		
	    ItemStack chestPlate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta cMeta = (LeatherArmorMeta)chestPlate.getItemMeta();
		cMeta.setColor(c);
		chestPlate.setItemMeta(cMeta);
		
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta lMeta = (LeatherArmorMeta)leggings.getItemMeta();
		lMeta.setColor(c);
		leggings.setItemMeta(lMeta);
		
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta bMeta = (LeatherArmorMeta)boots.getItemMeta();
		bMeta.setColor(c);
		boots.setItemMeta(bMeta);
		
		EntityEquipment Equipment = z.getEquipment();
		Equipment.setItemInMainHand(Sword);
		Equipment.setItemInOffHand(AmongVictim);
		Equipment.setHelmet(Head);
		Equipment.setChestplate(chestPlate);
		Equipment.setLeggings(leggings);
		Equipment.setBoots(boots);
	}
	
	static int getHp(Zombie z)
	{
		return (int) z.getHealth();
	}

}
