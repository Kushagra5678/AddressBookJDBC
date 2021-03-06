package com.practice.addressbook;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.practice.addressbook.AddressBookService.IOService;

public class AddressBookTest {
	@Test
	public void GivenData_ShouldMatchCount() {
		AddressBookService addBookService = new AddressBookService();
		List<AddressBookData> addBookData = addBookService.readAddresBookData(IOService.DB_IO);
    	Assert.assertEquals(4, addBookData.size());
    }
}
