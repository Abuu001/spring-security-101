package com.example.demo.Service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessImplTest {

    @Test
    void calculateSum() {
        BusinessImpl business = new BusinessImpl();
        int actualResult = business.calculateSum(new int[] {1,2,3});
        int expectedResult = 6;

        assertEquals(expectedResult,actualResult);
    }

    @Test
    void calculateSumWithOneValue() {
        BusinessImpl business = new BusinessImpl();
        int actualResult = business.calculateSum(new int[] {3});
        int expectedResult = 3;

        assertEquals(expectedResult,actualResult);
    }
}