package com.example.demo.Service;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class) //Junit 4
@ExtendWith(MockitoExtension.class) //Junit 5
class BusinessImplMockTest {

    @InjectMocks
    BusinessImpl business; //OR   BusinessImpl business = new BusinessImpl();

    @Mock
    DataService dataServiceMock;   //OR  DataService dataServiceMock = mock(DataService.class);

    @Test
    void calculateSumUsingDataService() {

        when(dataServiceMock.retriverAllData()).thenReturn(new int[] {1,2,3});
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;

        assertEquals(expectedResult,actualResult);
    }

    @Test
    void calculateSumWithOneValue() {

        when(dataServiceMock.retriverAllData()).thenReturn(new int[] {2});
        assertEquals(2,business.calculateSumUsingDataService());
    }

}