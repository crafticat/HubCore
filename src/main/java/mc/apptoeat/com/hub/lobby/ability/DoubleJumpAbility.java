package mc.apptoeat.com.hub.lobby.ability;

import mc.apptoeat.com.hub.lobby.management.HubManagement;
import mc.apptoeat.com.hub.utils.ability.Ability;
import mc.apptoeat.com.hub.utils.config.CustomConfig;
import mc.apptoeat.com.hub.utils.config.FileManager;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class DoubleJumpAbility extends Ability {

    private final double horizontal;
    private final double vertical;

    public DoubleJumpAbility() {
        CustomConfig config = HubManagement.getInstance().getConfigManager().getItemsConfig();
        horizontal = FileManager.getOrDefault(config,"doubleJump.horizontal",0.8);
        vertical = FileManager.getOrDefault(config,"doubleJump.vertical",0.6);
    }

    @EventHandler
    public void joinPlayer(PlayerJoinEvent e) {
        e.getPlayer().setAllowFlight(true);
    }

    @EventHandler
    public void doubleJump(PlayerToggleFlightEvent e) {
        if (!e.isFlying() || e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) return;

        Vector velocity = e.getPlayer().getLocation().getDirection().normalize().multiply(horizontal).setY(vertical);
        e.getPlayer().setVelocity(velocity);
        e.getPlayer().playSound(e.getPlayer().getLocation(),Sound.BAT_TAKEOFF,100,1);
        e.setCancelled(true);
    }
}
