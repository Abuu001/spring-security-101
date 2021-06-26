package com.example.demo.Service;

import com.example.demo.Entity.Item;
import com.example.demo.Repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemBusinesServiceTest {

    @InjectMocks
    private ItemBusinesService itemBusinesService;

    @Mock
    private  ItemRepository itemRepository;

    @Test
    void retrieveAllItems() {

        when(itemRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Item(15,"Pencil",11,20,220),
                        new Item(16,"Book",6,21,126)
        ));

        List<Item> items = itemBusinesService.retrieveAllItems();

        assertEquals(220,items.get(0).getValue());
        assertEquals(126,items.get(1).getValue());
    }
}