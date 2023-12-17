package com.MakeitFlauntit.MIFI.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.MakeitFlauntit.MIFI.entity.UserBuddies;
@Repository
@Transactional
public interface UserBuddiesRepo extends CrudRepository<UserBuddies,String>{

	  @Query("SELECT ub.buddyUserName FROM UserBuddies ub WHERE ub.userName =:userName ")
	  public List<String> findByUserName(String userName);
	  
	  public boolean existsByUserNameAndBuddyUserName(String userName,String buddyUserName);
	  
	  
	  public long countByUserName(String UserName);
	  
	  
	  public void deleteByUserNameAndBuddyUserName(String userName,String buddyUserName);




}
