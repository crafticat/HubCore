package mc.apptoeat.com.hub.lobby.spawnitems;

import mc.apptoeat.com.hub.HubCoreAPI;
import mc.apptoeat.com.hub.utils.item.Item;
import mc.apptoeat.com.hub.utils.message.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class PearlItem extends Item {

    public PearlItem() {
        super(new ItemStack(Material.ENDER_PEARL), 8);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Color.code("&d&lMagic Pearl &7(Right click)"));
        item.setItemMeta(meta);
        allowConfig("items.pearl");
    }

    Map<Player,Long> use = new HashMap<>();

    @EventHandler
    public void throwPro(ProjectileLaunchEvent e) {
        //If the projectile is not a pearl or the shooter is not a player
        if (!(e.getEntity() instanceof EnderPearl)) return;
        if (!(e.getEntity().getShooter() instanceof Player)) return;

        //Data
        EnderPearl pearl = (EnderPearl) e.getEntity();
        Player player = (Player) pearl.getShooter();

        long now = System.currentTimeMillis();
        long last = use.getOrDefault(player,0L);
        boolean delay = now - last < 55;
        use.put(player,now);

        if (delay) {
            e.setCancelled(true);
            player.sendMessage(Color.code("&7Do not spam pearls"));
            return;
        }

        //Infinite
        player.getInventory().addItem(item);
        new BukkitRunnable() {
            @Override
            public void run() {
                pearl.setPassenger(player);
            }
        }.runTaskLater(HubCoreAPI.getInstance(),1);
    }

    @EventHandler
    public void EntitySpawnEvent(EntitySpawnEvent e) {
        //If the projectile is not a pearl or the shooter is not a player
        if (!(e.getEntity() instanceof EnderPearl)) return;
        if (!(((EnderPearl) e.getEntity()).getShooter() instanceof Player)) return;

        //Data
        EnderPearl pearl = (EnderPearl) e.getEntity();
        Player player = (Player) pearl.getShooter();

        player.sendMessage("pearl");
        pearl.setPassenger(player);
    }

    @EventHandler
    public void pearlCollision(ProjectileHitEvent e) {
        //If the projectile is not a pearl or the shooter is not a player
        if (!(e.getEntity() instanceof EnderPearl)) return;
        if (!(((EnderPearl) e.getEntity()).getShooter() instanceof Player)) return;

        //Data
        EnderPearl pearl = (EnderPearl) e.getEntity();
        Player player = (Player) pearl.getShooter();
        Location old = pearl.getLocation().add(pearl.getVelocity().multiply(-1));
        old.setYaw(player.getLocation().getYaw());
        old.setPitch(player.getLocation().getPitch());
        if (pearl.getPassenger() == null) return;
        pearl.setPassenger(null);
        player.teleport(old);
    }

    @EventHandler
    public void teleport(PlayerTeleportEvent e) {
        if (e.getCause().equals(PlayerTeleportEvent.TeleportCause.ENDER_PEARL)) e.setCancelled(true);
    }
}
