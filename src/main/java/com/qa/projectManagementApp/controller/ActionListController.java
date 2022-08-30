package com.qa.projectManagementApp.controller;

import java.util.Base64;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.qa.projectManagementApp.entities.Actionlist;
import com.qa.projectManagementApp.service.ActionListService;


@RestController
public class ActionListController {
	
	private ActionListService service; 
	
	
	public ActionListController(ActionListService service) {
		super();
		this.service = service;
	}

	@CrossOrigin
	@PostMapping("/createActionList")
	public Actionlist addActionlist(@RequestHeader(value="Authorization")String authorizationHeader ,
									@RequestBody Actionlist actionList) {
		
		return this.service.addActionList(actionList,authorizationHeader);
		
		}
	@CrossOrigin
	@DeleteMapping("/deleteaction/{actionid}")
	public boolean removePerson(@RequestHeader(value="Authorization")String authorizationHeader ,
								@PathVariable int actionid) {
		return this.service.removeAction(actionid,authorizationHeader);
	}
	
	@CrossOrigin
	@GetMapping("/getAllActions")
	public List<Actionlist> getAll() {
		 return this.service.getAllActions();
	}
	
	@CrossOrigin
	@GetMapping("/getUserActions")
	public List<Actionlist> getUser(@RequestHeader(value="Authorization")String authorizationHeader ,
									@PathParam("email") Integer userid){
		return this.service.getActionlistByUserid(userid,authorizationHeader);
	}
	
	@CrossOrigin
	@PutMapping("/updateAction")
	public Actionlist updateAction(@RequestHeader(value="Authorization")String authorizationHeader ,
								   @PathParam("actionid") int actionid, @RequestBody Actionlist actionList) {
		System.out.println(actionList.getStatus());
		return this.service.updateAction(actionid, actionList,authorizationHeader);
		
	}
}