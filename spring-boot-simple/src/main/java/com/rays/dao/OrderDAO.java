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

import com.rays.dto.OrderDTO;

@Repository
public class OrderDAO {

	@PersistenceContext
	public EntityManager entityManager;

	@Autowired
	public AttachmentDAO attachmentDao;

	public long add(OrderDTO dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(OrderDTO dto) {
		entityManager.merge(dto);
	}

	public void delete(OrderDTO dto) {
		entityManager.remove(dto);
	}

	public OrderDTO findByPk(long pk) {
		OrderDTO dto = entityManager.find(OrderDTO.class, pk);
		return dto;
	}

	public OrderDTO findByUniqueKey(String attribute, String value) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<OrderDTO> cq = builder.createQuery(OrderDTO.class);

		Root<OrderDTO> qRoot = cq.from(OrderDTO.class);

		Predicate condition = builder.equal(qRoot.get(attribute), value);

		cq.where(condition);

		TypedQuery<OrderDTO> tq = entityManager.createQuery(cq);

		List<OrderDTO> list = tq.getResultList();

		OrderDTO dto = null;

		if (list.size() > 0) {
			dto = list.get(0);
		}
		return dto;
	}

	public List search(OrderDTO dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<OrderDTO> cq = builder.createQuery(OrderDTO.class);

		Root<OrderDTO> qRoot = cq.from(OrderDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {

			if (dto.getQuantity() != 0 && dto.getQuantity() > 0) {
				predicateList.add(builder.equal(qRoot.get("quantity"), dto.getQuantity()));
			}

			if (dto.getTotalPrice() != 0 && dto.getTotalPrice() > 0) {
				predicateList.add(builder.equal(qRoot.get("totalPrice"), dto.getTotalPrice()));
			}

			if (dto.getOrderDate() != null && dto.getOrderDate().getTime() > 0) {
				predicateList.add(builder.equal(qRoot.get("orderDate"), dto.getOrderDate()));
			}
		}

		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));

		TypedQuery<OrderDTO> tq = entityManager.createQuery(cq);

		if (pageSize > 0) {
			tq.setFirstResult(pageNo * pageSize);
			tq.setMaxResults(pageSize);
		}

		List<OrderDTO> list = tq.getResultList();

		return list;
	}

}
