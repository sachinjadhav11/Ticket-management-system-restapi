package com.SpringBoot.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.Entity.Worklog;
import com.SpringBoot.Service.WorklogService;
import com.SpringBoot.model.WorklogRequestModel;
import com.SpringBoot.model.WorklogResponceModel;

@RestController
public class WorklogController
{
	@Autowired
    private WorklogService worklogService;
	
	@GetMapping("/worklog")
	public List<WorklogResponceModel> getAllWorklog()
	{
		List<Worklog> allworklog= worklogService.getAllWorklog();
		
		  ModelMapper mapper = new ModelMapper();
		  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		  
	 List<WorklogResponceModel> returnValue= new ArrayList<WorklogResponceModel>();
	 
	Iterator allworklogIterator= allworklog.iterator();
	
	while(allworklogIterator.hasNext())
	{
		Worklog log= (Worklog) allworklogIterator.next();
		
		WorklogResponceModel model= mapper.map(log, WorklogResponceModel.class);
		
		int empId=log.getEmployee().getEmployeeId();
		int ticketId=log.getTicket().getTicketId();
		model.setEmpId(empId);
		model.setTicId(ticketId);
		returnValue.add(model);
	}
		
	return returnValue;
	}
	
	// adding worklog
	@PostMapping("/worklog")
	public void addWorklog(@RequestBody WorklogRequestModel worklog)
	{
		worklogService.addWorklog(worklog);
	}
	
	@GetMapping("worklog/{worklogId}")
	public WorklogResponceModel getWorklogById(@PathVariable("worklogId") Integer worklogId )
	{
		Worklog log=worklogService.getWorklogById(worklogId);
		
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		WorklogResponceModel returnValue= mapper.map(log, WorklogResponceModel.class);
		
		int empId=log.getEmployee().getEmployeeId();
		int ticketId=log.getTicket().getTicketId();
		
		returnValue.setEmpId(empId);
		returnValue.setTicId(ticketId);
		
		return returnValue;
	}
	
	@DeleteMapping("/worklog/{worklogId}")
	public void deleteWorklog(@PathVariable("worklogId") Integer worklogId)
	{
		worklogService.deleteWorklog(worklogId);
	}
	
	@PutMapping("/worklog/{worklogId}")
	public void updateWorklog(@RequestBody WorklogRequestModel updateworklog, @PathVariable("worklogId") Integer worklogId)
	{
		worklogService.updateWorklog(updateworklog, worklogId);
	}
}
