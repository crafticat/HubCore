package mc.apptoeat.com.hub.lobby.management;

import mc.apptoeat.com.hub.lobby.commands.*;
import mc.apptoeat.com.hub.lobby.commands.lobby.PortalsCommand;
import mc.apptoeat.com.hub.lobby.commands.lobby.SetSpawnCommand;
import mc.apptoeat.com.hub.lobby.commands.lobby.SpawnCommand;
import mc.apptoeat.com.hub.utils.commands.Command;
import mc.apptoeat.com.hub.utils.manager.Manager;

public class CommandManager extends Manager<Command> {

    public CommandManager() {
        register(new GamemodeCommand());
        register(new FlyCommand());
        register(new TopCommand());
        register(new PortalsCommand());
        register(new SpawnCommand());
        register(new SetSpawnCommand());
        register(new TeleportCommand());
        register(new TeleportHereCommand());
    }
}
