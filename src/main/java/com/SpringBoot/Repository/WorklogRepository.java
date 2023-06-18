package com.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.Entity.Worklog;
@Repository
public interface WorklogRepository extends JpaRepository<Worklog, Integer>
{
    Worklog findByWorklogId(Integer id);
}
