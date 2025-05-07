package org.eternity.adventure.game.world.item;

import java.util.Optional;

public interface Source {
    Optional<Item> find(String itemName);
    void remove(Item item);
}
