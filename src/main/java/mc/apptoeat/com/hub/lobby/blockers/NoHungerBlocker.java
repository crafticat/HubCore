package mc.apptoeat.com.hub.lobby.blockers;

import mc.apptoeat.com.hub.utils.blocker.Blocker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class NoHungerBlocker extends Blocker {

    public NoHungerBlocker() {
        super("");
    }

    @EventHandler
    public void foodChange(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }
}
