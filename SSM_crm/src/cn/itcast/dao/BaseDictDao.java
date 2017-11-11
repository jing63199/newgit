
package cn.itcast.dao;

import java.util.List;

import cn.itcast.pojo.BaseDict;

public interface BaseDictDao {

	//根据业务的种类code查询该业务下的所有种类
	
	public List<BaseDict> findDictItemByCode(String id);
	
	
}
