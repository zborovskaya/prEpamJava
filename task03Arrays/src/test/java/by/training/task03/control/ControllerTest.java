package by.training.task03.control;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ControllerTest {

    @Test
    public void testExecuteTask() {
        Controller controller=new Controller();
        controller.executeTask("BUBBLE_SORTING",false);
    }
}