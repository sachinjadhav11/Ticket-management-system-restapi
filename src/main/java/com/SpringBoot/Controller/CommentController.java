package com.SpringBoot.Controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.SpringBoot.Entity.Comment;
import com.SpringBoot.Service.TicketCommentService;
import com.SpringBoot.model.TicketCommentRequestModel;
import com.SpringBoot.model.TicketCommentResponceModel;

@RestController
public class CommentController {

	@Autowired
	  private TicketCommentService ticketCommentService;
	  
	  
	    @GetMapping("/comment")
		public List<TicketCommentResponceModel> getallTicket_Comment()
		{
	    	List<Comment> allcomment=ticketCommentService.getallTicketComment();
			
			  ModelMapper mapper = new ModelMapper();
			  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			  
			  List<TicketCommentResponceModel> returnValue=new ArrayList<TicketCommentResponceModel>();
				
			  Iterator allcommentIterator = allcomment.iterator();
				 
			      while(allcommentIterator.hasNext())
			      {
			    	  Comment tic=(Comment) allcommentIterator.next();
			    	  
			    	  TicketCommentResponceModel model = mapper.map(tic, TicketCommentResponceModel.class);
			    	  
			    	  int assId=tic.getEmployee().getEmployeeId();
					  int tId = tic.getTicket().getTicketId();
					  String d =new Date(tic.getTicketCommentDate()).toLocaleString(); 
						
					  model.setDate(d);
					  model.setEmployeeId(assId);
					  model.setTicketId(tId);
					  returnValue.add(model);
		}
	   
			      return returnValue; 
	    	
	    	
		}
	    
	    
		// add comment in the ticket
		@PostMapping("/comment")
		public void addTicketComment(@RequestBody TicketCommentRequestModel TicketComments)
		{
			ticketCommentService.addComment(TicketComments);
		
		}
		
		@GetMapping("/comment/{Ticket_Comment}")
		public TicketCommentResponceModel getTicketCommentById(@PathVariable("Ticket_Comment")Integer TicketComments)
		{
            Comment tc= ticketCommentService.getComments(TicketComments);
			
			ModelMapper mapper=new ModelMapper();
			mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			
			TicketCommentResponceModel returnValue = mapper.map(tc, TicketCommentResponceModel.class);
			 int assId=tc.getEmployee().getEmployeeId();
			 int tId = tc.getTicket().getTicketId();
			 returnValue.setEmployeeId(assId);
			 
			//long date convert to string local format
			 String d =new Date(tc.getTicketCommentDate()).toLocaleString(); 
			
			 returnValue.setDate(d);
			 returnValue.setTicketId(tId);
			 return returnValue;
		}
	    
	    @PutMapping("/comment")
		public void updateTicketComment(@RequestBody Comment ticketComment)
	    {
		  ticketCommentService.updateTicketComment(ticketComment);
		}	
	    
		@DeleteMapping("/comment/{Ticket_Comment}")
		public void deleteTicketComment(@PathVariable("Ticket_Comment") Integer TicketComments)
		{
			ticketCommentService.deleteComment(TicketComments);
		}
		 
}
