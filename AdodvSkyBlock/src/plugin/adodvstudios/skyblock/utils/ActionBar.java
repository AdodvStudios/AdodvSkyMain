package plugin.adodvstudios.skyblock.utils;

import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_12_R1.PacketPlayOutChat;

public class ActionBar implements Listener {
	
	public PacketPlayOutChat packet;
	
	public ActionBar(String msg)
	{
		PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + msg + "\"}"));
		this.packet = packet;
	}
	
	public void send(Player p) {
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
	}

}
