/*
 * Code used in the "Software Engineering" course.
 *
 * Copyright 2017 by Claudio Cusano (claudio.cusano@unipv.it)
 * Dept of Electrical, Computer and Biomedical Engineering,
 * University of Pavia.
 */
package coindispenser;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test of the CoinDispenser class.
 *  * 
 * @author Claudio Cusano <claudio.cusano@unipv.it>
 */
public class CoinDispenserTest {
    @Test
    public void testAddCoins() {
        CoinDispenser cd = new CoinDispenser(3); 
        cd.addCoins(100, 7);
        assertEquals(10, cd.countCoins(100));
    }
    
    @Test
    public void testAddCoinszero() {
        CoinDispenser cd = new CoinDispenser(3); 
        cd.addCoins(101, 7);
        assertEquals(3, cd.countCoins(100));
    }
    
    @Test
    public void testCoinDispenser(){
        CoinDispenser cd = new CoinDispenser(100);
        for (int i=0; i<cd.coinCounters.length ; i++)   
            assertEquals(100, cd.coinCounters[i]);
    }
    
    @Test
    public void testCountCoins(){
        CoinDispenser cd = new CoinDispenser(50);
        cd.coinCounters[0] -= 50;
        int i = cd.countCoins(55);
        
        assertEquals(i,0);
    }
    
    @Test
    public void testDispenserVuoto(){
        CoinDispenser cd = new CoinDispenser();
        
        for(int i=0; i<cd.coinCounters.length ;i++){
            assertEquals(0, cd.coinCounters[i]);
        }
    }
    
    @Test
    public void testDispenseCoin() throws DispenserError{
        CoinDispenser cd = new CoinDispenser(50);
        
        List<Integer> coin = new ArrayList();
        
        coin.add(1);
        coin.add(10);
        coin.add(20);
        coin.add(30);
        coin.add(40);
        coin.add(45);
        coin.add(50);
        cd.dispenseCoins(coin);
        
        
        for(int i=0; i<cd.coinCounters.length ;i++){
            System.out.println(cd.coinCounters[i]);
        }
        
        assertEquals(49, cd.coinCounters[0]);
        assertEquals(40, cd.coinCounters[1]);
        assertEquals(30, cd.coinCounters[2]);
        assertEquals(20, cd.coinCounters[3]);
        assertEquals(10, cd.coinCounters[4]);
        assertEquals(5, cd.coinCounters[5]);
        assertEquals(0, cd.coinCounters[6]);
        
        
    }
    
    
}   
