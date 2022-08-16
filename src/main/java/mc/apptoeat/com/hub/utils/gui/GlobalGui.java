package mc.apptoeat.com.hub.utils.gui;

import mc.apptoeat.com.hub.utils.runnable.PlayerRunnable;
import org.bukkit.entity.Player;

public class GlobalGui extends Gui {

    private PlayerRunnable update;

    public GlobalGui(String title, int size) {
        super(title, size);
    }

    public void openGui(Player player) {
        player.closeInventory();
        update.run(player);
        openInventory(player);
    }

    public void minOpen(Player player) {
        update.run(player);
        openInventory(player);
    }

    public void setGui(PlayerRunnable update) {
        this.update = update;
    }
}
