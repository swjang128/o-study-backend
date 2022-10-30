package o.study.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import o.study.config.ApiResponse;
import o.study.config.MbtiResponse;
import o.study.config.ResponseManager;
import o.study.dto.ApiResponseDTO;
import o.study.dto.MbtiRequestDTO;
import o.study.dto.MbtiResponseDTO;

@Service
@Slf4j
@AllArgsConstructor
public class MbtiService {
	private final ResponseManager responseManager;
	
	/**
	 * MBTI Result 가져오기
	 * 
	 * @param MbtiRequestDTO, Map<String, Object>
	 * @return Integer status
	 * @return String result
	 * @message String message
	 */
	public Map<String, Object> result(MbtiRequestDTO mbtiRequestDTO, 
																			Map<String, Object> result) {
		// DTO Set
		ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
		MbtiResponseDTO mbtiResponseDTO = new MbtiResponseDTO();
		
		// 파라미터로 받아온 성향을 분석하여 MBTI값을 Response		
		mbtiResponseDTO = analyze(mbtiRequestDTO, mbtiResponseDTO);

		// Rest API Response
		apiResponseDTO = responseManager.apiResponse(apiResponseDTO, ApiResponse.SUCCESS);
		
		// 결과 리턴
		result.put("name", mbtiRequestDTO.getName());		// 이름은 요청받은 값 그대로 응답
		result.put("response", apiResponseDTO);
		result.put("mbti", mbtiResponseDTO);
		return result;
	}

	private MbtiResponseDTO analyze(MbtiRequestDTO mbtiRequestDTO, MbtiResponseDTO mbtiResponseDTO) {
		// 파라미터로 받아온 값을 변수로 선언
		String tendency = "I"; // 주의초점
		String recognition = "N"; // 인식기능
		String judgment = "F"; // 판단기능
		String lifestyle = "P"; // 생활양식
		StringBuffer mbti = new StringBuffer();

		// 파라미터로 받아온 값으로 MBTI 값 가공
		if (mbtiRequestDTO.getExtroversion() > mbtiRequestDTO.getIntroversion()) {
			tendency = "E";
		}
		if (mbtiRequestDTO.getSensing() > mbtiRequestDTO.getIntuition()) {
			recognition = "S";
		}
		if (mbtiRequestDTO.getThinking() > mbtiRequestDTO.getFeeling()) {
			judgment = "T";
		}
		if (mbtiRequestDTO.getJudging() > mbtiRequestDTO.getPerceiving()) {
			lifestyle = "J";
		}
		mbti.append(tendency);
		mbti.append(recognition);
		mbti.append(judgment);
		mbti.append(lifestyle);
		
		// MBTI Response
		mbtiResponseDTO.setType(MbtiResponse.valueOf(new String(mbti)).type);
		mbtiResponseDTO.setTitle(MbtiResponse.valueOf(new String(mbti)).title);
		mbtiResponseDTO.setContent(MbtiResponse.valueOf(new String(mbti)).content);
		
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
		String regDate = new SimpleDateFormat("yyyyMMddHHmmss").format(calendar.getTime());
		log.info("*********** regDate: {}", regDate);
		
		return mbtiResponseDTO;
	}
}
