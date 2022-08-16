package mc.apptoeat.com.hub.lobby.management;

import lombok.Getter;
import mc.apptoeat.com.hub.lobby.spawnitems.HidePlayers;
import mc.apptoeat.com.hub.lobby.spawnitems.PearlItem;
import mc.apptoeat.com.hub.lobby.spawnitems.ServerSelectorItem;
import mc.apptoeat.com.hub.lobby.spawnitems.ShowPlayers;
import mc.apptoeat.com.hub.utils.item.Item;
import mc.apptoeat.com.hub.utils.manager.Manager;

@Getter
public class SpawnItemsManager extends Manager<Item> {

    private final HidePlayers hidePlayers;
    private final ShowPlayers showPlayers;

    public SpawnItemsManager() {
        super();
        register(new ServerSelectorItem());
        register(new PearlItem());
        register(hidePlayers = new HidePlayers());
        showPlayers = new ShowPlayers();
    }
}
