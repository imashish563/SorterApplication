package com.tcs.jpa.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "app_data")
public class AppData {

	@Id
	@GeneratedValue()
	@Column(name = "app_data_id")
	private Integer appDataId;
	
	@Column(name = "numbers_before_sort")
	private String numbersBeforeSort;
	
	@Column(name = "numbers_after_sort")
	private String numbersAfterSort;
	
	@Column(name = "time_taken_to_sort")
	private Float timeTakenToSort;
	
	@Column(name = "no_of_positions_swapped")
	private Integer noOfPositionsSwapped;

	
	public Integer getAppDataId() {
		return appDataId;
	}

	public void setAppDataId(Integer appDataId) {
		this.appDataId = appDataId;
	}

	public String getNumbersBeforeSort() {
		return numbersBeforeSort;
	}

	public void setNumbersBeforeSort(String numbersBeforeSort) {
		this.numbersBeforeSort = numbersBeforeSort;
	}

	public String getNumbersAfterSort() {
		return numbersAfterSort;
	}

	public void setNumbersAfterSort(String numbersAfterSort) {
		this.numbersAfterSort = numbersAfterSort;
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
