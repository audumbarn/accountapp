package com.restful.accountapp.controller;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.restful.accountapp.bean.Account;
import com.restful.accountapp.service.AccountService;

 
@Path("/account")
public class AccountController {
	
	AccountService accountService=new AccountService();
	 
	//http://localhost:8764/RESTfulExample/pages/myaccount.html
    //http://localhost:8764/RESTfulExample/rest/account/audu
	
	@GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccount(@PathParam("id") String id) {
    	return accountService.getAccount(id);
    }
    
    //http://localhost:8764/RESTfulExample/pages/login.html
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Account addAccount(Account account) {
    	System.out.println(account);
    	return accountService.addAccount(account);
    	
    }
 
    @PUT
	@Produces(MediaType.APPLICATION_JSON)
    public Account updateAccount(Account account) {
    	return accountService.updateAccount(account);
    }
 
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteAccount(@PathParam("id") int id) {
		//countryService.deleteAccount(id);
	}
}
