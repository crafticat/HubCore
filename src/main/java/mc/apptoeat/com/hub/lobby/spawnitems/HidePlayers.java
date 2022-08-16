package mc.apptoeat.com.hub.lobby.spawnitems;

import mc.apptoeat.com.hub.lobby.management.HubManagement;
import mc.apptoeat.com.hub.utils.item.Item;
import mc.apptoeat.com.hub.utils.message.Color;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HidePlayers extends Item {

    public HidePlayers() {
        super(new ItemStack(Material.INK_SACK,1,(short) 8), 5);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Color.code("&cHide players &7(Right click)"));
        item.setItemMeta(meta);
    }

    @EventHandler
    public void hide(PlayerJoinEvent e) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getInventory().contains(HubManagement.getInstance().getSpawnItemsManager().getShowPlayers().getItem())) {
                p.sendMessage("Someone joined while hiding is enabled");
                p.hidePlayer(e.getPlayer());
            }
        }
    }

    @Override
    public void rightClick(Player player) {
        Bukkit.getOnlinePlayers().forEach(player::hidePlayer);
        player.setItemInHand(HubManagement.getInstance().getSpawnItemsManager().getShowPlayers().getItem());
    }
}
