package mc.apptoeat.com.hub.lobby.spawnitems;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import mc.apptoeat.com.hub.HubCoreAPI;
import mc.apptoeat.com.hub.utils.gui.GlobalGui;
import mc.apptoeat.com.hub.utils.item.Item;
import mc.apptoeat.com.hub.utils.message.Color;
import mc.apptoeat.com.hub.utils.runnable.PlayerRunnable;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ServerSelectorItem extends Item {

    public ServerSelectorItem() {
        super(new ItemStack(Material.COMPASS),0);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Color.code("&9&lServer Selector &7(Right click)"));
        List<String> lore = new ArrayList<>();
        lore.add(Color.code("&7Right-click to open the server selector!"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        allowConfig("items.serverSelector");

        GlobalGui gui = new GlobalGui("&9Select a server",9 * 5);
        gui.setGui((player) -> {
            gui.reset();

            // Practice
            gui.createGuiItem(Material.DIAMOND_SWORD, 11, "&b&lPractice","", new PlayerRunnable() {
                @Override
                public void run(Player player) {
                    player.sendMessage("joining practice");
                    sendPlayerToServer(player, "practice");
                }
            }, "",
                    "&7Duel PvP bots and players",
                    "&7in the competitive minecraft scene",
                    "&7and make you way up to the leaderboards",
                    "",
                    "&fOnline players: &a" + PlaceholderAPI.setPlaceholders(player, "%bungee_practice%"));

            // KitPvP
            gui.createGuiItem(Material.STONE_SWORD, 13, Color.code("&c&lKitPvp"), "", new PlayerRunnable() {
                @Override
                public void run(Player player) {
                    sendPlayerToServer(player, "kitpvp");
                }
            }, "",
                    "&7Fight players with custom abilities and kits",
                    "&7Every single kit gives the player a completely different",
                    "&7experience with our unique exclusive abilities",
                    "",
                    "&fOnline players: &a" + PlaceholderAPI.setPlaceholders(player, "%bungee_kitpvp%"));

            // UHC
            gui.createGuiItem(Material.GOLDEN_APPLE, 32, Color.code("&e&lUHC"), "", new PlayerRunnable() {
                @Override
                public void run(Player player) {
                    sendPlayerToServer(player, "uhc");
                }
            }, "",
                    "&cComing Soon!");

            // SkyWars
            gui.createGuiItem(Material.ENDER_PEARL, 30, Color.code("&b&lSkyWars"), "", new PlayerRunnable() {
                @Override
                public void run(Player player) {
                    sendPlayerToServer(player, "skywars");
                }
            }, "",
                    "&cComing Soon!");

            // Lava Rises
            gui.createGuiItem(Material.LAVA_BUCKET, 15, Color.code("&c&lLava Rises"), "", new PlayerRunnable() {
                @Override
                public void run(Player player) {
                    sendPlayerToServer(player, "lava");
                }
            }, "",
                    "&7This minigame has many fun abilities you can use in game while also having to PvP",
                    "&7The game gives you a complete PvP experience while trying",
                    "&7to survive the lava that rises every 10 seconds.",
                    "",
                    "&fOnline players: &a" + PlaceholderAPI.setPlaceholders(player, "%bungee_lava%"));

            gui.setBackGroundColor(15);
        });

        setItemGui(gui);
    }

    //Sends the player to a specific server.
    private void sendPlayerToServer(Player p, String server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);
        p.sendPluginMessage(HubCoreAPI.getInstance(), "BungeeCord", out.toByteArray());
    }
}
