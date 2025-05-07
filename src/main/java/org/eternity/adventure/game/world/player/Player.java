package org.eternity.adventure.game.world.player;

import org.eternity.adventure.game.world.item.Carrier;
import org.eternity.adventure.game.world.item.ForwardingCarrier;
import org.eternity.adventure.game.world.item.Inventory;
import org.eternity.adventure.game.world.worldmap.Direction;
import org.eternity.adventure.game.world.worldmap.Position;
import org.eternity.adventure.game.world.worldmap.Room;
import org.eternity.adventure.game.world.worldmap.WorldMap;

public class Player extends ForwardingCarrier {
    private WorldMap worldMap;
    private Position position;

    public Player(WorldMap worldMap, Position position) {
        this(worldMap, position, new Inventory());
    }

    public Player(WorldMap worldMap, Position position, Carrier carrier) {
        super(carrier);
        this.worldMap = worldMap;
        this.position = position;
    }

    public boolean canMove(Direction direction) {
        return !worldMap.isBlocked(position.shift(direction));
    }

    public void move(Direction direction) {
        if (!canMove(direction)) {
            throw new IllegalArgumentException();
        }

        this.position = this.position.shift(direction);
    }

    public Position position() {
        return position;
    }

    public Room currentRoom() {
        return worldMap.roomAt(position);
    }

    public WorldMap worldMap() {
        return worldMap;
    }
}
