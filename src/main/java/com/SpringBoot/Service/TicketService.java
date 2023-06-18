package com.SpringBoot.Service;
import java.util.List;

import com.SpringBoot.Entity.Ticket;
import com.SpringBoot.model.TicketRequestModel;
import com.SpringBoot.model.UpdateStatusRequestModel;
import com.SpringBoot.model.UpdateTicketRequestModel;


public interface TicketService 
{
  public List<Ticket > getAllTickets();
  
  public void addTicket(TicketRequestModel  ticket_id);
  
  public void deleteTicket(Integer  ticket_id);
  
  public Ticket getTicketById(Integer ticket_id);
  
  public  String  updateTicketStatus(UpdateStatusRequestModel updateStatus);
  
  public void updateTicket(UpdateTicketRequestModel ticket, Integer ticketId);
  
  public List<Ticket> AssignedUserTicket(Integer employeeId);
  
  
  
 
  
  
  
  

 
}