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

import com.rays.dto.BlogDTO;

@Repository
public class BlogDAO {

	@PersistenceContext
	public EntityManager entityManager;

	public long add(BlogDTO dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(BlogDTO dto) {
		entityManager.merge(dto);
	}

	public void delete(BlogDTO dto) {
		entityManager.remove(dto);
	}

	public BlogDTO findByPk(long pk) {
		BlogDTO dto = entityManager.find(BlogDTO.class, pk);
		return dto;
	}

	public BlogDTO findByUniqueKey(String attribute, String value) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<BlogDTO> cq = builder.createQuery(BlogDTO.class);

		Root<BlogDTO> qRoot = cq.from(BlogDTO.class);

		Predicate condition = builder.equal(qRoot.get(attribute), value);

		cq.where(condition);

		TypedQuery<BlogDTO> tq = entityManager.createQuery(cq);

		List<BlogDTO> list = tq.getResultList();

		BlogDTO dto = null;

		if (list.size() > 0) {
			dto = list.get(0);
		}
		return dto;
	}

	public List search(BlogDTO dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<BlogDTO> cq = builder.createQuery(BlogDTO.class);

		Root<BlogDTO> qRoot = cq.from(BlogDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {

			if (dto.getTitle() != null && dto.getTitle().length() > 0) {
				predicateList.add(builder.like(qRoot.get("title"), dto.getTitle() + "%"));
			}

			if (dto.getContent() != null && dto.getContent().length() > 0) {
				predicateList.add(builder.like(qRoot.get("content"), dto.getContent() + "%"));
			}

			if (dto.getAuthor() != null && dto.getAuthor().length() > 0) {
				predicateList.add(builder.like(qRoot.get("author"), dto.getAuthor() + "%"));
			}
		}

		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));

		TypedQuery<BlogDTO> tq = entityManager.createQuery(cq);

		if (pageSize > 0) {
			tq.setFirstResult(pageNo * pageSize);
			tq.setMaxResults(pageSize);
		}

		List<BlogDTO> list = tq.getResultList();

		return list;
	}

}
