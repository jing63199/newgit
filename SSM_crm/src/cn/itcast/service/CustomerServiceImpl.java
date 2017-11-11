package cn.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.dao.CustomerDao;
import cn.itcast.pojo.Customer;
import cn.itcast.pojo.QueryVo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> findCustomerByQueryVo(QueryVo vo) throws Exception {
		List<Customer> list = customerDao.findCustomerByQueryVo(vo);
		return list;
	}

	@Override
	public Integer findCustomerCount(QueryVo vo) throws Exception {
		Integer count = customerDao.findCustomerCount(vo);
		return count;
	}

	@Override
	public Customer findCustomerById(Integer id) throws Exception {
		Customer customer = customerDao.findCustomerById(id);
		return customer;
	}

	@Override
	public void updateCustomerById(Customer customer ) {
		customerDao.updateCustomerById(customer);
	}

	@Override
	public void deleteCustomerById(Integer id) {
		customerDao.deleteCustomerById(id);
		
	}

}
