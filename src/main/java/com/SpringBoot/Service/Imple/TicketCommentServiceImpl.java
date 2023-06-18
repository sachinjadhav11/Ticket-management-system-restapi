package com.SpringBoot.Service.Imple;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.Entity.Employee;
import com.SpringBoot.Entity.Comment;
import com.SpringBoot.Entity.Ticket;
import com.SpringBoot.Repository.EmployeeRepository;
import com.SpringBoot.Repository.TicketCommentsRepository;
import com.SpringBoot.Repository.TicketRepository;
import com.SpringBoot.Service.TicketCommentService;
import com.SpringBoot.model.TicketCommentRequestModel;

@Service
public class TicketCommentServiceImpl implements TicketCommentService {

	
	@Autowired
	private TicketCommentsRepository ticketCommentsRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public List<Comment> getallTicketComment() 
	{
		List<Comment> ticketcomment= new ArrayList<>();
		 ticketCommentsRepository.findAll().forEach(ticketcomments->ticketcomment.add(ticketcomments));
		 return ticketcomment;
	}

	@Override
	public void addComment(TicketCommentRequestModel ticket) 
	{
		
		Employee emp = employeeRepository.findByEmployeeId(ticket.getEmployeeId());
		if(emp==null) {
			return;
			//handle error;
		}
		Ticket tic = ticketRepository.findByTicketId(ticket.getTicketId());
		
		if(tic==null) {
			return;
			//handle error
		}
		Date date = new Date();
		long d= date.getTime();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		Comment ticketCommentTable = modelMapper.map(ticket, Comment.class);
		ticketCommentTable.setEmployee(emp);
		ticketCommentTable.setTicket(tic);
		ticketCommentTable.setTicketCommentDate(d);
		ticketCommentsRepository.save(ticketCommentTable);
		
	}

	@Override
	public Comment getComments(Integer TicketComment_id)
	{
		return ticketCommentsRepository.findById(TicketComment_id).get();
	}

	@Override
	public void updateTicketComment(Comment TicketComment_id)
	{
		ticketCommentsRepository.save(TicketComment_id);
		
	}
	
	@Override
	public void deleteComment(Integer TicketComment_id)
	{
		ticketCommentsRepository.deleteById(TicketComment_id);	
	}

	
}
