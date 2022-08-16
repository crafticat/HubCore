package mc.apptoeat.com.hub;

import lombok.Getter;
import mc.apptoeat.com.hub.lobby.management.HubManagement;

@Getter
public class HubCoreAPI {

    @Getter private static HubCore instance;

    private final HubManagement hubManagement;

    public HubCoreAPI(HubCore core) {
        instance = core;
        hubManagement = new HubManagement();
    }
}
