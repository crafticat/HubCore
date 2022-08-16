package mc.apptoeat.com.hub.lobby.management;

import lombok.Getter;
import mc.apptoeat.com.hub.utils.config.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;

@Getter
public class HubManagement {

    private final ConfigManager configManager;
    private final BlockerManager blockerManager;
    private final SpawnItemsManager spawnItemsManager;
    private final ListenersManager listenersManager;
    private final CommandManager commandManager;
    private final AbilityManager abilityManager;

    @Getter private static HubManagement instance;

    public HubManagement() {
        instance = this;
        configManager = new ConfigManager();
        blockerManager = new BlockerManager();
        spawnItemsManager = new SpawnItemsManager();
        listenersManager = new ListenersManager();
        commandManager = new CommandManager();
        abilityManager = new AbilityManager();
    }
}
