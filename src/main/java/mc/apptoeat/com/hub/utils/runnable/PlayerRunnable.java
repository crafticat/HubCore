package mc.apptoeat.com.hub.utils.runnable;

import org.bukkit.entity.Player;

import java.io.IOException;

@FunctionalInterface
public interface PlayerRunnable {
    void run(Player var1);
}

