package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class caroperations {
@Autowired repository ob;
@PostMapping("/addcar")
public String save(@RequestBody car car1)
{
	car w= new car();
	int id=car1.getCarId();
	String carModel=car1.getCarModel();
	String carNo=car1.getCarNo();
	String status=car1.getStatus();
	
	w.setCarId(id);
	w.setCarModel(carModel);
	w.setCarNo(carNo);
	w.setStatus(status);
	
	car first = new car(id,carModel,carNo,status);
	ob.save(first);
	return "Items Added successfully";
}

@GetMapping("/car")
public List<car> getAllcar()
{
	return ob.findAll();
}

@GetMapping("car/{id}")
public List<car> getCarById(@PathVariable("id") int id)
{
	return ob.findById(id);
}

@GetMapping("car/name/{carModel}")
public List<car> getCarByModel(@PathVariable("carModel") String carModel)
{
	return ob.findByName(carModel);
}

@PutMapping("/update/{id}")
public String update(@RequestBody car x,@PathVariable("id") int id)
{
	int carId1=x.getCarId();
	String carModel=x.getCarModel();
	String carNo=x.getCarNo();
	String status=x.getStatus();
	ob.update(carId1,carModel,carNo,status,id);
	return "Successfully updated";
}

@DeleteMapping("deletetask/{id}")
public String deleteById(@PathVariable("id") int id)
{
	ob.deleteAllByIdInBatch(id);
	return "Items deleted successfully";
}
}