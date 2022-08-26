package com.qa.projectManagementApp.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Actionlist addActionlist(@RequestBody Actionlist actionlist) {
		
		return this.service.addActionList(actionlist);
		
		}
	@CrossOrigin
	@DeleteMapping("/deleteaction/{actionid}")
	public boolean removePerson(@PathVariable int actionid) {
		return this.service.removeAction(actionid);
	}
	
	@CrossOrigin
	@GetMapping("/getAllActions")
	public List<Actionlist> getAll() {
		 return this.service.getAllActions();
	}
	
	@CrossOrigin
	@GetMapping("/getUserActions")
	public List<Actionlist> getUser(@PathParam("email") Integer userid){
		return this.service.getActionlistByUserid(userid);
	}
	
	@CrossOrigin
	@PutMapping("/updateAction")
	public Actionlist updateAction(@PathParam("actionid") int actionid, @RequestBody Actionlist actionlist) {
		System.out.println(actionlist.status);
		return this.service.updateAction(actionid, actionlist);
		
	}
}