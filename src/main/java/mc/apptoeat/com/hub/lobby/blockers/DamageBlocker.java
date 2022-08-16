package mc.apptoeat.com.hub.lobby.blockers;

import mc.apptoeat.com.hub.utils.blocker.Blocker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageBlocker extends Blocker {

    public DamageBlocker() {
        super("");
    }

    @EventHandler
    public void damage(EntityDamageEvent e) {
        e.setCancelled(true);
    }
}
