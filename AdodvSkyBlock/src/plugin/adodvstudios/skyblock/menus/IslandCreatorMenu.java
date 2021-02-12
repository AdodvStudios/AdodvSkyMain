package plugin.adodvstudios.skyblock.menus;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import plugin.adodvstudios.skyblock.utils.Config;
import plugin.adodvstudios.skyblock.utils.IslandCreate;
import vk.com.korne3v.AsyncMenu.AsyncMenu;
import vk.com.korne3v.AsyncMenu.api.MenuAPI;
import vk.com.korne3v.AsyncMenu.menu.Menu;
import vk.com.korne3v.AsyncMenu.utils.ItemUtil;

public class IslandCreatorMenu {
	
	@SuppressWarnings("deprecation")
	public static void open(Player p)
	{
		ItemStack IslandDefault = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta IslandMeta = (SkullMeta) IslandDefault.getItemMeta();
		IslandMeta.setOwner("WilleHe");
	    IslandDefault.setItemMeta(IslandMeta);
	    
	    ItemStack IslandVip = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta VipMeta = (SkullMeta) IslandVip.getItemMeta();
		VipMeta.setOwner("WomboComboOnTop");
	    IslandVip.setItemMeta(VipMeta);
	    
	    ItemStack IslandSanta = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
	    SkullMeta SantaMeta = (SkullMeta) IslandSanta.getItemMeta();
	    SantaMeta.setOwner("iwth");
	    IslandSanta.setItemMeta(SantaMeta);
	    
	    ItemStack IslandCub = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
	    SkullMeta CubMeta = (SkullMeta) IslandCub.getItemMeta();
	    CubMeta.setOwner("AndesterYT");
	    IslandCub.setItemMeta(CubMeta);
		
		MenuAPI menu = AsyncMenu.getApi();
		
		ArrayList<String> loreDefault = new ArrayList<String>();
		ArrayList<String> loreVip = new ArrayList<String>();
		ArrayList<String> loreSanta = new ArrayList<String>();
		ArrayList<String> loreCub = new ArrayList<String>();
		
		String Default = ChatColor.translateAlternateColorCodes('&', "&d&lОбычный &5&lостров");
		String Vip = ChatColor.translateAlternateColorCodes('&', "&e&lVIP &6&lостров");
		String Santa = ChatColor.translateAlternateColorCodes('&', "&c&lОстров &4&lсанты");
		String Cub = ChatColor.translateAlternateColorCodes('&', "&b&lОстров &9&l'куба'");
		
		String help = ChatColor.translateAlternateColorCodes('&', Config.prefix + "&a&lОстров построен! &c&lДля помощи &6&l/ais help");
		
		Menu IslandCreator = menu.create(ChatColor.translateAlternateColorCodes('&', "&e&lСоздать &6&lостров"), 1)
		.setItem(0, new ItemUtil(IslandDefault).setNamed(Default).setLore(loreDefault).build(), (player, type) -> {
			if(type == ClickType.LEFT)
			{
				IslandCreate.defaultIsland(p);
				p.sendMessage(help);
			}
		})
		.setItem(1, new ItemUtil(IslandVip).setNamed(Vip).setLore(loreVip).build(), (player, type) -> {
			if(type == ClickType.LEFT)
			{
				IslandCreate.vipIsland(p);
				p.sendMessage(help);
			}
		})
		.setItem(2, new ItemUtil(IslandSanta).setNamed(Santa).setLore(loreSanta).build(), (player, type) -> {
			if(type == ClickType.LEFT)
			{
				IslandCreate.santaIsland(p);
				p.sendMessage(help);
			}
		})
		.setItem(3, new ItemUtil(IslandCub).setNamed(Cub).setLore(loreCub).build(), (player, type) -> {
			if(type == ClickType.LEFT)
			{
				IslandCreate.cubIsland(p);
				p.sendMessage(help);
			}
		});
		
		IslandCreator.open(p);
		
		
	}

}
