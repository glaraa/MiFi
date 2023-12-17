package com.MakeitFlauntit.MIFI.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.MakeitFlauntit.MIFI.entity.AllRecords;
@Repository
@Transactional
public interface AllUsersRepo extends JpaRepository<AllRecords,String>{

	public boolean existsByUserName(String userName);
	
	public AllRecords findByUserName(String userName);
	
	public List<AllRecords> findAllByUserName(String userName);
	
	
	public List<AllRecords> findByUserNameNotIn(List<String> userName);
	
	public AllRecords findByUserNameAndEmail(String userName,String email);
	
	public void deleteByUserName(String userName);
  
}
