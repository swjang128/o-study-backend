package o.study.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import o.study.dto.BoardRequestDTO;
import o.study.dto.RestApiResultDTO;
import o.study.service.BoardService;

/**
 * Board에 대한 Rest API
 * 
 * @author jsw
 *
 */
@RestController
@RequestMapping("board")
public class BoardController {
	@Autowired
	BoardService boardService;

	/**
	 * Read
	 * @return Map<String, Object>
	 */
	@GetMapping("")
	public RestApiResultDTO result(@RequestBody @Valid BoardRequestDTO boardRequestDTO) {
		return	boardService.read(boardRequestDTO);
	}

}
