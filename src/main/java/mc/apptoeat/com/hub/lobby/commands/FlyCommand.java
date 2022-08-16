package mc.apptoeat.com.hub.lobby.commands;

import mc.apptoeat.com.hub.lobby.management.HubManagement;
import mc.apptoeat.com.hub.utils.commands.Command;
import mc.apptoeat.com.hub.utils.config.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FlyCommand extends Command {

    public FlyCommand() {
        super(FileManager.getOrDefault(HubManagement.getInstance().getConfigManager().getCommandConfig(), "commands.fly", "fly"), "&fLets you fly", "&b%target% &fis &b%mode%&f able to fly");
        allowConfig("messages.fly");
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

        target.setAllowFlight(!target.getAllowFlight());
        String type = player.getAllowFlight() ? "is now" : "no longer";
        sendMessage(player,target.getName(),type);
    }
}
