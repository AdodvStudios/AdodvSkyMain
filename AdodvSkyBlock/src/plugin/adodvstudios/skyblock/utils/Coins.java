package plugin.adodvstudios.skyblock.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Coins implements Listener {
	
	public static int getCoins(Inventory inventory, Material type) {
		int coins = 0;
        for (ItemStack stack : inventory.getContents()) {
            if (stack == null)
                continue;
            if (stack.getType() == type)
                coins += stack.getAmount();
        }
        //Bukkit.getLogger().info(String.valueOf(coins));
    	
        return coins;
    }
	
	@EventHandler
	public void onSaveFile(PlayerJoinEvent e) throws IOException {
		Player p = e.getPlayer();
		
		String path = "plugins/AdodvSkyBlock/coins.txt";
		
		String text = "\n"+p.getName()+";"+getCoins(p.getInventory(), Material.EMERALD)+";";
		
        File file = new File(path);
        FileWriter fr = null;
            fr = new FileWriter(file,true);
            fr.write(text);
           
            fr.close();
    }

}
