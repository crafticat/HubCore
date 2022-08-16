package mc.apptoeat.com.hub.lobby.management;

import lombok.Getter;
import mc.apptoeat.com.hub.HubCoreAPI;
import mc.apptoeat.com.hub.core.listeners.JoinQuitMessages;
import mc.apptoeat.com.hub.lobby.listeners.SpawnActions;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

@Getter
public class ListenersManager {

    private final SpawnActions spawnActions;

    public ListenersManager() {
        register(spawnActions = new SpawnActions());
        register(new JoinQuitMessages());
    }

    public void register(Listener listener) {
        Bukkit.getServer().getPluginManager().registerEvents(listener, HubCoreAPI.getInstance());
    }
}
