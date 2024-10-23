import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestShift {

    private Shift shift;
    private CalendarTime start;
    private CalendarTime finish;

    @Before
    public void setUp() {
        // Initialize the start and finish times
        start = new CalendarTime("2/9/2019%22:00");
        finish = new CalendarTime("3/9/2019%06:00");
        shift = new Shift(start, finish);
    }

    @Test
    public void testShiftCreation() {
        // Test that the shift is created with correct start and finish times
        assertEquals(start, shift.start());
        assertEquals(finish, shift.finish());
    }

    @Test
    public void testShiftToString() {
        // Test the string representation of the shift
        assertEquals("2/9/2019%22:00:00 - 3/9/2019%06:00:00", shift.toString());
    }

    @Test
    public void testShiftInWeek() {
        Week week35 = new Week("35/2019");
        Week week36 = new Week("36/2019");
        Week week37 = new Week("37/2019");

        // Test that the shift is in week 36 but not in weeks 35 or 37
        assertFalse(shift.inWeek(week35));
        assertTrue(shift.inWeek(week36));
        assertFalse(shift.inWeek(week37));
    }

    @Test
    public void testShiftLength() {
        // Test the length of the shift (8 hours)
        assertEquals("8 hours", Duration.format(shift.length(), "hour"));
    }
}
