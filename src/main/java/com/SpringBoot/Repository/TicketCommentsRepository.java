package com.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.Entity.Comment;

public interface TicketCommentsRepository extends JpaRepository<Comment ,Integer>
{

}
