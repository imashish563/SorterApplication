package com.tcs.service;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.jpa.model.AppData;
import com.tcs.repository.AppDataRepository;
import com.tcs.utils.RandomSort;


@Service
@Transactional(readOnly = false, rollbackFor=Exception.class)
public class SorterAppService {

	private static final Logger LOGGER = Logger.getLogger(SorterAppService.class);
	
	@Autowired
	AppDataRepository appDataRepository;
	
	public String sortNumbers(String numbers) {
		
		LOGGER.info("Entering sortNumbers");
		
		// Converting the comma separated NUMBERS coming from UI into Integer Array
		Integer[] numbersArray = Arrays.stream(numbers.split(","))
		        .map(String::trim)
		        .map(Integer::valueOf)
		        .toArray(Integer[]::new);
		
		
		String sortedArray = sortArray(numbersArray);
		
		LOGGER.info("Exiting sortNumbers");
		return sortedArray;
	}
	
	private String sortArray(Integer[] numbers) {
		
		LOGGER.info("Entering sortArray");
		
		AppData appData = new AppData();
		appData.setNumbersBeforeSort(Arrays.asList(numbers).toString());
		
		// Sort the Array (Using Random sort algorithm from Sorting)
		RandomSort sortUtil = new RandomSort();
		sortUtil.randomSort(numbers);
		
		appData.setNumbersAfterSort(Arrays.asList(numbers).toString());
		appData.setTimeTakenToSort(sortUtil.getTimeTakenToSort());
		appData.setNoOfPositionsSwapped(sortUtil.getNoOfPositionsSwapped());
		
		// Save in DB
		appDataRepository.save(appData);
		
		LOGGER.info("Exiting sortArray");
		
		return Arrays.asList(numbers).toString();
	}
	
	public List<AppData> getAppData() {
		
		return appDataRepository.findAll();
	}
}
