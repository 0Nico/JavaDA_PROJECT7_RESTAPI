package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;

@Service
public class BidListService {

	@Autowired
    private BidListRepository bidListRepository;
	
	public BidList getBidList(Integer id) {
		
		return bidListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid bidList Id:" + id));
	}
	
	
	public List<BidList> getAllBidLists() {
		
		return bidListRepository.findAll();
	}
	
	
	public void saveBidList(BidList bidList) {
		
        bidListRepository.save(bidList);
	}
	
	public void deleteBidList(Integer id) {
		
		BidList bidList = bidListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid bidList Id:" + id));
		bidListRepository.delete(bidList);
	}
}
