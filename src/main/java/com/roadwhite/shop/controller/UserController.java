package com.roadwhite.shop.controller;
/*
 * 
 */
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.roadwhite.shop.entity.ResultBean;
import com.roadwhite.shop.entity.Shop;
import com.roadwhite.shop.entity.order;
import com.roadwhite.shop.mapper.ShopMapper;

@Controller
public class UserController {
	@Autowired
	ShopMapper shopmapper;

	@RequestMapping(value = { "/getshop"})
	@ResponseBody
	public List<Shop> getshop(){
		return shopmapper.query();	
	}
	//获取上传图片
	@RequestMapping(value = { "/post"})
	@ResponseBody
	public String get(@RequestParam("file") MultipartFile file,String name,Double price,int num) throws IllegalStateException, IOException{
		Shop shop = new Shop();
		System.out.println(file.getOriginalFilename());
		File fileSourcePath = new File(System.getProperty("user.dir")+"\\img");
		File fileSource = new File(fileSourcePath, file.getOriginalFilename());
		if (!fileSourcePath.exists()) {
		    fileSourcePath.mkdirs();
		}
	file.transferTo(fileSource);
	shop.setName(name);
	shop.setNum(num);
	shop.setPrice(price);
	shop.setUrl("../image/"+file.getOriginalFilename());
	shopmapper.insert(shop);
	System.out.println(name+"---"+price+"----"+num);
	return "新增成功";
	}
	@RequestMapping(value = { "/getorder"})
	@ResponseBody
	public Map<String, Object> getorder(){
		ResultBean res = new ResultBean();
		res.setCode(0);
		res.addObject("data", shopmapper.queryOrder());
		return res.getResult();	
	}
	//上传订单
	@RequestMapping(value = { "/uporder"})
	@ResponseBody
	public Map<String, Object> uporder(order o){
		ResultBean res = new ResultBean();
		o.getGlod();
		o.getOrdernum();
		o.getRoomid();
		o.getBool();
		res.setCode(0);
		res.addObject("data", shopmapper.queryOrder());
		return res.getResult();	
	}
	//后台确认订单
	@RequestMapping(value = { "/vetryOrder"})
	@ResponseBody
	public Map<String, Object> vetryOrder(@RequestBody order o){
		o.setBool("确认");
		System.out.println(o.getOrdernum());
		ResultBean res = new ResultBean();
		res.setCode(0);
		int a = shopmapper.updateorder(o);
		res.setMsg("修改失败");
		if(a==1) {
			res.setMsg("修改成功");	
		}
		System.out.println(shopmapper.updateorder(o));
		return res.getResult();	
	}
}
