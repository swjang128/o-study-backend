package o.study.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import o.study.config.RestApiResponse;
import o.study.dto.BoardRequestDTO;
import o.study.dto.FoodRequestDTO;
import o.study.service.BoardService;
import o.study.service.RestaurantService;

/**
 * 음식 메뉴 고르기에 대한 Rest API
 * 
 * @author jsw
 *
 */
@RestController
@RequestMapping("food")
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;

	/**
	 * Read
	 * @return Map<String, Object>
	 */
	@GetMapping("lunch")
	public Map<String, Object> getLunch(/* @RequestBody @Valid FoodRequestDTO restaurantRequestDTO */) {
		return	restaurantService.getLunch();
	}

}
