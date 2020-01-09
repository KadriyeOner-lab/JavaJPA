package com.proje.repository;

import java.util.List;

import com.proje.entityFactory.EntityFactory;
import com.proje.entityFactory.Impl.EntityFactoryImpl;
import com.proje.model.Education;

public interface EducationRepository {
	
	EntityFactory entityFactory =new EntityFactoryImpl();
	
	boolean saveEducation(Education education);
	boolean updateEducation(Education education);
	boolean removeEducation(Education education);
	
	Education findById(Integer id);
	
	List<Education> findEducations();
	
	Education findWithAdvertisementById(Integer id);
	

}
