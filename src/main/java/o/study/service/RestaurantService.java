package o.study.service;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import o.study.config.RestApiHeader;
import o.study.config.RestApiResponse;
import o.study.dto.FoodRequestDTO;
import o.study.dto.FoodResponseDTO;

@RequiredArgsConstructor
@Service
@Slf4j
public class RestaurantService {
	@Autowired
	RestApiResponse restApiResponse;
	@Autowired
	ModelMapper modelMapper;

	@SuppressWarnings("unchecked")
	public Map<String, Object> getLunch() {
		// ObjectMapper 객체 가져오기
		ObjectMapper objectMapper = new ObjectMapper();
		
		// Rest API 응답 객체 작성
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> header = new HashMap<String, Object>();
		Map<String, Object> body = new HashMap<String, Object>();
		
		// header에 성공으로 담기
		header = restApiResponse.setHeader(header, RestApiHeader.SUCCESS);
		
		// body에 담을 DTO 객체 가져오기
		FoodResponseDTO foodResponseDTO = new FoodResponseDTO();
		foodResponseDTO.setName("토마토 라멘");
		foodResponseDTO.setRestaurantName("카토멘");
		foodResponseDTO.setAddress("서울 강남구 삼성로85길 39 가리온빌딩 1층 카토멘");
		foodResponseDTO.setType("퓨전");
		
		// ObjectMapper로 DTO -> Map
		body = objectMapper.convertValue(foodResponseDTO, Map.class);		
		
		return restApiResponse.setResponse(result, header, body);
	}
}

