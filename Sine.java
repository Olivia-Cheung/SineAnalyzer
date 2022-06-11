package SineAnalyzer;

/**
 * Implementations of static methods for a naive and a fast 
 * algorithm for a power series expansion of the sin function.
 * @author Duncan, Olivia Cheung
 * <pre>
 * File: Sine.java
 * Date: 99-99-99
 * Course: csc 3102
 * Programming Project # 0
 * Instructor: Dr. Duncan 
 *
 * Note: sin(x) = sum_{i=1}^{\inf}{(-1)^{i-1}*x^{2i-1}/(2i-1)!}
 * 
 * DO NOT REMOVE THIS NOTICE (GNU GPL V2):
 * Contact Information: duncanw@lsu.edu
 * Copyright (c) 2021 William E. Duncan
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>
 * </pre>
 */
public class Sine
{
	/**
	 * Approximates sin(x) using a power series expansion of 
	 * the function and a fast algorithm as described on the handout.
	 * @param x the angle in radians
	 * @param n the number of terms 
     * @throw IllegalArgumentException when n < 0
     */	 
    public static double fastSine(double x, int n) throws IllegalArgumentException{
		if (n<0) {
			
			throw new IllegalArgumentException("Error: Invalid number");
		}
		
		double term = x; 
		double sum = 0; 
		
		for (int i = 1; i <= n; i++) {
			
			if (i % 2 == 0) {
				
				sum = sum - term; 
			}
			
			else {
				
				sum = sum + term; 
			}
			
			term = term * (x / (2 * i)) * (x / ((2 * i) + 1));
		}
		
        return sum;
    }
	
	/**
	 * Approximates sin(x) using a power series expansion of 
	 * the function and a naive algorithm as described on the handout.
	 * @param x the angle in radians
	 * @param n the number of terms 
     * @throw IllegalArgumentException when n < 0
     */	    
    public static double naiveSine(double x, int n) throws IllegalArgumentException{
    	
    	if (n < 0) {
    		
    		throw new IllegalArgumentException("Error: Invalid number");
    	}
    	
    	double sum = 0; 
    	
    	for (int i = 1; n >= i; i++) {
    		
    		double term = 1; 
    		
    		for (int j = 1; j <= ((2*i)-1); j++) {
    			
    			term = term * (x / j);
    		}
    		
    		if (i % 2 == 0) {
    			
    			sum = sum - term;
    		}
    		
    		else {
    			
    			sum = sum + term; 
    		}
    		
    		
    	}
    	
        return sum;
    }
}