package com.tcs.utils;

public class RandomSort {
	
	private Float timeTakenToSort = 0f;
	private Integer noOfPositionsSwapped = 0;
	
	public RandomSort randomSort(Integer numberArray[]) {
		
		long startTime = System.currentTimeMillis();
		
		while(!isSorted(numberArray)) {
			shuffle(numberArray);
		}
		
		long stopTime = System.currentTimeMillis();
		timeTakenToSort = (float) ((stopTime - startTime) / 1000);
		
		return this;
	}
	
	private void shuffle(Integer[] numberArray) {
		for(int index = 0; index < numberArray.length; ++index) {
			int index1 = (int) (Math.random() * numberArray.length),
				index2 = (int) (Math.random() * numberArray.length);
			int tmpValue = numberArray[index1];
			numberArray[index1] = numberArray[index2];
			numberArray[index2] = tmpValue;
			
			// Increment the count
			noOfPositionsSwapped++;
		}
	}

	private boolean isSorted(Integer[] numberArray) {
		for(int index = 0; index < numberArray.length - 1; ++index) {
			if(numberArray[index] > numberArray[index+1]) {
				return false;
			}
		}
		return true;
	}

	public Float getTimeTakenToSort() {
		return timeTakenToSort;
	}

	public void setTimeTakenToSort(Float timeTakenToSort) {
		this.timeTakenToSort = timeTakenToSort;
	}

	public Integer getNoOfPositionsSwapped() {
		return noOfPositionsSwapped;
	}

	public void setNoOfPositionsSwapped(Integer noOfPositionsSwapped) {
		this.noOfPositionsSwapped = noOfPositionsSwapped;
	}
}