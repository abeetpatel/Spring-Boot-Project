package com.rays.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAO {

	@PersistenceContext
	public EntityManager entityManager;

	public long add(UserDTO dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(UserDTO dto) {
		entityManager.merge(dto);
	}

	public void delete(UserDTO dto) {
		entityManager.remove(dto);
	}

	public UserDTO findByPk(long pk) {
		UserDTO dto = entityManager.find(UserDTO.class, pk);
		return dto;
	}
}