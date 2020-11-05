package com.practice.addressbook;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.practice.addressbook.AddressBookService.IOService;

public class AddressBookTest {
	//UC16 and 17
	@Test
	public void GivenData_ShouldMatchCount() {
		AddressBookService addBookService = new AddressBookService();
		List<AddressBookData> addBookData = addBookService.readAddresBookData(IOService.DB_IO);
    	Assert.assertEquals(4, addBookData.size());
    	addBookService.updateFirstName("San", "Sanjay");
    	AddressBookData contact = addBookService.checkAddressBookInSync("Sanjay");
    	Assert.assertEquals("Sanjay", contact.first_name);
    }
	//UC18 
	@Test 
    public void givenDateRange_WhenRetrieved_ShouldMatchContactsCount() {
    	AddressBookService addBookService = new AddressBookService();
    	addBookService.readAddresBookData(IOService.DB_IO);
    	LocalDate startDate = LocalDate.of(2015, 03, 01);
    	LocalDate endDate = LocalDate.now();
    	List<AddressBookData> addBookData = addBookService.readAddressBookForDateRange(IOService.DB_IO, startDate, endDate);
    	Assert.assertEquals(4, addBookData.size());
    }
	//UC19
	@Test
	public void givenContactsData_WhenCountByCity_ShouldReturnProperValue() {
    	AddressBookService addBookService = new AddressBookService();
    	addBookService.readAddresBookData(IOService.DB_IO);
    	Map<String, Integer> countContactsByCity = addBookService.readCountContactsByCity(IOService.DB_IO);
    	Assert.assertTrue(countContactsByCity.get("saharanpur").equals(4));
    }
	
	@Test
	public void givenContactsData_WhenCountByState_ShouldReturnProperValue() {
    	AddressBookService addBookService = new AddressBookService();
    	addBookService.readAddresBookData(IOService.DB_IO);
    	Map<String, Integer> countContactsByState = addBookService.readCountContactsByState(IOService.DB_IO);
    	Assert.assertTrue(countContactsByState.get("UP").equals(4));
    }
}
