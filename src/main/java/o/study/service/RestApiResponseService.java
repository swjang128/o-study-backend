package o.study.service;

import java.util.HashMap;
import org.springframework.stereotype.Service;

import o.study.config.RestApiHeader;

@Service
public class RestApiResponseService {
	/**
	 * API Response Header 작성
	 * @param header
	 * @param RestApiResponse
	 * @return
	 */
	public HashMap<String, Object> apiHeaderResponse(HashMap<String, Object> header, RestApiHeader restApiHeader) {
		header.put("code", restApiHeader.code);
		header.put("result", restApiHeader.result);
		header.put("message", restApiHeader.message);

		return header;
	}

	/**
	 * API Response Result 작성
	 * 
	 * @param result, header, body
	 * @return result
	 */
	public HashMap<String, Object> apiResponseResult(HashMap<String, Object> result, HashMap<String, Object> header, HashMap<String, Object> body) {
		result.putAll(header);
		result.putAll(body);

		return result;
	}
}
