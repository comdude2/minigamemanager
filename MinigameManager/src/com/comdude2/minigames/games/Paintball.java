package com.comdude2.minigames.games;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import com.comdude2.minigame.main.Minigame;




public class Paintball extends Minigame implements Listener {

	private float damage = 5;
	
	private ScoreboardManager scoreboardManager;
	private static Scoreboard scoreboard;
	private Objective objective;
	private Score score;
	
	@SuppressWarnings("deprecation")
	public Paintball() {
		scoreboardManager = Bukkit.getScoreboardManager();
		scoreboard = scoreboardManager.getNewScoreboard();
		objective = scoreboard.registerNewObjective("Your Kills", "mobkills");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName("Paintball");
		Score score = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Your Kills:"));
	}

	public static void setupPlayer(Player player) {
		Inventory inventory = player.getInventory();
		inventory.clear();

		ItemStack bowStack = new ItemStack(Material.BOW);
		ItemMeta bowMeta = bowStack.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.BLUE + "Right-Click To Shoot");
		bowMeta.setDisplayName(ChatColor.GREEN + "Paintball Gun");
		bowMeta.setLore(lore);
		bowStack.setItemMeta(bowMeta);
		
		inventory.addItem(bowStack);
		
		player.setScoreboard(scoreboard);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSnowballThrown(PlayerInteractEvent event) {
		//CHECK IF PLAYER IS IN PAINTBALL ARENA
		if (true) {
			if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				if (event.getItem().getType().equals(Material.BOW)) {
					event.setCancelled(true);

					Player player = (Player) event.getPlayer();
					player.updateInventory();
					player.launchProjectile(Snowball.class);
					player.playSound(player.getLocation(), Sound.FIREWORK_TWINKLE2, 10F, 10F);
				}
			}
		}
	}

	@EventHandler
	public void onSnowballHit(EntityDamageByEntityEvent event) {
		//CHECK IF PLAYER IS IN PAINTBALL ARENA
		if (true) {
			if (event.getDamager() instanceof Snowball) {
				Player player = (Player) event.getEntity();
				player.damage(damage);
			}
		}
	}
}
