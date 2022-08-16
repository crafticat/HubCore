package mc.apptoeat.com.hub.core.manager;

import lombok.Getter;

@Getter
public class Management {

    @Getter private static Management instance;

    public Management() {
        instance = this;
    }
}
