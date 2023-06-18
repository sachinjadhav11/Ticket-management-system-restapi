package com.SpringBoot.Service;

import java.util.List;

import com.SpringBoot.Entity.Worklog;
import com.SpringBoot.model.WorklogRequestModel;

public interface WorklogService 
{
  public List<Worklog> getAllWorklog();
  
  public void addWorklog(WorklogRequestModel  worklogId);
  
  public Worklog getWorklogById(Integer worklogId);
  
  public void deleteWorklog(Integer worklogId);
  
  public void updateWorklog(WorklogRequestModel worklog, Integer worklogId);
}
