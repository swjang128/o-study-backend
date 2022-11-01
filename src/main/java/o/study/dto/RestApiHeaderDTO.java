package o.study.dto;

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
public class RestApiHeaderDTO {	
	private int code;						// Code
	private String result;				// Result
	private String message;			// Message
}
