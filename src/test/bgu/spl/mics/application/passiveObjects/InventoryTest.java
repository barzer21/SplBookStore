package bgu.spl.mics.application.passiveObjects;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {

    Inventory inv;

    @Before
    public void setUp() throws Exception {
        inv = new Inventory();
        BookInventoryInfo[] booksArray = new BookInventoryInfo[3]; //the size is the number of different books
        booksArray[0] = new BookInventoryInfo("b1",100, 1);
        booksArray[1] = new BookInventoryInfo("b2",50, 2);
        booksArray[2] = new BookInventoryInfo("b3",20, 3);
        inv.load(booksArray);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getInstance() {
    }

    @Test
    public void load() {
        //checking if all the books loaded properly
        assertEquals(inv.take("b1"),OrderResult.SUCCESSFULLY_TAKEN);
        assertEquals(inv.take("b2"),OrderResult.SUCCESSFULLY_TAKEN);
        assertEquals(inv.take("b2"),OrderResult.SUCCESSFULLY_TAKEN);
        assertEquals(inv.take("b3"),OrderResult.SUCCESSFULLY_TAKEN);
        assertEquals(inv.take("b3"),OrderResult.SUCCESSFULLY_TAKEN);
        assertEquals(inv.take("b3"),OrderResult.SUCCESSFULLY_TAKEN);

        assertEquals(inv.take("b7"),OrderResult.NOT_IN_STOCK); // checking a non loaded book


    }

    @Test
    public void take() {
        assertEquals(inv.take("b1"),OrderResult.SUCCESSFULLY_TAKEN);
        assertEquals(inv.take("b3"),OrderResult.SUCCESSFULLY_TAKEN);
        assertEquals(-1,inv.checkAvailabiltyAndGetPrice("b1"));
        assertEquals(inv.take("b1"),OrderResult.NOT_IN_STOCK);

    }

    @Test
    public void checkAvailabiltyAndGetPrice() {
        assertEquals(100,inv.checkAvailabiltyAndGetPrice("b1"));
        assertEquals(-1,inv.checkAvailabiltyAndGetPrice("b7"));
    }

    @Test
    public void printInventoryToFile() {
    }
}