package mc.apptoeat.com.hub.lobby.commands.lobby;

import mc.apptoeat.com.hub.lobby.management.HubManagement;
import mc.apptoeat.com.hub.utils.commands.Command;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class PortalsCommand extends Command {
    public PortalsCommand() {
        super("portal", "Portals", "Cat");
    }

    @Override
    public void executeCommand(Player player, String commandLabel, String[] args) {
        Location blockLoc = player.getLocation().subtract(new Vector(0,1,0)).getBlock().getLocation();
        HubManagement.getInstance().getAbilityManager().getHubPortal().addBlock(blockLoc);
        sendMessage(player,"null","null");
    }
}
