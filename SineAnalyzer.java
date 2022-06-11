/**
* EXPLAIN THE PURPOSE OF THIS FIlE
* CSC 3102 Programming Project # 0
* @author Olivia Cheung
* @since 9/10/2021
* @see A LIST OF FILES THAT IT DIRECTLY REFERENCES
*/


package SineAnalyzer;

import java.util.Random;

/**
 * Implementations for a naive and a fast algorithm
 * for a power series expansion of the sin function.
 * @author Duncan, Olivia Cheung
 * @see Sine.java
 * <pre>
 * File: SineAnalyzer.java
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

public class SineAnalyzer
{
	public static void main(String[] args) 
	{
		
		//Printing out Naive and Fast Sine Algorithms 
		System.out.println("Using Naive Algorithm:\n ");
		
		System.out.printf("sin(pi/6) = %.5f\n", Sine.naiveSine(Math.PI/6, 1000));
		System.out.printf("sin(pi/4) = %.5f\n", Sine.naiveSine(Math.PI/4, 1000));
		System.out.printf("sin(pi/3) = %.5f\n", Sine.naiveSine(Math.PI/3, 1000));
		System.out.printf("sin(pi/2) = %.5f\n", Sine.naiveSine(Math.PI/2, 1000));
		System.out.printf("sin(-pi/2) = %.5f\n", Sine.naiveSine(-Math.PI/2, 1000));
		System.out.println("\n");
		
		System.out.println("Using Fast Algorithm: \n");
		
		System.out.printf("sin(pi/6) = %.5f\n", Sine.fastSine(Math.PI/6, 1000));
		System.out.printf("sin(pi/4) = %.5f\n", Sine.fastSine(Math.PI/4, 1000));
		System.out.printf("sin(pi/3) = %.5f\n", Sine.fastSine(Math.PI/3, 1000));
		System.out.printf("sin(pi/2) = %.5f\n", Sine.fastSine(Math.PI/2, 1000));
		System.out.printf("sin(-pi/2) = %.5f\n", Sine.fastSine(-Math.PI/2, 1000));
		
		
		//Creating a random radian 
		Random generator = new Random(System.currentTimeMillis());
		int number = generator.nextInt(361); 
		double angle = number * Math.PI/180;
	
		System.out.printf("x = %f \n", angle);
		
		System.out.println("===============================================================");
		System.out.printf("%-1s %30s  %30s", "n", "sin x: Naive-Sine(ns)", "sin x: Fast-Sine(ns)\n" );
		System.out.println("---------------------------------------------------------------");
		
		
		//Creating a chart for time complexity 
		for (int i = 100; i <= 1000; i += 100) {
			
			
			
			long naiveStart = System.nanoTime();
			
			Sine.naiveSine(angle, i);
		   
		    long naiveElapsed = System.nanoTime() - naiveStart;
		    

			long fastStart = System.nanoTime();
			
			Sine.fastSine(angle, i);
			
			long fastElapsed = System.nanoTime() - fastStart;
		    
			
		    System.out.printf("%-5d %20d %30d \n", i, naiveElapsed, fastElapsed);
			
			
		}
		
	    System.out.println("===============================================================");
	}
}