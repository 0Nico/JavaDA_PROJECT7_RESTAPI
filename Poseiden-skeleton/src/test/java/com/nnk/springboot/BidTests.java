package com.nnk.springboot;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.BidListService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BidTests {

	@Autowired
	private BidListService bidListService;

	@Test
	public void bidListTest() {
		
		BidList bid = new BidList();
		bid.setAccount("AccountTest");
		bid.setType("Type Test");
		bid.setBidQuantity(10d);

		// Save
		bidListService.saveBidList(bid);
		bid = bidListService.getBidList(bid.getBidListId());
		Assert.assertNotNull(bid.getBidListId());
		Assert.assertEquals(bid.getBidQuantity(), 10d, 10d);

		// Update
		bid.setBidQuantity(20d);
		bidListService.saveBidList(bid);
		bid = bidListService.getBidList(bid.getBidListId());
		Assert.assertEquals(bid.getBidQuantity(), 20d, 20d);

		// Find
		List<BidList> listResult = bidListService.getAllBidLists();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = bid.getBidListId();
		bidListService.deleteBidList(id);
		assertThrows(IllegalArgumentException.class , () -> bidListService.getBidList(id));
	}
}
