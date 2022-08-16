package mc.apptoeat.com.hub.lobby.management;

import lombok.Getter;
import mc.apptoeat.com.hub.lobby.ability.DoubleJumpAbility;
import mc.apptoeat.com.hub.lobby.ability.HubPortal;
import mc.apptoeat.com.hub.lobby.scoreboard.ScoreBoard;
import mc.apptoeat.com.hub.utils.ability.Ability;
import mc.apptoeat.com.hub.utils.manager.Manager;

@Getter
public class AbilityManager extends Manager<Ability> {

    private final HubPortal hubPortal;

    public AbilityManager() {
        register(new DoubleJumpAbility());
        register(new ScoreBoard());
        register(hubPortal = new HubPortal());
    }
}
