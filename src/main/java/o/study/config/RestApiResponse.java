package o.study.config;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class RestApiResponse {
	/**
	 * API Response Header 작성
	 * @param header
	 * @param apiErrorResponse
	 * @return
	 */
	public Map<String, Object> setHeader(Map<String, Object> header, RestApiHeader restApiHeader) {
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
	public Map<String, Object> setResponse(Map<String, Object> result, Map<String, Object> header, Map<String, Object> body) {
		result.put("header", header);
		result.put("body", body);

		return result;
	}
}
