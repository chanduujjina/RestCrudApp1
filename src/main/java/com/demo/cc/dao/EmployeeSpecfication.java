package com.demo.cc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.demo.cc.dto.SearchCritria;
import com.demo.cc.model.Employee;

import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;

public class EmployeeSpecfication {
	
	public static Specification<Employee> filterData(SearchCritria searchCritria){
		
		
	return (root,query,cb) -> {
			
			List<Predicate> predicates = new ArrayList<>();
			
			if (searchCritria.getGender() != null) {
				Predicate pr1 = cb.equal(root.get("gender"), searchCritria.getGender());
				predicates.add(pr1);
			}
			
			if (searchCritria.getDeptName() != null) {
				Predicate pr2 = cb.equal(root.join("department",JoinType.INNER).get("name"),searchCritria.getDeptName());
				predicates.add(pr2);
			}
			
			
			return cb.and(predicates.toArray(new Predicate[0]));//combining all predicate to singlr predicate by using and operator
		};
		
		
		
	}

}
