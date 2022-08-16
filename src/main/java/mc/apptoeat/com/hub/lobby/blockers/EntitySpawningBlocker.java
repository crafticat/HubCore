package mc.apptoeat.com.hub.lobby.blockers;


import mc.apptoeat.com.hub.utils.blocker.Blocker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitySpawningBlocker extends Blocker {
    public EntitySpawningBlocker() {
        super("");
    }

    @EventHandler
    public void spawn(CreatureSpawnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void spawn(EntitySpawnEvent e) {
        e.setCancelled(true);
    }
}
