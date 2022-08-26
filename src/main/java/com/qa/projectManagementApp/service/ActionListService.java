package com.qa.projectManagementApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.projectManagementApp.entities.Actionlist;
import com.qa.projectManagementApp.repo.ActionListRepo;


@Service
public class ActionListService {
	
	private ActionListRepo repo;
	

	public ActionListService(ActionListRepo repo) {
		super();
		this.repo = repo;
	}


	public Actionlist addActionList(Actionlist actionlist) {
		return repo.save(actionlist);
	}


	public boolean removeAction(int actionid) {
		this.repo.deleteById((long) actionid);
		boolean exists = this.repo.existsById((long) actionid);
		return !exists;
	}


	public List<Actionlist> getAllActions() {
		return this.repo.findAll();
	}


	public Actionlist updateAction(int actionid, Actionlist actionlist) {
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
	
	public List<Actionlist> getActionlistByUserid(int userid) {
		return this.repo.findActionlistByUseridJPQL(userid);
	}

}


// add a way to change deadline 1/2  content etc i.e. put  and then delete