package o.study.dto;

import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Rest API Header Response DTO
 * @author jsw
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestApiResultDTO {	
	private RestApiHeaderDTO header;			// Header
	private HashMap<String, Object> body;			// Body
}
