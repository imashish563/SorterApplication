package com.tcs.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tcs.jpa.model.AppData;
import com.tcs.repository.AppDataRepository;

@RunWith(MockitoJUnitRunner.class)
public class SorterAppServiceTest {

	@Mock
	AppDataRepository appDataRepository;
	
	@InjectMocks
	SorterAppService sorterAppService;
	
	@Test
	public void testSortNumbers()  {
	
		String beforeSortString = "8, 1, 9, 6, 2";
		String expectedAfterSortString  = "[1, 2, 6, 8, 9]";
		
		when(appDataRepository.save(any(AppData.class))).thenReturn(new AppData());
		
		String afterSortString = sorterAppService.sortNumbers(beforeSortString);
		
		assertEquals(expectedAfterSortString, afterSortString);
	}
		
}
