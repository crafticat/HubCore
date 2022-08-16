package mc.apptoeat.com.hub.lobby.blockers;

import mc.apptoeat.com.hub.utils.blocker.Blocker;
import mc.apptoeat.com.hub.utils.message.Color;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceBlocksBlocker extends Blocker {

    public PlaceBlocksBlocker() {
        super(Color.code("&7You cant place blocks in the lobby"));
        allowConfig("messages.placeBlocks");
    }

    @EventHandler
    public void breakBlock(BlockPlaceEvent e) {
        if (!e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            e.setCancelled(true);
            sendBlock(e.getPlayer());
        }
    }
}