package cn.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.dao.BaseDictDao;
import cn.itcast.pojo.BaseDict;

@Service
public class BaseServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictDao baseDictDao;

	@Override
	public List<BaseDict> findDictItemByCode(String string) {
		List<BaseDict> list = baseDictDao.findDictItemByCode(string);
		return list;
	}
	
	
	
}
