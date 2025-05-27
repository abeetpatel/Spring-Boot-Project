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
import com.rays.dto.BlogDTO;
import com.rays.form.BlogForm;
import com.rays.service.AttachmentService;
import com.rays.service.BlogService;

@RestController
@RequestMapping(value = "Blog")
public class BlogCtl extends BaseCtl{
	
	@Autowired
	public BlogService blogService;
	
	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid BlogForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		BlogDTO dto = (BlogDTO) form.getDto();

		if (dto.getId() != null && dto.getId() > 0) {
			blogService.update(dto);
			res.addData(dto.getId());
			res.addMessage("Data Updated Successfully..!!");
		} else {
			long pk = blogService.add(dto);
			res.addData(pk);
			res.addMessage("Data added Successfully..!!");
		}
		return res;
	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {

		ORSResponse res = new ORSResponse();

		BlogDTO dto = blogService.findById(id);

		res.addData(dto);

		return res;
	}

	@GetMapping("delete/{ids}")
	public ORSResponse delete(@PathVariable long[] ids) {

		ORSResponse res = new ORSResponse();

		for (long id : ids) {
			blogService.delete(id);
		}

		res.addMessage("data deleted successfully");

		return res;
	}

	@PostMapping("search/{pageNo}")
	public ORSResponse search(@RequestBody BlogForm form, @PathVariable int pageNo) {

		ORSResponse res = new ORSResponse();

		BlogDTO dto = (BlogDTO) form.getDto();

		List list = blogService.search(dto, pageNo, 5);

		if (list.size() == 0) {
			res.addMessage("Result not found...!!!");
		} else {
			res.addData(list);
		}
		return res;
	}

}
