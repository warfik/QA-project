import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrackingServiceTest {

    @Before
    public void setUp() throws Exception {
    }
        TrackingService trackingService = new TrackingService();
// тест на обнуление калорий при добавлении 0 калорий.
        @Test
        public void test01(){
            int amount = 0;
            trackingService.addCalories(amount);
            assertEquals(0,trackingService.getTotal());
        }
// тест на добавление количества калорий равное нулю, в элементы массива
        @Test
        public void test02(){
            int amount = 0;
            trackingService.addCalories(amount);

            assertEquals(0, trackingService.getHistory().get(0).getId());
            assertEquals(0, trackingService.getHistory().get(0).getAmount());
            assertEquals("add", trackingService.getHistory().get(0).getOperation());
            assertEquals(0, trackingService.getHistory().get(0).getTotal());
        }
// тест на добавление и суммирование калорий в общем количестве
        @Test
        public void test03(){
            int amount = 20;
            trackingService.addCalories(amount);
            assertEquals(20,trackingService.getTotal());
            trackingService.addCalories(amount);
            assertEquals(40,trackingService.getTotal());
            trackingService.addCalories(amount);
            assertEquals(60,trackingService.getTotal());
        }
// тест на добавление калорий и суммирование результата с созданием двух элементов массива историй
        @Test
        public void test04(){
            int amount = 5;
            trackingService.addCalories(amount);
            trackingService.addCalories(amount);

            assertEquals(0, trackingService.getHistory().get(0).getId());
            assertEquals(5, trackingService.getHistory().get(0).getAmount());
            assertEquals("add", trackingService.getHistory().get(0).getOperation());
            assertEquals(5, trackingService.getHistory().get(0).getTotal());

            assertEquals(1, trackingService.getHistory().get(1).getId());
            assertEquals(5, trackingService.getHistory().get(1).getAmount());
            assertEquals("add", trackingService.getHistory().get(1).getOperation());
            assertEquals(10, trackingService.getHistory().get(1).getTotal());
        }
//тест на обнуление калорий
        @Test
        public void test05(){
            int amount = 9;
            trackingService.removeCalories(amount);
            assertEquals(0, trackingService.getTotal());
        }
// тест на удаление калорий из результата набранных калорий.
        @Test
        public void test06(){
            int addAmount = 19;
            trackingService.addCalories(addAmount);
            int removeAmount = 9;
            trackingService.removeCalories(removeAmount);
            assertEquals(10, trackingService.getTotal());
        }
// тест на добавление и удаление калорий и суммирование результатв с созданием двух элементов массива историй
        @Test
        public void test07(){
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
// тест на неравенство итогов (итог меньше, чем нужно)
        @Test
        public void test08 (){
            trackingService.setGoal(10);
            int amount = 9;
            trackingService.addCalories(amount);
            assertFalse (trackingService.isGoalMet());
        }
// тест на равенство итога и конечной цели
        @Test
        public void test09(){
            trackingService.setGoal(19);
            int amount = 19;
            trackingService.addCalories(amount);
            assertTrue (trackingService.isGoalMet());
        }
// тест на равенство итога и конечной цели (итог больше, чем нужно)
        @Test
        public void test10 (){
            trackingService.setGoal(10);
            int amount = 19;
            trackingService.addCalories(amount);
            assertTrue (trackingService.isGoalMet());
        }

    @After
    public void tearDown() throws Exception {
    }
}
