package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getSoundShouldReturnMeow() {
        Cat cat = new Cat(feline);
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(feline);
        assertEquals(expectedFood, cat.getFood());
    }
}