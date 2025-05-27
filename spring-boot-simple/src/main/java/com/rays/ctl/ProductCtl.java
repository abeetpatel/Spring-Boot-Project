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
import com.rays.dto.ProductDTO;
import com.rays.form.ProductForm;
import com.rays.service.AttachmentService;
import com.rays.service.ProductService;

@RestController
@RequestMapping(value = "Product")
public class ProductCtl extends BaseCtl{
	
	@Autowired
	public ProductService productService;
	
	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid ProductForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		ProductDTO dto = (ProductDTO) form.getDto();

		if (dto.getId() != null && dto.getId() > 0) {
			productService.update(dto);
			res.addData(dto.getId());
			res.addMessage("Data Updated Successfully..!!");
		} else {
			long pk = productService.add(dto);
			res.addData(pk);
			res.addMessage("Data added Successfully..!!");
		}
		return res;
	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {

		ORSResponse res = new ORSResponse();

		ProductDTO dto = productService.findById(id);

		res.addData(dto);

		return res;
	}

	@GetMapping("delete/{ids}")
	public ORSResponse delete(@PathVariable long[] ids) {

		ORSResponse res = new ORSResponse();

		for (long id : ids) {
			productService.delete(id);
		}

		res.addMessage("data deleted successfully");

		return res;
	}

	@PostMapping("search/{pageNo}")
	public ORSResponse search(@RequestBody ProductForm form, @PathVariable int pageNo) {

		ORSResponse res = new ORSResponse();

		ProductDTO dto = (ProductDTO) form.getDto();

		List list = productService.search(dto, pageNo, 5);

		if (list.size() == 0) {
			res.addMessage("Result not found...!!!");
		} else {
			res.addData(list);
		}
		return res;
	}

}
