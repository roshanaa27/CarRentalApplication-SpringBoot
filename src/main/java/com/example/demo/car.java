package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class car {
@Id 
@GeneratedValue(strategy=GenerationType.AUTO)

private int id;
private int carId;
private String carModel;
private String carNo;
private String status;

car() {}

car(int carId,String carModel, String carNo, String status)
{
	this.setCarId(carId);
	this.setCarModel(carModel);
	this.setCarNo(carNo);
	this.setStatus(status);
}
public int getCarId()
{
	return carId;
}
public void setCarId(int carId)
{
	this.carId=carId;
}
public String getCarModel()
{
	return carModel;
}
public void setCarModel(String carModel)
{
	this.carModel=carModel;
}
public String getCarNo()
{
	return carNo;
}
public void setCarNo(String carNo)
{
	this.carNo=carNo;
}
public String getStatus()
{
	return status;
}
public void setStatus(String status)
{
	this.status=status;
}
}
