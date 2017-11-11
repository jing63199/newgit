package cn.itcast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.constant.UtilsConstant;
import cn.itcast.pojo.BaseDict;
import cn.itcast.pojo.Customer;
import cn.itcast.pojo.QueryVo;
import cn.itcast.service.BaseDictService;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.Page;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	
	
	@RequestMapping("/list")
	public String findCustomerList(QueryVo vo,Model model) throws Exception{
		
		
		//处理乱码  get乱码处理
		if(vo!=null){
			String custName = vo.getCustName();
			if(custName!=null && !"".equals(custName)){
				String name = new String(custName.getBytes("iso-8859-1"),"utf-8");
				vo.setCustName(name);
			}else{
			}
		}
		//设置vo的start属性
		vo.setStart((vo.getPage()-1)*vo.getSize());
		//查询每页条数
		List<Customer> cutomerList=customerService.findCustomerByQueryVo(vo);
		//查询条件符合的条数
		Integer custListCount =customerService.findCustomerCount(vo);
		//page的属性     当前页    总条数      每页数据
		Page page = new Page();
		page.setPage(vo.getPage());
		page.setSize(vo.getSize());
		page.setTotal(custListCount);
		page.setRows(cutomerList);
		
	
		//存page数据得到request
		model.addAttribute("page", page);
		//数据的回响
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		model.addAttribute("custSource", vo.getCustSource());
		
		return "customer/customer";
	}
	
	
	
	/**
	 * /toEdit
	 * 跳转修改
	 */
	@RequestMapping("/toEdit")
	@ResponseBody
	public Customer findCustomerById(Integer id) throws Exception{
		
		Customer customer=customerService.findCustomerById(id);
		
		return customer;
	}
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String update(Customer customer) throws Exception{
		//更新操作
		customerService.updateCustomerById(customer);
		return "ok";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Integer id)throws Exception{
		
		customerService.deleteCustomerById(id);
		return "ok";
	}
	
}
