package mc.apptoeat.com.hub.lobby.ability;

import mc.apptoeat.com.hub.lobby.management.HubManagement;
import mc.apptoeat.com.hub.utils.ability.Ability;
import mc.apptoeat.com.hub.utils.config.FileManager;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class HubPortal extends Ability {

    private final List<Location> portals;

    public HubPortal() {
        List<Location> portals1;
        portals1 = new ArrayList<>();
        portals1 = FileManager.getOrDefault(HubManagement.getInstance().getConfigManager().getDataConfig(), "portals",portals1);
        portals = portals1;
    }

    @EventHandler
    public void playerMoveEvent(PlayerMoveEvent e) {
        Block steppedBlock = e.getTo().clone().subtract(new Vector(0,1,0)).getBlock();
        if (portals.contains(steppedBlock.getLocation())) {
            e.getPlayer().sendMessage("Stepped on a portal");
        }
    }

    public void addBlock(Location location) {
        portals.add(location);
    }
}
