package mc.apptoeat.com.hub.lobby.blockers;

import mc.apptoeat.com.hub.utils.blocker.Blocker;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AttackEntitiesBlocker extends Blocker {

    public AttackEntitiesBlocker() {
        super("&7You cant attack other entities");
        allowConfig("messages.attackEntities");
    }

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType().equals(EntityType.PLAYER)) {
            e.setCancelled(true);
            sendBlock((Player) e.getDamager());
        }
    }
}
