package mc.apptoeat.com.hub.utils.commands;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import mc.apptoeat.com.hub.HubCoreAPI;
import mc.apptoeat.com.hub.lobby.management.HubManagement;
import mc.apptoeat.com.hub.utils.config.FileManager;
import mc.apptoeat.com.hub.utils.message.Color;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.entity.Player;

import java.util.Arrays;

@Getter
@Setter
public class Command extends BukkitCommand {

    private String arg;
    private String[] args;
    private Player player;
    private String message;

    public Command(String name, String description,String message,String... aliases) {
        super(name);
        this.description = description;
        this.usageMessage = "/" + name;
        this.message = Color.code(message);
        this.setAliases(Arrays.asList(aliases));
        ((CraftServer) HubCoreAPI.getInstance().getServer()).getCommandMap().register(name, this);
    }

    @SneakyThrows
    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            this.arg = commandLabel;
            this.args = args;
            this.player = player;
            executeCommand(player,commandLabel,args);
        } else sender.sendMessage(Color.code("&7This command can only be executed by a player!"));
        return false;
    }

    public void executeCommand(Player player,String commandLabel,String[] args) {

    }

    public void sendMessage(Player player,String target,String mode) {
        player.sendMessage(message.replace("%mode%",mode).replace("%target%",target));
    }

    public void allowConfig(String path) {
        message = FileManager.getOrDefault(HubManagement.getInstance().getConfigManager().getCommandConfig(), path, message);
    }
}