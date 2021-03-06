package pl.rotkomichal.battleship.views.gameView.board.ship;

import pl.rotkomichal.battleship.views.gameView.board.BoardField;
import pl.rotkomichal.battleship.views.gameView.board.fieldType.FieldStatus;
import pl.rotkomichal.battleship.views.gameView.board.fieldType.ShipFieldType;

import java.util.stream.IntStream;

public class ShipFactory {
    public static Ship getShip(int size) {
        Ship ship = new Ship();

        IntStream.range(0, size).forEach(i -> {
            BoardField boardField = new BoardField();
            boardField.setFieldType(new ShipFieldType());
            boardField.getFieldType().setFieldStatus(FieldStatus.VISIBLE);
            ship.getFields().add(boardField);
        });

        ship.setDirection(Direction.VERTICAL);

        return ship;
    }
}
