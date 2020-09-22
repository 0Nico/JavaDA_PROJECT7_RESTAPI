package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;

@Service
public class CurvePointService {

	@Autowired
    private CurvePointRepository curvePointRepository;
	
	public CurvePoint getCurvePoint(Integer id) {
		
		return curvePointRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid curvePoint Id:" + id));
	}
	
	
	public List<CurvePoint> getAllCurvePoints() {
		
		return curvePointRepository.findAll();
	}
	
	
	public void saveCurvePoint(CurvePoint curvePoint) {
		
		curvePointRepository.save(curvePoint);
	}
	
	public void deleteCurvePoint(Integer id) {
		
		CurvePoint curvePoint = curvePointRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid curvePoint Id:" + id));
		curvePointRepository.delete(curvePoint);
	}
}
