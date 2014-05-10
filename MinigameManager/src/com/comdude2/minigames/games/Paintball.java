package com.comdude2.minigames.games;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.core.config.plugins.PluginManager;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.Blue;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.comdude2.minigame.main.Game;
import com.comdude2.minigame.main.Minigame;
import com.comdude2.minigame.managers.MinigameController;




public class Paintball extends Minigame implements Listener {

	private float damage = 5;
	private int gameid;
	private ScoreboardManager scoreboardManager;
	private static Scoreboard scoreboard;
	private Objective objective;
	private Score score;
	private MinigameController minicontroller;
	
	public enum Team {RED, BLUE};
	
	@SuppressWarnings("deprecation")
	public Paintball(MinigameController minicontroller) {
		this.minicontroller = minicontroller;
		
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
		boolean inArena = false;
		
		//Used to avoid null exception
		if(event.getPlayer().getItemInHand().getType() != Material.BOW || !inArena) {
			return;
		}
		
		if (minicontroller.getGameManager().playerInGame(event.getPlayer().getUniqueId())){
			Game game = minicontroller.getGameManager().getGame(event.getPlayer().getUniqueId());
			if (game != null){
				if (minicontroller.getArenaManager().getArena(game.getArenaID()).getMinigame().equals("PAINTBALL")){
					inArena = true;
				}
			}
		}
		
		if (inArena) {
			if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				if (event.getItem().getType().equals(Material.BOW)) {
					event.setCancelled(true);

					Player player = (Player) event.getPlayer();
					player.updateInventory();
					player.launchProjectile(Snowball.class);
					player.playSound(player.getLocation(), Sound.FIREWORK_TWINKLE2, 10F, 10F);
				}
			} else {
				return;
			}
		}
	}

	@EventHandler
	public void onSnowballHit(EntityDamageByEntityEvent event) {
		//CHECK IF PLAYER IS IN PAINTBALL ARENA - Done - com
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Player){
			Player player = (Player) event.getEntity();
			boolean inArena = false;
			if (minicontroller.getGameManager().playerInGame(player.getUniqueId())){
				Game game = minicontroller.getGameManager().getGame(player.getUniqueId());
				if (game != null){
					if (minicontroller.getArenaManager().getArena(game.getArenaID()).getMinigame().equals("PAINTBALL")){
						inArena = true;
					}
				}
			}
			if (inArena) {
				if (event.getDamager() instanceof Snowball) {
					player.damage(damage);
					((Player) event.getDamager()).playSound(player.getLocation(), Sound.ITEM_PICKUP, 10F, 10F);
					
					if(player.isDead()) {
						for(Player p : Bukkit.getOnlinePlayers()) {
							if (minicontroller.getGameManager().playerInGame(p.getUniqueId())){
								Game game = minicontroller.getGameManager().getGame(p.getUniqueId());
								if (game != null){
									if (minicontroller.getArenaManager().getArena(game.getArenaID()).getMinigame().equals("PAINTBALL")){
										p.sendMessage( ChatColor.GRAY + player.getName() + " was splatted in paint by " + ((Player) event.getDamager()).getName());
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		
		if(minicontroller.getGameManager().playerInGame(player.getUniqueId())) {
			Game game = minicontroller.getGameManager().getGame(player.getUniqueId());
			if(minicontroller.getArenaManager().getArena(game.getArenaID()).getMinigame().equals("PAINTBALL")) {
				event.setDeathMessage("");
			}
		}
	}
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		
		if (minicontroller.getGameManager().playerInGame(player.getUniqueId())){
			Game game = minicontroller.getGameManager().getGame(player.getUniqueId());
			if (game != null){
				if (minicontroller.getArenaManager().getArena(game.getArenaID()).getMinigame().equals("PAINTBALL")){
					//TODO: RESPAWN AT TEAMS BASE
				}
			}
		}
	}
}
