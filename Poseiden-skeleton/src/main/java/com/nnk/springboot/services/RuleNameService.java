package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;

@Service
public class RuleNameService {

	@Autowired
    private RuleNameRepository ruleNameRepository;
	
	public RuleName getRuleName(Integer id) {
		
		return ruleNameRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ruleName Id:" + id));
	}
	
	
	public List<RuleName> getAllRuleNames() {
		
		return ruleNameRepository.findAll();
	}
	
	
	public void saveRuleName(RuleName ruleName) {
		
		ruleNameRepository.save(ruleName);
	}
	
	public void deleteRuleName(Integer id) {
		
		RuleName ruleName = ruleNameRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ruleName Id:" + id));
		ruleNameRepository.delete(ruleName);
	}
}
