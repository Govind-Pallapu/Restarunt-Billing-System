package com.vcube.Restarunt.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.Restarunt.Model.FoodItems;
import com.vcube.Restarunt.Model.Restarunt;
import com.vcube.Restarunt.Repo.FoodItemRepo;
import com.vcube.Restarunt.Repo.Restaruantrepo;

@RestController
@RequestMapping("/restaruant")
public class itemsRestaruntController {

	@Autowired
	Restaruantrepo restrepo;

	@Autowired
	FoodItemRepo itemrepo;

	// ADDING THE DATA
//***************************************************//	
	@PostMapping("/addresta")
	public Restarunt Addrestaruant(@RequestBody Restarunt re) {
		return restrepo.save(re);

	}

	@PostMapping("/additem")
	public FoodItems Additems(@RequestBody FoodItems itm) {
		return itemrepo.save(itm);

	}

	// RETRIVING THE DATA
//***************************************************//	
	@GetMapping("/getRestarunt")
	public List<Restarunt> getRestarunts() {
		return restrepo.findAll();

	}

	@GetMapping("/getitems")
	public List<FoodItems> getItems() {
		return itemrepo.findAll();

	}

	// RETRIVING THE DATA BY ID
//***************************************************//	
	@GetMapping("/getRestarunt/{id}")
	public Optional<Restarunt> getRestaruntsById(@PathVariable int id) {
		return restrepo.findById(id);

	}

	@GetMapping("/getitemsBYId/{id}")
	public List<FoodItems> getItemsById(@PathVariable int id) {
		return itemrepo.findByRest_Id(id);

	}

	// DELETE ITEMS BY ID
//***************************************************//	
	@DeleteMapping("/removeResta/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> removeRestaurant(@PathVariable int id) throws ResourceNotFoundException {
		// Attempt to fetch the restaurant or throw if not found
		Restarunt restaurant = restrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with ID: " + id));

		// If found, delete it
		restrepo.delete(restaurant);

		return ResponseEntity.ok("Restaurant removed successfully! ID: " + id);
	}

	@DeleteMapping("/removeitem/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> removeItem(@PathVariable int id) throws ResourceNotFoundException {

		FoodItems itms = itemrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("item not found with ID: " + id));

		// If found, delete it
		itemrepo.delete(itms);

		return ResponseEntity.ok("Item removed successfully! ID: " + id);
	}
//***************************************************//	

	@PutMapping("/updaterestaruant/{id}")
	public ResponseEntity<Restarunt> updateRestarunt(@PathVariable int id, @RequestBody Restarunt re) {

		Optional<Restarunt> Op = restrepo.findById(id);

		if (Op.isPresent()) {

			Restarunt rest = Op.get();

			rest.setName(re.getName());

			Restarunt res = restrepo.save(rest);

			return ResponseEntity.ok(res);
		} 
		else {
			
			return ResponseEntity.notFound().build();
		}

	}

}
