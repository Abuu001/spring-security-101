package com.example.demo.Service;

import com.example.demo.Entity.Item;
import com.example.demo.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinesService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardCodedItem() {
        return new Item(2,"Laptop",77,6,4);
    }

    public List<Item> retrieveAllItems(){

        List<Item> items = itemRepository.findAll();

        for(Item item:items){
            item.setValue(item.getPrice() * item.getQuantity());
        }

        return items;
    }
}
