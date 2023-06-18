package com.SpringBoot.Service;

import java.util.List;

import com.SpringBoot.Entity.Comment;
import com.SpringBoot.model.TicketCommentRequestModel;

public interface TicketCommentService {
	  
	 public List<Comment> getallTicketComment();
	 
	  public void addComment(TicketCommentRequestModel  ticketComments);
	  
	  public Comment getComments(Integer TicketComment_id);
	  
	  public void deleteComment(Integer  TicketComment_id);
	  
	  public void updateTicketComment(Comment TicketComment_id) ;
		
	

	  
	 
}
