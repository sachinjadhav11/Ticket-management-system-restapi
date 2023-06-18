package com.SpringBoot.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import javax.swing.text.html.HTMLDocument.Iterator;



import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.Entity.Employee;
import com.SpringBoot.Entity.Ticket;
import com.SpringBoot.Service.TicketService;
import com.SpringBoot.model.TicketRequestModel;
import com.SpringBoot.model.TicketResponceModel;
import com.SpringBoot.model.UpdateStatusRequestModel;
import com.SpringBoot.model.UpdateTicketRequestModel;


@RestController
public class TicketController
{
	@Autowired
	  private TicketService ticketService;
	  
	  // get the ticket
	  @GetMapping("/ticket")
		public List<TicketResponceModel> getAllTickets()
		{
		  List<Ticket> allTicket=ticketService.getAllTickets();
		  ModelMapper mapper = new ModelMapper();
		  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		  
		  List<TicketResponceModel> returnValue=new ArrayList<TicketResponceModel>();
			 Iterator allTicIterator = allTicket.iterator();
			 
		      while(allTicIterator.hasNext())
		      {
		    	  Ticket tic= (Ticket)allTicIterator.next();

		    	  TicketResponceModel model = mapper.map(tic, TicketResponceModel.class);
		    	  
		    	  int assId=tic.getAsignee().getEmployeeId();
				  int reporterId = tic.getReporter().getEmployeeId();
				  model.setAsignId(assId);
				  model.setReportId(reporterId);
				  returnValue.add(model);
				  
		      }
			 return returnValue;
		}
	  
	  @GetMapping("/ticket/{ticket_id}")
		public TicketResponceModel getTicketById(@PathVariable("ticket_id")Integer ticket_id )
		{
			Ticket tiket= ticketService.getTicketById(ticket_id);
			ModelMapper modelMapper= new ModelMapper();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			 
			TicketResponceModel returnValue=modelMapper.map(tiket, TicketResponceModel.class);
			int assId=tiket.getAsignee().getEmployeeId();
			int repoId=tiket.getReporter().getEmployeeId();
//			
			returnValue.setAsignId(assId);
    		returnValue.setReportId(repoId);
			
			return returnValue;
			
		}
	  
	  
	  // creating Ticket
	  @PostMapping("/ticket")
		public void addTicket(@RequestBody TicketRequestModel ticket)
		{
		  ticketService.addTicket(ticket);
			//return "employee";
		}
	  
	
	 
	     // delete the ticket
	    @DeleteMapping("/ticket/{ticket_id}")
		public void deleteTicket(@PathVariable("ticket_id") Integer ticket_id)
		{
	    	ticketService.deleteTicket(ticket_id);
	    	
		}
	    
	    @PutMapping("/ticket")
	    public String updateTicketStatus(@RequestBody UpdateStatusRequestModel updateStatus)
	    {
	    	
	    	String returnValue=ticketService.updateTicketStatus(updateStatus);
	    	
	    	return returnValue;
	    }
	@PutMapping("/ticket/{ticketId}")    
  public void updateTicket(@RequestBody UpdateTicketRequestModel ticket, @PathVariable("ticketId") Integer ticketId)
  {
	  ticketService.updateTicket(ticket, ticketId);
  }
	
	@GetMapping("/user/{employeeId}")
	public ResponseEntity AssignedUserTicket(@PathVariable("employeeId")Integer employeeId)
	{
		List<Ticket> tiket=ticketService.AssignedUserTicket(employeeId);
		
		if(tiket.isEmpty())
		{
			return ResponseEntity.ok("User does not have assigne any ticket");
		}
		
		return ResponseEntity.ok(tiket);
	}
	    
	   
	  
	     


}
