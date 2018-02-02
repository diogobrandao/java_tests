package org.academiadecodigo.bootcamp.mock;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CarTest {

    private Car toyota = mock(Car.class);

   @Test
    public void testIfToyotaIsACar(){
       assertTrue(toyota instanceof  Car);
   }

   @Test
    public void testDefaultBehaviorOfToyota() {
        assertFalse(toyota.needsFuel());
        assertEquals(0.0, toyota.getEngineTemperature());
   }

   @Test
    public void testStubbing(){

        assertFalse("new test double should return false", toyota.needsFuel());

        when(toyota.needsFuel()).thenReturn(true);

        assertTrue("after instructed test double should return what we want ", toyota.needsFuel());

   }

   @Test (expected = RuntimeException.class)
    public void throwException() {
        when(toyota.needsFuel()).thenThrow(new RuntimeException());

        toyota.needsFuel();


   }

   @Test
    public void testVerification() {
        toyota.needsFuel();
        toyota.driveTo("São Mateus");

        verify (toyota).needsFuel();  //check if the real method was used
       //verify(toyota, never().needsFuel();
        verify(toyota).driveTo("São Mateus");
   }

}

