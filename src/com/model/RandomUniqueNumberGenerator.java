package com.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomUniqueNumberGenerator {

	public static final int SET_SIZE_REQUIRED = 19;
    public static final int NUMBER_RANGE = 20;
    
    static int i=0;
    
    public RandomUniqueNumberGenerator(){
    	}
    
    
    
    
    public  Set random() {
        Random random = new Random();
        
        Set set = new HashSet<Integer>(SET_SIZE_REQUIRED);

        while(set.size()< SET_SIZE_REQUIRED) {
            while (set.add(random.nextInt(NUMBER_RANGE)) != true)
                ;
        }
        assert set.size() == SET_SIZE_REQUIRED;
        System.out.println(set);
		
        return set;
    }
    
    public int getNum(){
    	
    	if(i<20){
    		Set set=random();
			Integer[] j= (Integer[]) set.toArray(new Integer[set.size()]);
			i=j[i];
			i++;
    	}  	
    	
    	
    	return i;
    			
    	
    	
    	
    	
    }
    
    
}