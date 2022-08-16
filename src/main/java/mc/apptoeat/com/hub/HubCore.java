package mc.apptoeat.com.hub;

import org.bukkit.plugin.java.JavaPlugin;

public final class HubCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        HubCoreAPI coreAPI = new HubCoreAPI(this);
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
