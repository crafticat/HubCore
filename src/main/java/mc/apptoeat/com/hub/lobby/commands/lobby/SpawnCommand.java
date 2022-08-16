package mc.apptoeat.com.hub.lobby.commands.lobby;

import mc.apptoeat.com.hub.lobby.management.HubManagement;
import mc.apptoeat.com.hub.utils.commands.Command;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SpawnCommand extends Command {
    public SpawnCommand() {
        super("spawn", "teleports you to spawn", "&fYou have been teleported to spawn");
        allowConfig("messages.spawnTeleport");
    }

    @Override
    public void executeCommand(Player player, String commandLabel, String[] args) {
        String arg0 = null;
        if (args.length > 0) {
            arg0 = args[0];
        }

        String targetName = arg0;
        Player target = player;
        if (targetName != null) {
            Player var1 = Bukkit.getPlayer(targetName);
            if (var1 != null) target = var1;
        }

        target.teleport(HubManagement.getInstance().getListenersManager().getSpawnActions().getSpawnLocation());
        sendMessage(player,target.getName(),target.getGameMode().toString());
    }
}
