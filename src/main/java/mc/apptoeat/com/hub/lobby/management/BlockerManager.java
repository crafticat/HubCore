package mc.apptoeat.com.hub.lobby.management;

import mc.apptoeat.com.hub.lobby.blockers.*;
import mc.apptoeat.com.hub.utils.blocker.Blocker;
import mc.apptoeat.com.hub.utils.manager.Manager;

public class BlockerManager extends Manager<Blocker> {

    public BlockerManager() {
        super();
        register(new AttackEntitiesBlocker());
        register(new BreakBlocksBlocker());
        register(new DamageBlocker());
        register(new EntitySpawningBlocker());
        register(new PlaceBlocksBlocker());
        register(new NoHungerBlocker());
    }
}
