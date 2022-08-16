package mc.apptoeat.com.hub.lobby.commands.lobby;


import mc.apptoeat.com.hub.lobby.management.HubManagement;
import mc.apptoeat.com.hub.utils.commands.Command;
import org.bukkit.entity.Player;

public class SetSpawnCommand extends Command {
    public SetSpawnCommand() {
        super("setspawn", "sets the spawn location", "&fYou have set the spawn location");
        allowConfig("messages.spawnCreate");
    }

    @Override
    public void executeCommand(Player player, String commandLabel, String[] args) {
        HubManagement.getInstance().getListenersManager().getSpawnActions().updateSpawn(player.getLocation());
        sendMessage(player,"null","null");
    }
}
