package com.qa.projectManagementApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.projectManagementApp.entities.Actionlist;
import com.qa.projectManagementApp.repo.ActionListRepo;


@Service
public class ActionListService {
	
	private ActionListRepo repo;
	private ServiceAuthHelper auth;
	

	public ActionListService(ActionListRepo repo,ServiceAuthHelper auth) {
		super();
		this.repo = repo;
		this.auth=auth;
	}


	public Actionlist addActionList(Actionlist actionlist, String authorizationHeader) {

		auth.checkCredentialsObject(authorizationHeader, actionlist);
		
		actionlist.setDeadline1(actionlist.getDeadline().plusDays(3L));
		actionlist.setDeadline2(actionlist.getDeadline().plusDays(7L));
		return repo.save(actionlist);
	}


	public boolean removeAction(int actionid, String authorizationHeader) {
		auth.checkCredentialsActionId(authorizationHeader, actionid);
		this.repo.deleteById((long) actionid);
		boolean exists = this.repo.existsById((long) actionid);
		return !exists;
	}


	public List<Actionlist> getAllActions() {
		return this.repo.findAll();
	}


	public Actionlist updateAction(int actionid, Actionlist actionlist, String authorizationHeader) {
		auth.checkCredentialsActionId(authorizationHeader, actionid);
		Optional<Actionlist> existingOptional = this.repo.findById((long) actionid);
        Actionlist existing = existingOptional.get();
        
        existing.setContent(actionlist.getContent());
        existing.setDeadline(actionlist.getDeadline());
        existing.setDeadline1(actionlist.getDeadline1());
        existing.setDeadline2(actionlist.getDeadline2());
        existing.setStatus(actionlist.getStatus());
        
        System.out.println(actionlist.status);
        return this.repo.save(existing);
	}


	public List<Actionlist> getAllUserActions(int userid) {
		
		List<Actionlist> user = repo.findByUserid(userid);
		
		return (List<Actionlist>) user;
			
	}
	
	public List<Actionlist> getActionlistByUserid(int userid, String authorizationHeader) {
		auth.checkCredentialsUserId(authorizationHeader, userid);
		return this.repo.findActionlistByUseridJPQL(userid);
	}
	
}
