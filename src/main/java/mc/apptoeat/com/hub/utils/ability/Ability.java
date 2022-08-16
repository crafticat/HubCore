package mc.apptoeat.com.hub.utils.ability;

import mc.apptoeat.com.hub.HubCoreAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class Ability implements Listener {

    protected boolean enabled;

    public Ability() {
        Bukkit.getServer().getPluginManager().registerEvents(this, HubCoreAPI.getInstance());
    }
}
