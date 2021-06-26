package com.example.demo.Controller;

import com.example.demo.Entity.Item;
import com.example.demo.Service.ItemBusinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinesService itemBusinesService;

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1,"Ball",10,100,4);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService(){
        return itemBusinesService.retrieveHardCodedItem();
    }

    @GetMapping("/all-items-from-dabatase")
    public List<Item> allItems(){
        return itemBusinesService.retrieveAllItems();
    }

}
