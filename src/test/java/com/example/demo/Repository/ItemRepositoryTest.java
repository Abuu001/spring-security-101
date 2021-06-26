package com.example.demo.Repository;

import com.example.demo.Entity.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
class ItemRepositoryTest {

    @Autowired
    private  ItemRepository itemRepository;

    @Test
    public void testFindAll(){
        List<Item> items = itemRepository.findAll();

        assertEquals(0,items.size());


        assertThat("").isEmpty();
        assertThat("ABCDE")
                .contains("BCD")
                .endsWith("DE")
                .startsWith("AB");
    }
}