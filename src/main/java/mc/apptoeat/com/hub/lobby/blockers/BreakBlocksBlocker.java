package mc.apptoeat.com.hub.lobby.blockers;

import mc.apptoeat.com.hub.utils.blocker.Blocker;
import mc.apptoeat.com.hub.utils.message.Color;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakBlocksBlocker extends Blocker {

    public BreakBlocksBlocker() {
        super(Color.code("&7You cant break blocks in the lobby"));
        allowConfig("messages.breakBlocks");
    }

    @EventHandler
    public void breakBlock(BlockBreakEvent e) {
        if (!e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            e.setCancelled(true);
            sendBlock(e.getPlayer());
        }
    }
}
