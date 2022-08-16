package mc.apptoeat.com.hub.utils.blocker;

import mc.apptoeat.com.hub.HubCoreAPI;
import mc.apptoeat.com.hub.lobby.management.HubManagement;
import mc.apptoeat.com.hub.utils.config.FileManager;
import mc.apptoeat.com.hub.utils.message.Color;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Blocker implements Listener {

    private String message;

    public Blocker(String message) {
        this.message = Color.code(message);
        Bukkit.getServer().getPluginManager().registerEvents(this, HubCoreAPI.getInstance());
    }

    public void allowConfig(String path) {
        message = FileManager.getOrDefault(HubManagement.getInstance().getConfigManager().getMessageConfig(), path, message);
    }

    public void sendBlock(Player player) {
        player.sendMessage(message.replace("%player%",player.getName()));
    }
}
