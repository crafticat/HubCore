package mc.apptoeat.com.hub.lobby.scoreboard;

import mc.apptoeat.com.hub.utils.message.Color;
import me.clip.placeholderapi.PlaceholderAPI;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard extends mc.apptoeat.com.hub.utils.scoreboard.ScoreBoard {

    public ScoreBoard() {
        super(20 * 5);
        String name = Color.code("&b&lAppToEat");
        createBoard(name, player -> {
            List<String> objects = new ArrayList<>();
            objects.add("&8&m-------------------------");
            objects.add("&b&lInfo");
            objects.add(" &b• &fRank:&b Default");
            objects.add(" &b• &fGlobal:&b " + PlaceholderAPI.setPlaceholders(player,"%bungee_total%"));
            objects.add("&7");
            objects.add("&b&lServers");
            objects.add(" &b• &fPractice:&b " + PlaceholderAPI.setPlaceholders(player,"%bungee_practice%"));
            objects.add(" &b• &fKitPvP:&b " + PlaceholderAPI.setPlaceholders(player,"%bungee_kitpvp%"));
            objects.add(" &b• &fLava:&b " + PlaceholderAPI.setPlaceholders(player,"%bungee_lava%"));
            objects.add("&8&m-------------------------&7");
            return objects;
        });
    }
}