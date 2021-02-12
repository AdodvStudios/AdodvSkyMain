package plugin.adodvstudios.skyblock.utils.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatMain implements Listener {
	
	@EventHandler
	public void onGlobalChat(AsyncPlayerChatEvent e)
	{
		String msg = e.getMessage();
		if(msg.contains("!") == true)
		{
			e.setMessage(ChatColor.translateAlternateColorCodes('&', "&7&l(&6&lG&7&l) &b&l" + msg).replace("!", ""));
		}
		else {
			e.setMessage(ChatColor.translateAlternateColorCodes('&', "&7&l(&b&lL&7&l) &b&l" + msg));
		}
		//e.setFormat(ChatColor.translateAlternateColorCodes('&', "&7&l(&6&lG&7&l) " + msg).replace("!", ""));
	}

}
