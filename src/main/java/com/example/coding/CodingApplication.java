package com.example.coding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class CodingApplication {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8,9};

        int low = 0;
        int high = nums.length-1;

        while (low < high) {
            int mid = (low+high)/2;

            if (nums[mid] == 3) {
                high = mid;
            } else {
                low = mid+1;
            }
        }

        System.out.println(nums[low]);
        //SpringApplication.run(CodingApplication.class, args);
    }

}
