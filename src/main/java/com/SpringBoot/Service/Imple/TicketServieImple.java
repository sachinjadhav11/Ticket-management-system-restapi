package com.SpringBoot.Service.Imple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.Entity.Employee;
import com.SpringBoot.Entity.Ticket;
import com.SpringBoot.Repository.EmployeeRepository;
import com.SpringBoot.Repository.TicketRepository;
import com.SpringBoot.Service.TicketService;
import com.SpringBoot.model.TicketRequestModel;
import com.SpringBoot.model.UpdateStatusRequestModel;
import com.SpringBoot.model.UpdateTicketRequestModel;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Service
public class TicketServieImple implements TicketService
{

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Ticket> getAllTickets()
	{
		List<Ticket> tickets= new ArrayList<>();
		ticketRepository.findAll().forEach(ticket->tickets.add(ticket));
		return tickets;
	}

	@Override
	public void addTicket(TicketRequestModel ticket)
	{
	Employee assignee=employeeRepository.findByEmployeeId(ticket.getAsignId());
		if(assignee==null) {
		
			return;
		}
		Employee reporter=employeeRepository.findByEmployeeId(ticket.getReportId());
		if(reporter==null) {
			return;
		
		}
	ModelMapper modelMapper = new ModelMapper();
	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

	Ticket ticketTable = modelMapper.map(ticket, Ticket.class);
	ticketTable.setAsignee(assignee);
	ticketTable.setReporter(reporter);
	
	ticketRepository.save(ticketTable);	
	}
	
	@Override
	public Ticket getTicketById(Integer ticket_id)
	{
		return ticketRepository.findById(ticket_id).get();
			
	}
	
	@Override
	public void deleteTicket(Integer ticket_id) 
	{
		
		ticketRepository.deleteById(ticket_id);
	}

	@Override
	public String updateTicketStatus(UpdateStatusRequestModel updateStatus)
	{

		Ticket t1= ticketRepository.findByTicketId(updateStatus.getTicketId());
		
		String oldStatus=t1.getStatus();
		
		String newStatus=updateStatus.getStatus();
		if(!(newStatus.equals("Open") ||newStatus.equals("In-progress") || newStatus.equals("Closed") || newStatus.equals("Re-opened")))
		return "entered wrong status.status must be used between in this form [Open,In-progress,Closed,Re-opened]";
			
		
		if(oldStatus.equalsIgnoreCase(newStatus))
		{
			return "Ticket allready "+oldStatus; 
		}
		else if(newStatus.equals("Open")) 
		{
			return "can not open ticket in the state of "+oldStatus;
		}
		else if(newStatus.equals("In-progress") && !(oldStatus.equals("Open") || oldStatus.equals("Re-Opened") ))
		{
			return "Ticket must be opened to update the status in to In-progress";
		}
		else if(newStatus.equals("Closed") && !(oldStatus.equals("Open") || oldStatus.equals("In-progress") || oldStatus.equalsIgnoreCase("Re-opened") ))
		{
			return "Ticket must be opened or In-progress or Re-opened to update the status into Closed" ;
		}
		else if(newStatus.equals("Re-opened") && !oldStatus.equals("Closed"))
		{
			return "Ticket must be Closed to update the status into Re-opened";
		}

		t1.setStatus(updateStatus.getStatus());
		ticketRepository.save(t1);	
		return "Ticket status updateted successfully to state : "+newStatus;
	}

	@Override
	public void updateTicket(UpdateTicketRequestModel ticket, Integer ticketId)
	{
		Employee emp=employeeRepository.findByEmployeeId(ticket.getAsignId());
		
		Ticket tiket= ticketRepository.findByTicketId(ticketId);
		
		tiket.setTitle(ticket.getTitle());
		tiket.setTicket_description(ticket.getTicket_description());
		tiket.setAsignee(emp);
		
		ticketRepository.save(tiket);
		
	}

	@Override
	public List<Ticket> AssignedUserTicket(Integer employeeId)
	{
		List<Ticket> tickets=ticketRepository.findByAsigneeEmployeeId(employeeId);
		
		return tickets;
	}



	
	
	
	

	
		
}


