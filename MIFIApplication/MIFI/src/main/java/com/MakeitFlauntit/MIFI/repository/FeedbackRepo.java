package com.MakeitFlauntit.MIFI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MakeitFlauntit.MIFI.entity.AllRecords;
import com.MakeitFlauntit.MIFI.entity.FeedBack;

public interface FeedbackRepo extends JpaRepository<FeedBack,Integer>{

}
