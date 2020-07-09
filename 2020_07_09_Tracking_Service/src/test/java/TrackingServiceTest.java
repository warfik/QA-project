import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrackingServiceTest {

    @Before
    public void setUp() throws Exception {
    }

    TrackingService trackingService = new TrackingService();

    @Test
    public void test_calorie_zeroing_with_add_zero() {
        int amount = 0;
        trackingService.addCalories(amount);
        assertEquals(0, trackingService.getTotal());
    }

    @Test
    public void test_calorie_zeroing_with_add_zero_with_zeroing_array() {
        int amount = 0;
        trackingService.addCalories(amount);
        assertEquals(0, trackingService.getHistory().get(0).getId());
        assertEquals(0, trackingService.getHistory().get(0).getAmount());
        assertEquals("add", trackingService.getHistory().get(0).getOperation());
        assertEquals(0, trackingService.getHistory().get(0).getTotal());
    }

    @Test
    public void test_calorie_with_add_with_amount() {
        int amount = 20;
        trackingService.addCalories(amount);
        assertEquals(20, trackingService.getTotal());
        trackingService.addCalories(amount);
        assertEquals(40, trackingService.getTotal());
    }

    @Test
    public void test_calorie_zeroing() {
        int amount = 9;
        trackingService.removeCalories(amount);
        assertEquals(0, trackingService.getTotal());
    }

    @Test
    public void test_remove_cal() {
        int addAmount = 19;
        trackingService.addCalories(addAmount);
        int removeAmount = 9;
        trackingService.removeCalories(removeAmount);
        assertEquals(10, trackingService.getTotal());
    }

    @Test
    public void test_add_and_remove_Cal_and_Amount_with_double_array_history() {
        int addAmount = 19;
        trackingService.addCalories(addAmount);
        int removeAmount = 9;
        trackingService.removeCalories(removeAmount);
        assertEquals(0, trackingService.getHistory().get(0).getId());
        assertEquals(19, trackingService.getHistory().get(0).getAmount());
        assertEquals("add", trackingService.getHistory().get(0).getOperation());
        assertEquals(19, trackingService.getHistory().get(0).getTotal());

        assertEquals(1, trackingService.getHistory().get(1).getId());
        assertEquals(9, trackingService.getHistory().get(1).getAmount());
        assertEquals("remove", trackingService.getHistory().get(1).getOperation());
        assertEquals(10, trackingService.getHistory().get(1).getTotal());
    }

    @Test
    public void testGoalIsMet() {
        trackingService.setGoal(20);
        int amount = 19;
        trackingService.addCalories(amount);
        assertFalse(trackingService.isGoalMet());

        trackingService.setGoal(19);
        trackingService.addCalories(amount);
        assertTrue(trackingService.isGoalMet());

        trackingService.setGoal(18);
        trackingService.addCalories(amount);
        assertTrue(trackingService.isGoalMet());
    }

    @After
    public void tearDown() throws Exception {
    }
}
