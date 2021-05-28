package test.subclasses;

import main.subclasses.Effectiveness;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class EffectivenessTest {
    private Effectiveness effectivenessSmall;
    private Effectiveness effectivenessMedium;
    private Effectiveness effectivenessHigh;

    @Before
    public void setUp() throws Exception {
        effectivenessSmall = new Effectiveness("NISKA");
        effectivenessMedium = new Effectiveness("ŚREDNIA");
        effectivenessHigh = new Effectiveness("WYSOKA");
    }

    @Test
    public void testEffectivenessException() {
        Exception thrown = Assertions.assertThrows(
                Exception.class,
                () -> new Effectiveness("small"),
                "The efficiency value must be NISKA, ŚREDNIA or WYSOKA"
        );

        Assertions.assertEquals(thrown.getMessage(), "The efficiency value must be NISKA, ŚREDNIA or WYSOKA");
    }

    @Test
    public void testGetEffectivenessSmall() {
        Assertions.assertEquals("NISKA", effectivenessSmall.getEffectiveness());
    }

    @Test
    public void testGetValueSmall() {
        Assertions.assertEquals(60, effectivenessSmall.getValue());
    }

    @Test
    public void testGetEffectivenessMedium() {
        Assertions.assertEquals("ŚREDNIA", effectivenessMedium.getEffectiveness());
    }

    @Test
    public void testGetValueMedium() {
        Assertions.assertEquals(90, effectivenessMedium.getValue());
    }

    @Test
    public void testGetEffectivenessHigh() {
        Assertions.assertEquals("WYSOKA", effectivenessHigh.getEffectiveness());
    }

    @Test
    public void testGetValueHigh() {
        Assertions.assertEquals(120, effectivenessHigh.getValue());
    }
}
