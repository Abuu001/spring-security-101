package com.example.demo.Service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStub implements DataService{

    @Override
    public int[] retriverAllData() {
        return new int[] {1,2,3};
    }
}

class SomeDataServiceWithOneValue implements DataService{

    @Override
    public int[] retriverAllData() {
        return new int[] {5};
    }
}

class BusinessImplSubTest {

    @Test
    void calculateSumUsingDataService() {
        BusinessImpl business = new BusinessImpl();
        business.setDataService(new SomeDataServiceStub());

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;

        assertEquals(expectedResult,actualResult);
    }

    @Test
    void calculateSumWithOneValue() {
        BusinessImpl business = new BusinessImpl();
        business.setDataService(new SomeDataServiceWithOneValue());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;

        assertEquals(expectedResult,actualResult);
    }
}