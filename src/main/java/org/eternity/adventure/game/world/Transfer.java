package org.eternity.adventure.game.world;

import org.eternity.adventure.game.world.item.Source;
import org.eternity.adventure.game.world.item.Target;

public class Transfer {
    private Source source;
    private Target target;
    private String itemName;

    public Transfer(Source source, Target target, String itemName) {
        this.source = source;
        this.target = target;
        this.itemName = itemName;
    }

    public boolean isPossible() {
        return source.find(itemName).isPresent();
    }

    public void perform() {
        if (!isPossible()) {
            throw new IllegalStateException();
        }

        source.find(itemName).ifPresent(
                item -> {
                    source.remove(item);
                    target.add(item);
        });
    }
}
