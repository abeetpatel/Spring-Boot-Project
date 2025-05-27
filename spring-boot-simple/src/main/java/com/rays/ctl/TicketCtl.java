package com.rays.ctl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.TicketDTO;
import com.rays.form.TicketForm;
import com.rays.service.AttachmentService;
import com.rays.service.TicketService;

@RestController
@RequestMapping(value = "Ticket")
public class TicketCtl extends BaseCtl {

	@Autowired
	public TicketService ticketService;

	@Autowired
	public AttachmentService attachmentService;

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid TicketForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		TicketDTO dto = (TicketDTO) form.getDto();

		if (dto.getId() != null && dto.getId() > 0) {
			ticketService.update(dto);
			res.addData(dto.getId());
			res.addMessage("Data Updated Successfully..!!");
		} else {
			long pk = ticketService.add(dto);
			res.addData(pk);
			res.addMessage("Data added Successfully..!!");
		}
		return res;
	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {

		ORSResponse res = new ORSResponse();

		TicketDTO dto = ticketService.findById(id);

		res.addData(dto);

		return res;
	}

	@GetMapping("delete/{ids}")
	public ORSResponse delete(@PathVariable long[] ids) {

		ORSResponse res = new ORSResponse();

		for (long id : ids) {
			ticketService.delete(id);
		}

		res.addMessage("data deleted successfully");

		return res;
	}

	@PostMapping("search/{pageNo}")
	public ORSResponse search(@RequestBody TicketForm form, @PathVariable int pageNo) {

		ORSResponse res = new ORSResponse();

		TicketDTO dto = (TicketDTO) form.getDto();

		List list = ticketService.search(dto, pageNo, 5);

		if (list.size() == 0) {
			res.addMessage("Result not found...!!!");
		} else {
			res.addData(list);
		}
		return res;
	}

}
