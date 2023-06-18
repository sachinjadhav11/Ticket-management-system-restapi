package com.SpringBoot.model;

public class WorklogResponceModel 
{
	
  private int worklogId;
	
  private int empId;
  
  private int ticId;
  
  private String date;
  
  private String timespend;
  
  public int getWorklogId()
  {
	return worklogId;
  }

public void setWorklogId(int worklogId)
{
	this.worklogId = worklogId;
}

public int getEmpId()
{
	return empId;
}

public void setEmpId(int empId) 
{
	this.empId = empId;
}

public int getTicId()
{
	return ticId;
}

public void setTicId(int ticId)
{
	this.ticId = ticId;
}

public String getDate()
{
	return date;
}

public void setDate(String date)
{
	this.date = date;
}

public String getTimespend()
{
	return timespend;
}

public void setTimespend(String timespend)
{
	this.timespend = timespend;
}


}
