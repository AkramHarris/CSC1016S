// HRRAKR001
// Akram Harris
// 09/08/2024

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestOfTime { // Creating a test class

    @Test
    public void testTimeCreation() { // Testing if the time constructor works
        Time t = new Time("13:45");
        assertEquals("13:45:00", t.toString());
    }

    @Test
    public void testTimeSubtraction() { // Testing the methods of Time
        Time t1 = new Time("14:00");
        Time t2 = new Time("13:00");
        Duration d = t1.subtract(t2);
        assertEquals(60, d.intValue("minute"));
    }

    @Test
    public void testTimeSubtractionSameTime() {
        Time t = new Time("13:00");
        Duration d = t.subtract(t);
        assertEquals(0, d.intValue("minute"));
    }

    @Test
    public void testDurationInMilliseconds() {
        Duration d = new Duration(60000); // 1 minute
        assertEquals(60000, d.intValue("millisecond"));
    }

    @Test
    public void testDurationInSeconds() {
        Duration d = new Duration(60000); // 1 minute
        assertEquals(60, d.intValue("second"));
    }

    @Test
    public void testDurationInMinutes() {
        Duration d = new Duration(3600000); // 1 hour
        assertEquals(60, d.intValue("minute"));
    }

    @Test
    public void testDurationInHours() {
        Duration d = new Duration(7200000); // 2 hours
        assertEquals(2, d.intValue("hour"));
    }
}
