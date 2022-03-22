package hh.swd20.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@CrossOrigin
@Controller
public class CategoryController {
 
@Autowired
private CategoryRepository crepository;


@RequestMapping(value="/categorylist")
public String categoryList(Model model) {
model.addAttribute("categories", crepository.findAll());
		return "categorylist";
	}

// RESTful service to get all departments
@RequestMapping(value="/categories", method = RequestMethod.GET)
public @ResponseBody List<Category> getCategoryRest() {	
    return (List<Category>) crepository.findAll();
}    

// RESTful service to get department by id
@RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long Id) {	
	return crepository.findById(Id);
} 

// RESTful service to save new department
@RequestMapping(value="/categories", method = RequestMethod.POST)
public @ResponseBody Category saveCategoryRest(@RequestBody Category category) {	
	return crepository.save(category);
}


@RequestMapping(value = "/addcategory")
public String addCategory(Model model) {
model.addAttribute("category", new Category());
return "addcategory";
}     

@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
public String save(Category category){
crepository.save(category);
return "redirect:categorylist";
}    




}



