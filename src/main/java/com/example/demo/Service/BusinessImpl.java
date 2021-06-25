package com.example.demo.Service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
public class BusinessImpl {

    @Autowired
    private  DataService dataService;

    public int calculateSum(int[] data){
        int sum =0;

        for(int value:data){
            sum +=value;
        }
        return sum;
    }

    public int calculateSumUsingDataService(){
        int sum =0;
        int[] data = dataService.retriverAllData();

        for(int value:data){
            sum +=value;
        }
        return sum;
    }
}
