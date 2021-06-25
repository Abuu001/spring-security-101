package com.example.demo.Service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List mock =mock(List.class);

    @Test
    public void testSizeBasic(){

        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }

    @Test
    public void returnWithParameters(){
        when(mock.get(0)).thenReturn("abuu");
        assertEquals("abuu",mock.get(0));
    }

    @Test
    public void returnWithGenericParameters(){
        when(mock.get(anyInt())).thenReturn("abuu");
        assertEquals("abuu",mock.get(20));
        assertEquals("abuu",mock.get(77));
    }

    @Test
    public void mocking(){
        ArrayList arrayListMock = mock(ArrayList.class);

        arrayListMock.add("Abu");
        arrayListMock.add("Jamo");
        arrayListMock.add("Faith");
        arrayListMock.size();

        when(arrayListMock.size()).thenReturn(3);
    }

    @Test
    public void spying(){
        ArrayList arrayListSpy = spy(ArrayList.class);

        arrayListSpy.add("Abu");
        arrayListSpy.add("Jamo");
        arrayListSpy.add("Faith");
        System.out.println(arrayListSpy.size());

        when(arrayListSpy.size()).thenReturn(3);
    }
}
