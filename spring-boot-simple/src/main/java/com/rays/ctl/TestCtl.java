package com.rays.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.dto.TestDTO;

@RestController
@RequestMapping(value = "Test")
public class TestCtl {

	@GetMapping
	public String display() {
		return "dispaly method";
	}

	@GetMapping("display1")
	public TestDTO display1() {

		TestDTO dto = new TestDTO();
		dto.setId(1L);
		dto.setFirstName("abc");
		dto.setLastName("xyz");
		dto.setLoginId("abc@gmail.com");
		dto.setPassword("123");
		dto.setDob("01-06-2025");

		return dto;
	}

	@GetMapping("display2")
	public ORSResponse display2() {

		ORSResponse res = new ORSResponse();

		return res;
	}

	@GetMapping("display3")
	public ORSResponse display3() {

		ORSResponse res = new ORSResponse();

		Map errors = new HashMap();
		errors.put("firstName", "first name is required");
		errors.put("lastName", "last name is required");
		errors.put("loginId", "login id is required");
		errors.put("password", "password is required");

		res.addInputError(errors);

		return res;
	}

	@GetMapping("display4")
	public ORSResponse display4() {

		ORSResponse res = new ORSResponse();

		TestDTO dto = new TestDTO();
		dto.setId(1L);
		dto.setFirstName("abc");
		dto.setLastName("xyz");
		dto.setLoginId("abc@gmail.com");
		dto.setPassword("123");
		dto.setDob("01-06-2025");

		res.addData(dto);

		return res;
	}

	@GetMapping("display5")
	public ORSResponse display5() {

		ORSResponse res = new ORSResponse();

		TestDTO dto1 = new TestDTO();
		dto1.setId(1L);
		dto1.setFirstName("abc");
		dto1.setLastName("abc");
		dto1.setLoginId("abc@gmail.com");
		dto1.setPassword("123");
		dto1.setDob("01-06-2025");

		TestDTO dto2 = new TestDTO();
		dto2.setId(2L);
		dto2.setFirstName("xyz");
		dto2.setLastName("xyz");
		dto2.setLoginId("xyz@gmail.com");
		dto2.setPassword("123");
		dto2.setDob("02-06-2025");

		List list = new ArrayList();

		list.add(dto1);
		list.add(dto2);

		res.addData(list);

		return res;
	}
	
	@GetMapping("display6")
	public ORSResponse display6() {

		ORSResponse res = new ORSResponse();

		res.addMessage("Data Added Successfully");

		return res;
	}

	@PostMapping
	public String submit() {
		return "submit method";
	}
}