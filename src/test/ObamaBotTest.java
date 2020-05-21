package test;

import domain.Game;
import domain.Observer;
import domain.Player;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObamaBotTest {

    @Test
    public void newInstanceTest() {


        assertEquals(Player.getObservers().size(), Game.players.size());
        for(Observer obs : Player.getObservers())
        {
            assertNotNull(obs);
        }
    }

}