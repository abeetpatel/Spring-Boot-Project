package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAO;
import com.rays.dto.UserDTO;

@Service
@Transactional
public class UserService {

	@Autowired
	public UserDAO dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		long i = dao.add(dto);
		return i;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public long save(UserDTO dto) {
		long id = dto.getId();
		if (dto.getId() != null && dto.getId() > 0) {
			update(dto);
		} else {
			id = add(dto);
		}
		return id;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public UserDTO delete(long id) {
		UserDTO deletedUser = dao.delete(id);
		return deletedUser;
	}

	@Transactional(readOnly = true)
	public UserDTO findByPk(long pk) {
		UserDTO dto = dao.findByPk(pk);
		return dto;
	}

	public UserDTO authenticate(String login, String password) {
		UserDTO dto = dao.authenticate(login, password);
		return dto;
	}

	public UserDTO findByLogin(String login) {
		UserDTO dto = dao.findByLogin(login);
		return dto;
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		List list = dao.search(dto, pageNo, pageSize);
		return list;
	}
}