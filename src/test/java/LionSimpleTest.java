package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionSimpleTest {

    @Test
    public void getKittensShouldReturnOne() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.getKittens()).thenReturn(1);

        Lion lion = new Lion(mockFeline, "Самец");
        assertEquals(1, lion.getKittens());
    }

    @Test(expected = Exception.class)
    public void constructorShouldThrowExceptionForInvalidSex() throws Exception {
        Feline mockFeline = mock(Feline.class);
        new Lion(mockFeline, "неверный_пол");
    }

    @Test
    public void getFoodShouldDelegateToFeline() throws Exception {
        // Arrange
        Feline mockFeline = mock(Feline.class);
        List<String> expectedFood = Arrays.asList("Животные", "Мясо", "Птицы");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion(mockFeline, "Самец");


        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
        verify(mockFeline, times(1)).getFood("Хищник");
    }
}