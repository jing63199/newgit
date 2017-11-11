package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.Customer;
import cn.itcast.pojo.QueryVo;

public interface CustomerService {

	List<Customer> findCustomerByQueryVo(QueryVo vo) throws Exception;

	Integer findCustomerCount(QueryVo vo) throws Exception;

	Customer findCustomerById(Integer id)throws Exception;
	
	public void updateCustomerById(Customer customer);
	
	public void deleteCustomerById(Integer id);

}
