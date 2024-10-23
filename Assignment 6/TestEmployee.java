import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class EmployeeTest {

    private Employee employee;
    private Date date1, date2, date3, date4;
    private Time time1, time2, time3, time4;
    private Week week35;

    @Before
    public void setUp() {
        employee = new Employee("Sivuyile Ngesi", "01010125");

        
        date1 = new Date(1, 9, 2019);
        date2 = new Date(2, 9, 2019);
        date3 = new Date(3, 9, 2019);
        date4 = new Date(4, 9, 2019);

        time1 = new Time(6, 0);
        time2 = new Time(18, 0);
        time3 = new Time(16, 30);
        time4 = new Time(4, 0);

        week35 = new Week("35/2019");
    }

    @Test
    public void testEmployeeSignInOut() {
        assertFalse(employee.present()); 

        employee.signIn(date1, time1);
        assertTrue(employee.present());  
        
        
        employee.signOut(date1, time2);
        assertFalse(employee.present());
    }

    @Test
    public void testEmployeeShiftsInWeek() {
        employee.signIn(date1, time1);
        employee.signOut(date1, time2);

        employee.signIn(date2, time3);
        employee.signOut(date3, new Time(2, 30));

        employee.signIn(date3, new Time(18, 0));
        employee.signOut(date4, time4);

        List<Shift> shifts = employee.get(week35);
        assertEquals(3, shifts.size());
    }

    @Test
    public void testEmployeeHoursInWeek() {
        employee.signIn(date1, time1);
        employee.signOut(date1, time2);

        employee.signIn(date2, time3);
        employee.signOut(date3, new Time(2, 30));

        employee.signIn(date3, new Time(18, 0));
        employee.signOut(date4, time4);

        Duration totalHours = employee.hours(week35);
        assertEquals("12 hours", Duration.format(totalHours, "hour"));
    }
}
