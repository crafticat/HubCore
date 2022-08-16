package mc.apptoeat.com.hub.lobby.management;

import lombok.Getter;
import mc.apptoeat.com.hub.utils.config.CustomConfig;
import mc.apptoeat.com.hub.utils.manager.Manager;

@Getter
public class ConfigManager extends Manager<CustomConfig> {

    private final CustomConfig dataConfig;
    private final CustomConfig itemsConfig;
    private final CustomConfig messageConfig;
    private final CustomConfig commandConfig;

    public ConfigManager() {
        register(dataConfig = new CustomConfig("data"));
        register(itemsConfig = new CustomConfig("items"));
        register(messageConfig = new CustomConfig("messages"));
        register(commandConfig = new CustomConfig("commands"));
    }
}
