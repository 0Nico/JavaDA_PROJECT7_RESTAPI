package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;

@Service
public class TradeService {

	@Autowired
    private TradeRepository tradeRepository;
	
	public Trade getTrade(Integer id) {
		
		return tradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid trade Id:" + id));
	}
	
	
	public List<Trade> getAllTrades() {
		
		return tradeRepository.findAll();
	}
	
	
	public void saveTrade(Trade trade) {
		
		tradeRepository.save(trade);
	}
	
	public void deleteTrade(Integer id) {
		
		Trade trade = tradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid trade Id:" + id));
		tradeRepository.delete(trade);
	}
}
