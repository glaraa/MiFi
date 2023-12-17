package com.MakeitFlauntit.MIFI.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MakeitFlauntit.MIFI.entity.UserCreations;
@Repository
@Transactional
public interface UserCreationsRepo  extends JpaRepository<UserCreations,Integer> {

	
	@Query("select uc from UserCreations uc where uc.userName = :userName")
	public List<UserCreations> findAllByUserName(String userName);
	
	
	public long countByUserName(String UserName);
	
	
	@Query("select uc.userName from UserCreations uc where uc.srNo = :srNo")
	public String findBySrNo(int srNo);
	
	public UserCreations findAllBySrNo(int srNo);
	
	//@Query("delete from UserCreations uc where uc.srNo = :srNo AND uc.userName = :userName")
	public void deleteBySrNo(int srNo);
	
}
