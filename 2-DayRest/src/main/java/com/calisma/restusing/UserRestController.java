package com.calisma.restusing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import restRead.API;
import restRead.JsonProduct;
import restRead.Services;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RestController
public class UserRestController {
	
	List<User> ls = new ArrayList<>();
	
	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public HashMap<String, Object> allUser() {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("statu", true);
		hm.put("count", 10);
		hm.put("message", "İşlem Başarılı");
		hm.put("list", dataResult());
		
		// json Retrtofit
		Services services = API.getClient().create(Services.class);
		Call<JsonProduct> dt = services.allProduct(10);
		 try {
			Response<JsonProduct> rs =  dt.execute();
			String desc = rs.body().getProducts().get(0).getBilgiler().get(0).getDescription();
			hm.put("desc", desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		/*
		dt.enqueue(new Callback<JsonProduct>() {
			
			@Override
			public void onResponse(Call<JsonProduct> call, Response<JsonProduct> response) {
				String desc = response.body().getProducts().get(0).getBilgiler().get(0).getDescription();
				hm.put("desc", desc);
				System.out.println(desc);
			}
			
			@Override
			public void onFailure(Call<JsonProduct> call, Throwable t) {
				System.err.println("json error : " + t);
				
			}
		});
		*/
		
		
		return hm;
	}
	
	// http://localhost:8080/addUser?name=hasan&age=1&statu=true
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public HashMap<String, Object> addUserGet(User us) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("durum", "İşlem başarılı");
		ls.add(us);
		return hm;
	}
	
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public HashMap<String, Object> addUserPost(User us) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("durum", "İşlem başarılı");
		ls.add(us);
		return hm;
	}
	
	
	
	public List<User> dataResult() {
			for (int i = 0; i < 10; i++) {
				User us =  new User("Ali - "+ i, i, true);
				ls.add(us);
			}
		return ls;
	}
	

}
