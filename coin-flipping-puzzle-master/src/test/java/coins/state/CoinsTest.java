package coins.state;

import static coins.state.Coins.generateFlips;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.BitSet;
import java.util.Objects;

class CoinsTest {

    // the original initial state
    private final Coins state1 = new Coins(7, 3);

    // the goal state
    private final Coins state2;{
        BitSet bs = new BitSet(7);
        bs.set(0, 7);
        state2 = new Coins(7, 3, bs);
    }

    @Test
    void testIsGoalFalse(){
        assertFalse(state1.isGoal());
    }

    @Test
    void testIsGoalTrue(){
        assertTrue(state2.isGoal());
    }

    @Test
    void testGetFlips() {
        assertEquals(state1.getFlips(), state2.getFlips());
    }


    @Test
    void testGenerateFlips()
    {
        assertEquals(generateFlips(7, 3), state1.getFlips());
    }

    @Test
    void testClone() {
        assertEquals(state1.clone(), state1);
    }

    @Test
    void hashCodeEqualsTest() {
        assertEquals(state1.hashCode(), Objects.hash(state1.getN(), state1.getM(), state1.getCoins()));
    }

    @Test
    void hashCodeNotEqualsTest() {
        assertNotEquals(state1.hashCode(), state2.hashCode());
    }

    @Test
    void ToStringTest() {
        assertEquals(state1.toString(), "O|O|O|O|O|O|O");
        assertEquals(state2.toString(), "1|1|1|1|1|1|1");

    }

}