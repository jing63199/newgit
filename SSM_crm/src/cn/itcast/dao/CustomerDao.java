package cn.itcast.dao;

import java.util.List;

import cn.itcast.pojo.Customer;
import cn.itcast.pojo.QueryVo;

public interface CustomerDao {
	
	//根据查询条件查询客户信息，当前页的页面
	public List<Customer> findCustomerByQueryVo(QueryVo vo) throws Exception;
	//根据条件查询总记录数
	public Integer findCustomerCount(QueryVo vo) throws Exception;
	//根据id查找customer
	public Customer findCustomerById(Integer id);
	//根据id更新数据
	public void updateCustomerById(Customer customer);
	//根据id删除信息
	public void deleteCustomerById(Integer id);
	

}
