package bgu.spl.mics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class FutureTest {

    Future<Integer> fut;
    Integer result1;

    @Before
    public void setUp() throws Exception {
        fut =new Future<Integer>();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void get() {
//        Thread t1= new Thread(()->{fut.get();});
//        t1.start();
//
//        fut.resolve(5);

        Integer result = fut.get();
        fut.resolve(5);
        assertEquals((Integer) 5,result);
    }

    @Test
    public void resolve() {
        Integer result = fut.get();
        fut.resolve(5);
        assertEquals((Integer) 5,result);
    }

    @Test
    public void isDone() {
        assertEquals(false,fut.isDone());
        fut.resolve(5);
        assertEquals(true,fut.isDone());
    }

    @Test
    public void get1() {
        Thread t1= new Thread(()->{result1=fut.get(3, TimeUnit.SECONDS);});
        t1.start();
        //Thread.currentThread().sleep(3000);


    }
}