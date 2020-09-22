package com.nnk.springboot;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.services.RuleNameService;

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
public class RuleTests {

	@Autowired
	private RuleNameService ruleNameService;

	@Test
	public void ruleTest() {
		RuleName rule = new RuleName();
		rule.setName("Rule Name");
		rule.setDescription("Description");
		rule.setJson("Json");
		rule.setTemplate("Template");
		rule.setSqlStr("SQL");
		rule.setSqlPart("SQL Part");

		// Save
		ruleNameService.saveRuleName(rule);
		rule = ruleNameService.getRuleName(rule.getId());
		Assert.assertNotNull(rule.getId());
		Assert.assertTrue(rule.getName().equals("Rule Name"));

		// Update
		rule.setName("Rule Name Update");
		ruleNameService.saveRuleName(rule);
		rule = ruleNameService.getRuleName(rule.getId());
		Assert.assertTrue(rule.getName().equals("Rule Name Update"));

		// Find
		List<RuleName> listResult = ruleNameService.getAllRuleNames();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = rule.getId();
		ruleNameService.deleteRuleName(id);
		assertThrows(IllegalArgumentException.class , () ->  ruleNameService.getRuleName(id));
	}
}
