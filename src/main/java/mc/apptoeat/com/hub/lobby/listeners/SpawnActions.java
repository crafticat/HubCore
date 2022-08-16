package mc.apptoeat.com.hub.lobby.listeners;

import lombok.Getter;
import mc.apptoeat.com.hub.lobby.management.HubManagement;
import mc.apptoeat.com.hub.lobby.management.SpawnItemsManager;
import mc.apptoeat.com.hub.utils.config.FileManager;
import mc.apptoeat.com.hub.utils.message.Color;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SpawnActions implements Listener {

    private List<String> joinMessages;
    private Location spawnLocation;

    public SpawnActions() {
        ArrayList<String> joinMessages = new ArrayList<>();
        joinMessages.add("Welecome to apptoeat");
        this.joinMessages = FileManager.getOrDefault(HubManagement.getInstance().getConfigManager().getMessageConfig(), "joinMessages",joinMessages);
        spawnLocation = FileManager.getOrDefault(HubManagement.getInstance().getConfigManager().getMessageConfig(), "spawnLocation",new Location(Bukkit.getWorld("world"),0,100,0));
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        player.teleport(spawnLocation);
        SpawnItemsManager spawnItemsManager = HubManagement.getInstance().getSpawnItemsManager();
        player.setHealth(player.getMaxHealth());
        player.setFoodLevel(20);
        spawnItemsManager.getList().forEach(item -> {
            player.getInventory().setItem(item.getSlot(),item.getItem());
        });

        joinMessages.forEach(s -> {
            player.sendMessage(Color.code(s));
        });
    }

    public void updateSpawn(Location updated) {
        spawnLocation = updated;
        FileManager.update(HubManagement.getInstance().getConfigManager().getMessageConfig(), "spawnLocation",updated);
    }
}
