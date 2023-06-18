package com.SpringBoot.Service.Imple;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.Entity.Employee;
import com.SpringBoot.Entity.Ticket;
import com.SpringBoot.Entity.Worklog;
import com.SpringBoot.Repository.EmployeeRepository;
import com.SpringBoot.Repository.TicketCommentsRepository;
import com.SpringBoot.Repository.TicketRepository;
import com.SpringBoot.Repository.WorklogRepository;
import com.SpringBoot.Service.WorklogService;
import com.SpringBoot.model.WorklogRequestModel;

@Service
public class WorklogServiceImple implements WorklogService
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private TicketCommentsRepository ticketCommentRepository;
	
	@Autowired
	private WorklogRepository worklogRepository;

	@Override
	public List<Worklog> getAllWorklog()
	{
		List<Worklog> worklogs= new ArrayList<>();
		worklogRepository.findAll().forEach(worklog->worklogs.add(worklog));
		return worklogs;
	}

	@Override
	public void addWorklog(WorklogRequestModel worklog)
	{
		Employee employeeId= employeeRepository.findByEmployeeId(worklog.getEmployeeId());
		if(employeeId==null)
		{
			return ;
		}
		Ticket ticketId= ticketRepository.findByTicketId(worklog.getTicketId());
		if(ticketId==null)
		{
			return;
		}
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		Worklog workLog = modelMapper.map(worklog, Worklog.class);
		
		workLog.setEmployee(employeeId);
		workLog.setTicket(ticketId);
		
		worklogRepository.save(workLog);
		
		
	}

	@Override
	public Worklog getWorklogById(Integer worklogId)
	{
		return worklogRepository.findById(worklogId).get();
	}

	@Override
	public void deleteWorklog(Integer worklogId)
	{
		worklogRepository.deleteById(worklogId);
		
	}

	@Override
	public void updateWorklog(WorklogRequestModel worklog, Integer worklogId)
	{
		Worklog log= worklogRepository.findByWorklogId(worklogId);
		Employee emp=employeeRepository.findByEmployeeId(worklog.getEmployeeId());
		log.setTimespend(worklog.getTimespend());
		log.setEmployee(emp);
		log.setWorklogDescription(worklog.getWorklogDescription());
		worklogRepository.save(log);
		
	}
	
	

}
