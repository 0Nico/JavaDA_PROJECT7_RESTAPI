package com.nnk.springboot;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.services.CurvePointService;

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
public class CurvePointTests {

	@Autowired
	private CurvePointService curvePointService;

	@Test
	public void curvePointTest() {
		
		CurvePoint curvePoint = new CurvePoint();
		curvePoint.setCurveId(10);
		curvePoint.setTerm(10d);
		curvePoint.setValue(30d);

		// Save
		curvePointService.saveCurvePoint(curvePoint);
		curvePoint = curvePointService.getCurvePoint(curvePoint.getId());
		Assert.assertNotNull(curvePoint.getId());
		Assert.assertTrue(curvePoint.getCurveId() == 10);

		// Update
		curvePoint.setCurveId(20);
		curvePointService.saveCurvePoint(curvePoint);
		curvePoint = curvePointService.getCurvePoint(curvePoint.getId());
		Assert.assertTrue(curvePoint.getCurveId() == 20);

		// Find
		List<CurvePoint> listResult = curvePointService.getAllCurvePoints();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = curvePoint.getId();
		curvePointService.deleteCurvePoint(id);
		assertThrows(IllegalArgumentException.class , () ->  curvePointService.getCurvePoint(id));
	}

}
