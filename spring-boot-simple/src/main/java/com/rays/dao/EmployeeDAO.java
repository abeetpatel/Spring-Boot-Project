package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.EmployeeDTO;

@Repository
public class EmployeeDAO {
	
	@PersistenceContext
	public EntityManager entityManager;
	
	@Autowired
	public AttachmentDAO attachmentDao;
	
	public long add(EmployeeDTO dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(EmployeeDTO dto) {
		entityManager.merge(dto);
	}

	public void delete(EmployeeDTO dto) {
		entityManager.remove(dto);
	}

	public EmployeeDTO findByPk(long pk) {
		EmployeeDTO dto = entityManager.find(EmployeeDTO.class, pk);
		return dto;
	}

	public EmployeeDTO findByUniqueKey(String attribute, String value) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<EmployeeDTO> cq = builder.createQuery(EmployeeDTO.class);

		Root<EmployeeDTO> qRoot = cq.from(EmployeeDTO.class);

		Predicate condition = builder.equal(qRoot.get(attribute), value);

		cq.where(condition);

		TypedQuery<EmployeeDTO> tq = entityManager.createQuery(cq);

		List<EmployeeDTO> list = tq.getResultList();

		EmployeeDTO dto = null;

		if (list.size() > 0) {
			dto = list.get(0);
		}
		return dto;
	}

	public List search(EmployeeDTO dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<EmployeeDTO> cq = builder.createQuery(EmployeeDTO.class);

		Root<EmployeeDTO> qRoot = cq.from(EmployeeDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {

			if (dto.getName() != null && dto.getName().length() > 0) {
				predicateList.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
			}

			if (dto.getEmail() != null && dto.getEmail().length() > 0) {
				predicateList.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));
			}

			if (dto.getDepartment() != null && dto.getDepartment().length() > 0) {
				predicateList.add(builder.like(qRoot.get("department"), dto.getDepartment() + "%"));
			}
		}

		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));

		TypedQuery<EmployeeDTO> tq = entityManager.createQuery(cq);

		if (pageSize > 0) {
			tq.setFirstResult(pageNo * pageSize);
			tq.setMaxResults(pageSize);
		}

		List<EmployeeDTO> list = tq.getResultList();

		return list;
	}

}
