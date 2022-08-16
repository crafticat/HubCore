package mc.apptoeat.com.hub.lobby.spawnitems;

import mc.apptoeat.com.hub.lobby.management.HubManagement;
import mc.apptoeat.com.hub.utils.item.Item;
import mc.apptoeat.com.hub.utils.message.Color;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShowPlayers extends Item {

    public ShowPlayers() {
        super(new ItemStack(Material.INK_SACK,1,(short) 10), 5);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Color.code("&cHide players &7(Right click)"));
        item.setItemMeta(meta);
    }

    @Override
    public void rightClick(Player player) {
        player.setItemInHand(HubManagement.getInstance().getSpawnItemsManager().getHidePlayers().getItem());

        Bukkit.getOnlinePlayers().forEach(player::showPlayer);
    }
}
