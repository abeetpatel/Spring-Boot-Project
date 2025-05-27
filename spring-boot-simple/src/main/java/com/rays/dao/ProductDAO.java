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

import com.rays.dto.ProductDTO;

@Repository
public class ProductDAO {

	@PersistenceContext
	public EntityManager entityManager;

	public long add(ProductDTO dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(ProductDTO dto) {
		entityManager.merge(dto);
	}

	public void delete(ProductDTO dto) {
		entityManager.remove(dto);
	}

	public ProductDTO findByPk(long pk) {
		ProductDTO dto = entityManager.find(ProductDTO.class, pk);
		return dto;
	}

	public ProductDTO findByUniqueKey(String attribute, String value) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<ProductDTO> cq = builder.createQuery(ProductDTO.class);

		Root<ProductDTO> qRoot = cq.from(ProductDTO.class);

		Predicate condition = builder.equal(qRoot.get(attribute), value);

		cq.where(condition);

		TypedQuery<ProductDTO> tq = entityManager.createQuery(cq);

		List<ProductDTO> list = tq.getResultList();

		ProductDTO dto = null;

		if (list.size() > 0) {
			dto = list.get(0);
		}
		return dto;
	}

	public List search(ProductDTO dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<ProductDTO> cq = builder.createQuery(ProductDTO.class);

		Root<ProductDTO> qRoot = cq.from(ProductDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {

			if (dto.getName() != null && dto.getName().length() > 0) {
				predicateList.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
			}

			if (dto.getDescription() != null && dto.getDescription().length() > 0) {
				predicateList.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
			}

			if (dto.getPrice() != 0 && dto.getPrice() > 0) {
				predicateList.add(builder.equal(qRoot.get("price"), dto.getPrice()));
			}

			if (dto.getCategory() != null && dto.getCategory().length() > 0) {
				predicateList.add(builder.like(qRoot.get("category"), dto.getCategory() + "%"));
			}
		}

		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));

		TypedQuery<ProductDTO> tq = entityManager.createQuery(cq);

		if (pageSize > 0) {
			tq.setFirstResult(pageNo * pageSize);
			tq.setMaxResults(pageSize);
		}

		List<ProductDTO> list = tq.getResultList();

		return list;
	}

}
