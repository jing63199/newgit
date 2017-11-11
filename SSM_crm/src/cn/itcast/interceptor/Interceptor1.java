package cn.itcast.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.constant.UtilsConstant;
import cn.itcast.pojo.BaseDict;
import cn.itcast.service.BaseDictService;

public class Interceptor1 implements HandlerInterceptor {

	@Autowired
	private BaseDictService baseDictService;
	
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 执行时机，在进入controller之后
	 * return 之前
	 */
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2, ModelAndView modelAndView)
			throws Exception {
		
		
		String path = request.getServletPath();
		
		if("/customer/list.action".equals(path)){
			//下拉选框
			//查询所有客户来源
			List<BaseDict> sourceList = baseDictService.findDictItemByCode(UtilsConstant.DICT.CUST_SOURCE);
			//查询所行业
			List<BaseDict> industryList=baseDictService.findDictItemByCode(UtilsConstant.DICT.CUST_INDUSTRY);
			//查询所有级别
			List<BaseDict> levelList=baseDictService.findDictItemByCode(UtilsConstant.DICT.CUST_LEVEL);
			
			
			modelAndView.addObject("fromType", sourceList);
			modelAndView.addObject("industryType", industryList);
			modelAndView.addObject("levelType", levelList);
			
			/*
			model把数据存到request域中  （下拉选择框）
			
			model.addAttribute("fromType", sourceList);
			model.addAttribute("industryType", industryList);
			model.addAttribute("levelType", levelList);*/
		}
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

}
