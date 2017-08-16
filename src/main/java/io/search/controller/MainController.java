package io.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.search.model.User;
import io.search.services.UserSearch;

/**
 * MainController class
 * 
 * @author Omar Eisa
 */
@Controller
public class MainController {

	// Inject the UserSearch object
	@Autowired
	private UserSearch userSearch;

	private String error;

	/**
	 * Index main page.
	 */
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "Try to go here: " + "<a href='/search?q=hola'>/search?q=olga</a>";
	}

	/**
	 * Show search results for the given query.
	 *
	 * @param q
	 *            The search query.
	 */
	@RequestMapping("/search")
	public String search(String q, Model model) {
		List<User> searchResults = null;
		error = null;
		try {
			if (q.isEmpty()) {
				error = " : There is not keyword";
				model.addAttribute("error", error);
				System.out.println(error);
				return "search";
			} else

				searchResults = userSearch.search(q);
			model.addAttribute("searchResults", searchResults);

			if (searchResults.isEmpty()) {
				error = " : search Results is empty";
				model.addAttribute("error", error);
				System.out.println(error);
				return "search";
			}
		} catch (Exception ex) {

			ex.printStackTrace();

		}
		return "search";
	}

}
