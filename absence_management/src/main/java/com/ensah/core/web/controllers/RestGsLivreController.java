package com.ensah.core.web.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ensah.core.bo.Auteur;
import com.ensah.core.bo.Livre;
import com.ensah.core.bo.Utilisateur;
import com.ensah.core.services.IGsLivresServices;
import com.ensah.core.services.IPersonService;
import com.ensah.core.web.exceptions.JSonErrorResponse;
import com.ensah.genericdao.EntityNotFoundException;

@RestController
@RequestMapping("/biblio/api/")
public class RestGsLivreController {
	protected final Logger LOGGER = Logger.getLogger(getClass());

	@Autowired
	private IGsLivresServices gsLivreServices;

	@Autowired
	private IPersonService personServices;

	@RequestMapping(value = "getAllAuthors", method = RequestMethod.GET)
	@ResponseBody
	public List<Auteur> getAllAuthors(Model model) {

		List<Auteur> auteurs = gsLivreServices.getAllAuthors();
		for (Auteur it : auteurs) {
			System.out.println(it);
		}
		return auteurs;
	}

	@RequestMapping(value = "getBookByCodeJson", method = RequestMethod.GET)
	@ResponseBody
	public Livre getBookByCodeJson(@RequestParam String code) {

		Livre l = gsLivreServices.getLivreByCode(code);

		return l;
	}

	@RequestMapping(value = "getUserByCinJson", method = RequestMethod.GET)
	@ResponseBody
	public Utilisateur getUserByCinJson(@RequestParam String cin) {

		Utilisateur persons = personServices.getPersonByCin(cin);

		return persons;
	}

	@ExceptionHandler
	public ResponseEntity<JSonErrorResponse> handleException(EntityNotFoundException exc) {
		// Log the error
		LOGGER.error(exc);
		// create a ErrorResponse
		JSonErrorResponse error = new JSonErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
