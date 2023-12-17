package com.MakeitFlauntit.MIFI.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.MakeitFlauntit.MIFI.entity.BuddyReqs;
import com.MakeitFlauntit.MIFI.entity.CreationComments;

public interface CommentsRepo extends JpaRepository<CreationComments,Integer> {

	List<CreationComments> findAllByCreationId(int srNo);
	
}
