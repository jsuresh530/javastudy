package com.mokito2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RunApp {

    @InjectMocks
    // @TestSubject annotation is used to identify class
   // @TestSubject
    TestApp testApp = new TestApp();

    @Mock
    CalculatorService service;

    @Test
    public void testAdd1(){
        doThrow(new RuntimeException("Run time error")).when(service).add(10.0, 20.0);

        Assert.assertEquals(testApp.add(10.0,20.0), 30.0,0);
    }
    @Test
    public void testAdd() {
        when(service.add(10.0, 20.0)).thenReturn(30.00);

        when(service.mul(10.0, 10.0)).thenReturn(100.00);

        Assert.assertEquals(testApp.add(10.0, 20.0), 30.0, 0);
        Assert.assertEquals(testApp.add(10.0, 20.0), 30.0, 0);
        Assert.assertEquals(testApp.add(10.0, 20.0), 30.0, 0);


        Assert.assertEquals(testApp.multi(10.0,10.0), 100.0,0);
        //verify(service).add(10.0,20.0);
        verify(service, times(3)).add(10.0, 20.0);

        verify(service).mul(10.0, 10.0);

        verify(service, never()).mul(10.00, 20.00);

        verify(service, atLeast(1)).mul(10.0,10.0);
        //verify(service, atLeastOnce()).mul(10.0,20.0);
       // verify(service, atMost(3)).mul(10.0,10.0);




    }

}
