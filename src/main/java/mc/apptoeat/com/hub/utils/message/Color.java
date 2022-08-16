package mc.apptoeat.com.hub.utils.message;

import org.bukkit.ChatColor;

public class Color {
    public static String code(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
