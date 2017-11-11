package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.BaseDict;

public interface BaseDictService {

	List<BaseDict> findDictItemByCode(String string);

}
