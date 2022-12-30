package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface repository extends JpaRepository<car,Integer>{

	@Query(value="SELECT * FROM car s where s.carId=?1",nativeQuery=true)
	List<car> findById(int id);
	
	
	@Query(value="SELECT * FROM car s where s.carModel=?1",nativeQuery=true)
	List<car> findByName(String carModel);
	
	
	@Modifying
	@Transactional
	@Query(value="Update car s set s.carId=?1 , s.carModel=?2 , s.carNo=?3 , s.status=?4 where s.carId=?5", nativeQuery=true)
	void update(int carId,String carModel, String carNo, String status, int id);
	
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM car where carId=?1", nativeQuery=true)
	void deleteAllByIdInBatch(int id);
}
