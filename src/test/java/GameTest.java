import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

import java.awt.*;
import java.util.ArrayList;

public class GameTest {

    Player player1 = new Player(1, "Fedya", 15);
    Player player2 = new Player(2, "Kolya", 12);
    Player player3 = new Player(3, "Dima", 12);

    ArrayList<Player> players = new ArrayList<>();
    Game game = new Game(players);

    @BeforeEach
    void setup(){
        game.register(player1);
        game.register(player2);
        game.register(player3);
    }

    @Test
    public void shouldFirstWin() {

        int expected = 1;
        int actual = game.round(player1.getName(), player2.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSecondWin() {

        int expected = 2;
        int actual = game.round(player2.getName(), player1.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDrawGame() {

        int expected = 0;
        int actual = game.round(player2.getName(), player3.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGenerateExceptionWhenFirstNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Nikita", player2.getName());
        });
    }

    @Test
    public void shouldGenerateExceptionWhenSecondNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), "Ilya");
        });
    }
}
