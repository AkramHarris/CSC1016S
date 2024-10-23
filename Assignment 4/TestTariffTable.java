/** 
 * A test suite for TariffTable.
 * @author Abdul-Kader Jainoodien
 * @version 15/08/2024
 * 
*/


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestTariffTable {

    /**All the consistently used variables.*/
    final Currency RAND = new Currency("R", "ZAR", 100);
    Money money1 = new Money("R15", RAND);
    Money money2 = new Money("R20", RAND);
    Money money3 = new Money("R25", RAND);
    Duration duration1 = new Duration(0);
    Duration duration2 = new Duration("minute", 90);
    Duration duration3 = new Duration("minute", 120);
    Duration duration4 = new Duration("minute", 150);
    TimePeriod timePeriod1 = new TimePeriod(duration1, duration2);
    TimePeriod timePeriod2 = new TimePeriod(duration2, duration3);
    TimePeriod timePeriod3 = new TimePeriod(duration3, duration4);

    @ Test
    public void testAddTariffFail() {
        /**Add tariffs in wrong order on purpose. If an error is thrown, it works as expected.*/
        TariffTable tariffTable = new TariffTable(3);
        tariffTable.addTariff(timePeriod1, money1);
        boolean passed = false;
        try {
            tariffTable.addTariff(timePeriod3, money1);
        } catch (Exception IllegalArgumentException) {
            passed = true;
        }
        assertTrue(passed);
    }

    @ Test
    public void testAddTariff() {
        /**Tests that adding in the correct order works as intended.*/
        TariffTable tariffTable = new TariffTable(3);
        tariffTable.addTariff(timePeriod1, money1);
        boolean failed = false;
        try {
            tariffTable.addTariff(timePeriod2, money2);
            tariffTable.addTariff(timePeriod3, money3);
        } catch (Exception IllegalArgumentException) {
            failed = true;
        }
        assertFalse(failed);
    }

    @ Test
    public void testGetTariff() {
        /**Tests if the getTariff() method works */
        TariffTable tariffTable = new TariffTable(3);
        tariffTable.addTariff(timePeriod1, money1);
        tariffTable.addTariff(timePeriod2, money2);
        tariffTable.addTariff(timePeriod3, money3);
        assertEquals("R20.00", tariffTable.getTariff(new Duration("minute", 90)).toString());
    }

    @ Test
    public void testToString() {
        /**Tests if the custom toString() method works. */
        TariffTable tariffTable = new TariffTable(3);
        tariffTable.addTariff(timePeriod1, money1);
        tariffTable.addTariff(timePeriod2, money2);
        tariffTable.addTariff(timePeriod3, money3);
        String expectedOutcomeString = "[0 minutes .. 1 hour 30 minutes] : R15.00\n[1 hour 30 minutes .. 2 hours] : R20.00\n[2 hours .. 2 hours 30 minutes] : R25.00";
        assertEquals(expectedOutcomeString, tariffTable.toString());
    }
    
}
