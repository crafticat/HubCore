package mc.apptoeat.com.hub.utils.item;

import lombok.Getter;
import lombok.Setter;
import mc.apptoeat.com.hub.HubCoreAPI;
import mc.apptoeat.com.hub.lobby.management.HubManagement;
import mc.apptoeat.com.hub.utils.config.FileManager;
import mc.apptoeat.com.hub.utils.gui.GlobalGui;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

@Getter
@Setter
public class Item implements Listener {

    protected ItemStack item;
    private boolean config;
    private GlobalGui gui;
    private boolean disableMovements = true;
    private int slot;

    public Item(ItemStack item,int slot) {
        this.slot = slot;
        this.item = item;
        Bukkit.getServer().getPluginManager().registerEvents(this,HubCoreAPI.getInstance());
    }

    public void allowConfig( String path) {
        item = FileManager.getOrDefault(HubManagement.getInstance().getConfigManager().getItemsConfig(), path,item);
    }

    public void setItemGui(GlobalGui gui) {
        this.gui = gui;
    }

    @EventHandler
    public void rightClick(PlayerInteractEvent e) {
        if (!(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) return;
        if (e.getItem().getItemMeta().equals(item.getItemMeta())) {
            rightClick(e.getPlayer());
            if (gui != null) gui.minOpen(e.getPlayer());
        }
    }

    //Disables item movements
    @EventHandler
    public void move(InventoryMoveItemEvent e) {
        if (disableMovements && e.getItem().getItemMeta().equals(item.getItemMeta())) e.setCancelled(true);
    }

    @EventHandler
    public void move(InventoryDragEvent e) {
        if (disableMovements && e.getCursor().getItemMeta().equals(item.getItemMeta())) e.setCancelled(true);
    }


    public void rightClick(Player player) {}
}
