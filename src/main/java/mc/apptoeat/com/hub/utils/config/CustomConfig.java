package mc.apptoeat.com.hub.utils.config;

import lombok.Getter;
import mc.apptoeat.com.hub.HubCoreAPI;
import mc.apptoeat.com.hub.utils.message.Color;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

@Getter
public class CustomConfig {

    private FileConfiguration config;
    private File file;

    public CustomConfig(String name) {
        file = new File(HubCoreAPI.getInstance().getDataFolder(), name + ".yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ignore) {}
        }

        config = YamlConfiguration.loadConfiguration(file);
        saveConfig();
    }

    public void saveConfig() {
        try {
            config.save(file);
        } catch (IOException e) {
            Bukkit.broadcastMessage(Color.code("&7Couldnt save file"));
        }
    }
}
