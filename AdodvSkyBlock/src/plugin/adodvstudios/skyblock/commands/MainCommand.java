package plugin.adodvstudios.skyblock.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.CraftServer;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.NPC;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.mojang.authlib.GameProfile;

import net.minecraft.server.v1_12_R1.EntityPlayer;
import net.minecraft.server.v1_12_R1.MinecraftServer;
import net.minecraft.server.v1_12_R1.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_12_R1.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_12_R1.PlayerConnection;
import net.minecraft.server.v1_12_R1.PlayerInteractManager;
import net.minecraft.server.v1_12_R1.WorldServer;
import plugin.adodvstudios.skyblock.Main;
import plugin.adodvstudios.skyblock.menus.BossesMenu;
import plugin.adodvstudios.skyblock.menus.MainMenu;
import plugin.adodvstudios.skyblock.menus.SettingsMenu;
import plugin.adodvstudios.skyblock.shop.menus.CategoriesMenu;
import plugin.adodvstudios.skyblock.systems.Taxi;
import plugin.adodvstudios.skyblock.utils.Config;
import plugin.adodvstudios.skyblock.utils.IslandCreate;

public class MainCommand implements CommandExecutor, Listener {

	private static Main plugin = Main.getPlugin(Main.class);
	
	public static void npc(Player p, String nameNpc)
	{
		Location l = p.getLocation();
		MinecraftServer nms = ((CraftServer)Bukkit.getServer()).getServer();
		WorldServer world = ((CraftWorld)p.getWorld()).getHandle();
		GameProfile gP = new GameProfile(UUID.randomUUID(), nameNpc);
		
		EntityPlayer npc = new EntityPlayer(nms, world, gP, new PlayerInteractManager(world));
		Player npcP = npc.getBukkitEntity().getPlayer();
		npc.setLocation(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getPitch());
		
		PlayerConnection connect = ((CraftPlayer) p).getHandle().playerConnection;
		connect.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
		connect.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		Player p = Bukkit.getPlayer(sender.getName());
		
		if(args.length == 0)
		{
			MainMenu.open(p);
			return true;
		}
		
		if(p instanceof Player)
		{
			
			if(args[0].equalsIgnoreCase("help"))
			{
				String help1 = ChatColor.translateAlternateColorCodes('&', "&7&lГлавная валюта сервера: &a&lИзумруды");
				String help2 = ChatColor.translateAlternateColorCodes('&', "&7&lОсновная команд: &a&l/ais");
				String help3 = ChatColor.translateAlternateColorCodes('&', "&7&lЗайти в магазин &a&l/warp shop");
				String help4 = ChatColor.translateAlternateColorCodes('&', "&7&lНастройки острова: &a&l/ais settings");
				p.sendMessage(Config.prefix + help1);
				p.sendMessage(help2);
				p.sendMessage(help3);
				p.sendMessage(help4);
			}
			
			if(args[0].equalsIgnoreCase("settings"))
			{
				SettingsMenu.SettingsOpen(p);
				return true;
			}
			
			if(args[0].equalsIgnoreCase("bosses"))
			{
				BossesMenu.open(p);
				return true;
				//ZombieLevel1.spawn();
				//PumpkinScarecrow.spawn();
			}
			
			
			if(args[0].equalsIgnoreCase("visit"))
			{
				if(args[1] == null)
				{
					p.sendMessage(Config.prefix + ChatColor.RED + "Введите имя игрока!!");
					return true;
				}
				
				Player pVisit = Bukkit.getPlayer(args[1]);
				p.teleport(IslandCreate.players.get(pVisit));
				return true;
			}
			
			if(args[0].equalsIgnoreCase("taxi"))
			{
				Taxi.openMenu(p);
				return true;
			}
			
			if(args[0].equalsIgnoreCase("msg"))
			{
				if(args[1] == null)
				{
					p.sendMessage(Config.prefix + ChatColor.RED + "Введите имя!");
					return true;
				}
				if(p.getName().equalsIgnoreCase(args[1]))
				{
					p.sendMessage(Config.prefix + ChatColor.RED + "Ты чё, сам себе сообщение хочешь отправить?");
					return true;
				}
				Player msgTarget = Bukkit.getPlayer(args[1]);
				if(msgTarget == null || !msgTarget.isOnline())
				{
					p.sendMessage(Config.prefix + ChatColor.RED + "Игрок не найден!");
					return true;
				}
				String msg = args[2];
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&l<&6&l✉&7&l> &eВы -> &b" + msgTarget.getName() + "&6&l -> " + msg));
				msgTarget.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&l<&d&l✉&7&l> &eВам пришло письмо от: &b" + p.getName() + "&6&l " + msg));
				return true;
			}
			
			
			if(args[0].equalsIgnoreCase("reloadconfig"))
			{
				if(!p.hasPermission("adodvskyblock.admin"))
				{
					p.sendMessage(ChatColor.DARK_RED + "Нету прав!");
					return true;
				}
				if(p.hasPermission("adodvskyblock.admin"))
				{
					p.sendMessage(ChatColor.GREEN + "Перезагруженно!");
					plugin.reloadConfig();
					plugin.saveConfig();
					return true;
				}
			}
			
			if(args[0].equalsIgnoreCase("shop"))
			{
				CategoriesMenu.EnchantementsShop(sender, p);
				return true;
			}
			
			return true;
		}
		
		return false;
	}
	
	
	

}
