package plugin.adodvstudios.skyblock.utils.boss;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import plugin.adodvstudios.skyblock.utils.Config;

public class ZombieLevel1 extends Boss implements Listener {
	
	public static ArrayList<Player> killsThisMob = new ArrayList<Player>();
	
	public static ItemStack drop = new ItemStack(Material.EMERALD, 2);
	public static ItemStack reward = new ItemStack(Material.EMERALD, 3);
	
	static int x = Config.FromBossX();
	static int y = Config.FromBossY();
	static int z = Config.FromBossZ();
	
	public static Location boss = new Location(Bukkit.getWorld("world"), x, y, z);
	
	public static void spawn()
	{
		MaxHealth = 140;
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stoplag -c");
		Zombie z = (Zombie)Bukkit.getWorld("duels02").spawnEntity(boss, EntityType.ZOMBIE);
		setArmor(z, "Varvar050", Material.IRON_SWORD, Color.OLIVE);
		SetConfigurations(z);
		z.setCustomName(ChatColor.translateAlternateColorCodes('&', "&a&lЗомби &7&lУровень &2&l1 &4&lHP:&c&l" + MaxHealth+"&7&l/&a&l"+MaxHealth));
	}

	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDamageZombie(EntityDamageByEntityEvent e)
	{
		Entity damager = e.getEntity();
		if(damager instanceof Zombie)
		{
			if(((Zombie) damager).getMaxHealth() == MaxHealth)
			{
				Location p = new Location(damager.getWorld(), boss.getBlockX(), boss.getBlockY()+1, boss.getBlockZ());
				damager.getWorld().spawnParticle(Particle.CRIT_MAGIC, p, 20);
				int hp = (int) ((Zombie) damager).getHealth();
				damager.setCustomName(ChatColor.translateAlternateColorCodes('&', "&a&lЗомби &7&lУровень &2&l1 &4&lHP:&c&l" + hp+"&7&l/&a&l"+MaxHealth));
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onGetDrop(EntityDeathEvent e)
	{
		Entity P = e.getEntity();
		Location loc = P.getLocation();
		if(P instanceof Zombie)
		{
			if(((Zombie) P).getMaxHealth() == MaxHealth)
			{
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stoplag");
				loc.add(0.6, 0.6, 0.6).getWorld().dropItemNaturally(loc, drop);
				for(Player players : killsThisMob) {
					players.sendTitle(ChatColor.GREEN + "Вы убили босса!", ChatColor.RED + "+" + ChatColor.GOLD + "3" + ChatColor.GREEN + "" + ChatColor.BOLD + "Изумруда");
					players.getInventory().addItem(reward);
					killsThisMob.add(players);
				}
			}
		}
	}
	

}
