package com.roadwhite.shop.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件名称 :    ResultBean.java
 * 内容摘要 :    
 * @author    White
 * @Version    2020年10月8日
 */
public class ResultBean{
	
	public ResultBean() {
		result = new HashMap<String, Object>();
	}
	
	private Map<String,Object> result;
	
	public void setMsg(String msg) {
		result.put("msg",msg);
	}
	
	public void setCode(int code) {
		result.put("code",code);
	}
	public void addObject(String name,Object obj) {
		result.put(name,obj);
	}

	public Map<String, Object> getResult() {
		return result;
	}
}
