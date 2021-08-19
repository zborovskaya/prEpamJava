package by.zborovskaya.task08.control.console;

import by.zborovskaya.task08.entity.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

public class ControllerTest {
    private final String PATH_XSD="src/main/resources/data/candy.xsd";
    private final String PATH_XML="src/main/resources/data/testCandy.xml";
    private Set<Candy> expected;
    private Controller controller;
    @BeforeClass
    public void init() throws Exception {
        Ingredients ingredientsChocolate=new IngredientsChocolate(3,20,5,5,"milk");
        Ingredients ingredientsCaramel=new IngredientsCaramel(5,30,5,5);
        Candy chocolateCandy=new ChocolateCandy("Little Red Riding Hood",300,
                "Kommunarka","shapka1235",0.3,
                0.1,90,"2021-05-24",ingredientsChocolate,"nothing");
        Candy caramelCandy=new CaramelCandy("Chupa-Chups",380,"Chupa-Chups","chupa1234",
                0.2,0,94,"2020-09-24",ingredientsCaramel);
        expected=new HashSet<Candy>();
        expected.add(chocolateCandy);
        expected.add(caramelCandy);
        controller=new Controller();
    }


    @Test
    public void testExecuteTaskDom() {
        Set<Candy>actual=controller.executeTask("DOM_PARSER",PATH_XSD,PATH_XML);
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testExecuteTaskSax() {
        Set<Candy>actual=controller.executeTask("SAX_PARSER",PATH_XSD,PATH_XML);
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testExecuteTaskStax() {
        Set<Candy>actual=controller.executeTask("STAX_PARSER",PATH_XSD,PATH_XML);
        Assert.assertEquals(actual, expected);
    }
}