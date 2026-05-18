package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {

    @Parameters(name = "Пол: \"{0}\" -> грива: {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Parameter(0)
    public String sex;

    @Parameter(1)
    public boolean expectedHasMane;

    @Test
    public void doesHaveManeShouldReturnCorrectValueForSex() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, sex);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}