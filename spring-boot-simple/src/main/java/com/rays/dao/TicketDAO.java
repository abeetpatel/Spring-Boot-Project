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

import com.rays.dto.TicketDTO;

@Repository
public class TicketDAO {

	@PersistenceContext
	public EntityManager entityManager;

	@Autowired
	public AttachmentDAO attachmentDao;

	public long add(TicketDTO dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(TicketDTO dto) {
		entityManager.merge(dto);
	}

	public void delete(TicketDTO dto) {
		entityManager.remove(dto);
	}

	public TicketDTO findByPk(long pk) {
		TicketDTO dto = entityManager.find(TicketDTO.class, pk);
		return dto;
	}

	public TicketDTO findByUniqueKey(String attribute, String value) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<TicketDTO> cq = builder.createQuery(TicketDTO.class);

		Root<TicketDTO> qRoot = cq.from(TicketDTO.class);

		Predicate condition = builder.equal(qRoot.get(attribute), value);

		cq.where(condition);

		TypedQuery<TicketDTO> tq = entityManager.createQuery(cq);

		List<TicketDTO> list = tq.getResultList();

		TicketDTO dto = null;

		if (list.size() > 0) {
			dto = list.get(0);
		}
		return dto;
	}

	public List search(TicketDTO dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<TicketDTO> cq = builder.createQuery(TicketDTO.class);

		Root<TicketDTO> qRoot = cq.from(TicketDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {

			if (dto.getSubject() != null && dto.getSubject().length() > 0) {
				predicateList.add(builder.like(qRoot.get("subject"), dto.getSubject() + "%"));
			}

			if (dto.getCreatedBy() != null && dto.getCreatedBy().length() > 0) {
				predicateList.add(builder.equal(qRoot.get("createdBy"), dto.getCreatedBy()));
			}

			if (dto.getAssignedTo() != null && dto.getAssignedTo().length() > 0) {
				predicateList.add(builder.equal(qRoot.get("assignedTo"), dto.getAssignedTo()));
			}
		}

		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));

		TypedQuery<TicketDTO> tq = entityManager.createQuery(cq);

		if (pageSize > 0) {
			tq.setFirstResult(pageNo * pageSize);
			tq.setMaxResults(pageSize);
		}

		List<TicketDTO> list = tq.getResultList();

		return list;
	}
}
