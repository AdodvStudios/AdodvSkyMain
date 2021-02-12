package plugin.adodvstudios.skyblock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import plugin.adodvstudios.skyblock.utils.Config;

public class ScoreBoard implements Listener {
	
	
	public static void MainSB(Player p)
	{
		ScoreboardManager sbM = Bukkit.getScoreboardManager();
		Scoreboard sbMain = sbM.getNewScoreboard();
		
		Objective o = sbMain.registerNewObjective("Main", "");
		
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName(ChatColor.translateAlternateColorCodes('&', Config.FromSBName()));
		
		String line1 = ChatColor.translateAlternateColorCodes('&', Config.FromLine1());
		String line2 = ChatColor.translateAlternateColorCodes('&', Config.FromLine2());
		String line3 = ChatColor.translateAlternateColorCodes('&', Config.FromLine3());
		String line4 = ChatColor.translateAlternateColorCodes('&', Config.FromLine4().replace("#player#", p.getName()));
		String line5 = ChatColor.translateAlternateColorCodes('&', Config.FromLine5().replace("#kills_mobs#", String.valueOf(p.getStatistic(Statistic.MOB_KILLS))));
		String Null = "";
		String line6 = ChatColor.translateAlternateColorCodes('&', Config.FromLine6().replace("#online_players#", String.valueOf(Bukkit.getOnlinePlayers().size())));
		String line7 = ChatColor.translateAlternateColorCodes('&', Config.FromLine7());
		
		Score Score1 = o.getScore(line1);
		Score1.setScore(8);
		Score Score2 = o.getScore(line2);
		Score2.setScore(7);
		Score Score3 = o.getScore(line3);
		Score3.setScore(6);
		Score Score4 = o.getScore(line4);
		Score4.setScore(5);
		Score Score5 = o.getScore(line5);
		Score5.setScore(4);
		Score NullScore = o.getScore(Null);
		NullScore.setScore(3);
		Score Score6 = o.getScore(line6);
		Score6.setScore(2);
		Score Score7 = o.getScore(line7);
		Score7.setScore(1);
		
		p.setScoreboard(sbMain);
	}
	
	@EventHandler
	public void onJoinScoreboard(PlayerJoinEvent e)
	{
		Player p = e.getPlayer();
		MainSB(p);
	}

}
