package com.recipe.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import org.springframework.web.bind.annotation.RestController;

import com.recipe.entity.Recipe;
import com.recipe.entity.User;
import com.recipe.exception.RecipeNotFoundException;
import com.recipe.jwt.JwtTokenUtil;
import com.recipe.repository.IRecipeRepository;
import com.recipe.services.IRecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

	Logger logger = LoggerFactory.getLogger(RecipeController.class);

	@Autowired
	IRecipeService recipeService;

	@Autowired
	IRecipeRepository recipeRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	User user = null;

	public RecipeController() {
		logger.info("-----> Inside Recipe Service Controller Working!");
	}

	@GetMapping("/allRecipes")
	public ResponseEntity<?> getAllRecipes(HttpServletRequest request) throws RecipeNotFoundException {

		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);

		logger.info("Calling Recipe List");

		if (!recipeRepository.findAll().isEmpty()) {

			logger.info("Recipe List FOUND");

			return new ResponseEntity<>(recipeService.getRecipesList(), HttpStatus.OK);

		} else {

			logger.info("Recipe List is EMPTY");

			throw new RecipeNotFoundException("No recipes found in the list ");

		}
	}

	@PostMapping("/addRecipe")
	public ResponseEntity<?> createRecipe(@RequestBody Recipe recipe, HttpServletRequest request)
			throws RecipeNotFoundException {

		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);

		Optional<Recipe> opt = recipeRepository.findByName(recipe.getName());

		if (opt.isPresent()) {
			logger.info("Recipe with ID {} is already EXISTS", recipe.getRecipeId());
			throw new RecipeNotFoundException("Recipe already exists");

		} else {

			recipeService.addRecipe(recipe);
			logger.info("Recipe with ID {} is created SUCCESSFULLY", recipe.getRecipeId());
			return new ResponseEntity<>(" Recipe is added to the list ", HttpStatus.CREATED);

		}
	}

	@PutMapping("/updateRecipe/{recipeId}")
	public ResponseEntity<?> updateRecipe(@RequestBody Recipe recipe, HttpServletRequest request)
			throws RecipeNotFoundException {

		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);

		logger.info("Updating the recipe with ID {}");

		if (recipeRepository.existsById(recipe.getRecipeId())) {

			recipeService.updateRecipe(recipe);
			logger.info(" ID : {} is UPDATED SUCCESSFULLY", recipe.getRecipeId());
			return new ResponseEntity<>(" Recipe Id " + recipe.getRecipeId() + " is successfully updated in the list ",
					HttpStatus.ACCEPTED);

		} else {
			logger.info("Recipe with ID {} is NOT FOUND", recipe.getRecipeId());
			throw new RecipeNotFoundException("Recipe Id with " + recipe.getRecipeId() + " is not found in the list ");
		}

	}

	@DeleteMapping("/deleteMapping/{recipeId}")
	public ResponseEntity<String> deleteRecipe(@PathVariable("recipeId") int recipeId, HttpServletRequest request)
			throws RecipeNotFoundException {

		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);

		Optional<Recipe> opt = recipeRepository.findById(recipeId);

		if (opt.isPresent()) {

			recipeService.deleteRecipe(recipeId);

			logger.info("ID with {} is DELETED SUCCESSFULLY", recipeId);

			return new ResponseEntity<>("Recipe id : " + recipeId + " is successfully deleted fom the list",
					HttpStatus.OK);
		} else {

			logger.info("ID with {} is not found", recipeId);

			throw new RecipeNotFoundException(" Recipe id : " + recipeId + " is not found in the list ");

		}
	}

	@GetMapping("/getRecipeById/{recipeId}")
	public ResponseEntity<?> getRecipeById(@PathVariable("recipeId") int recipeId, HttpServletRequest request)
			throws RecipeNotFoundException {

		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);

		Optional<Recipe> opt = recipeRepository.findById(recipeId);

		logger.info("Calling a recipe by ID{ }", recipeId);

		if (opt.isPresent()) {

			logger.info("Recipe with ID {} is found", recipeId);

			return new ResponseEntity<>(recipeService.getRecipeById(recipeId), HttpStatus.OK);

		}

		else {

			logger.info("RecipeID with ID {} is NOT FOUND", recipeId);

			throw new RecipeNotFoundException(" Recipe id : " + recipeId + " is not found from the list ");
		}

	}

	@GetMapping("/{recipeName}")
	public ResponseEntity<?> getRecipeByName(@PathVariable("recipeName") String recipeName, HttpServletRequest request)
			throws RecipeNotFoundException {

		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);

		Optional<Recipe> opt = recipeRepository.findByName(recipeName);

		logger.info("Calling Recipe By Name {}", recipeName);

		if (opt.isPresent()) {

			logger.info("Recipe with Name {} is FOUND", recipeName);

			return new ResponseEntity<>(recipeService.getRecipeByName(recipeName), HttpStatus.FOUND);
		}

		else {

			logger.info("Recipe with Name {} not found", recipeName);

			throw new RecipeNotFoundException("Recipe with name : " + recipeName + " is not found ");
		}
	}

}
