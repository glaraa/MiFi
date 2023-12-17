package com.MakeitFlauntit.MIFI.repository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.MakeitFlauntit.MIFI.entity.BuddyReqs;
@Repository
@Transactional
public interface BuddyReqsRepo extends JpaRepository<BuddyReqs,String> {
	
	  @Query("SELECT br.addedUserName FROM BuddyReqs br WHERE br.reqUserName =:reqUserName ")
	  public List<String> findByReqUserName(String reqUserName);
	  
	  @Query("SELECT br.reqUserName FROM BuddyReqs br WHERE br.addedUserName =:addedUserName ")
	  public List<String> findByAddedUserName(String addedUserName);
	  
	  public void deleteByAddedUserNameAndReqUserName(String addedUserName,String reqUserName);
	  
	  public long countByAddedUserName(String addedUserName);
	  
	  public boolean existsByAddedUserNameAndReqUserName(String addedUserName,String reqUserName);

}
