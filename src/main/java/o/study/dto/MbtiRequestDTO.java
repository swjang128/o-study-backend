package o.study.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MbtiRequestDTO {
	@NotNull(message="Not Null")
	@Min(value=0, message="0보다 작을 수 없습니다.")
	@Max(value=100, message="100을 초과할 수 없습니다.")
	private Integer introversion;						// 내향
	
	@NotNull(message="Not Null")
	@Min(value=0, message="0보다 작을 수 없습니다.")
	@Max(value=100, message="100을 초과할 수 없습니다.")
	private Integer extroversion;						// 외향
	
	@NotNull(message="Not Null")
	@Min(value=0, message="0보다 작을 수 없습니다.")
	@Max(value=100, message="100을 초과할 수 없습니다.")
	private Integer sensing;								// 감각
	
	@NotNull(message="Not Null")
	@Min(value=0, message="0보다 작을 수 없습니다.")
	@Max(value=100, message="100을 초과할 수 없습니다.")
	private Integer intuition;								// 직관
	
	@NotNull(message="Not Null")
	@Min(value=0, message="0보다 작을 수 없습니다.")
	@Max(value=100, message="100을 초과할 수 없습니다.")
	private Integer thinking;								// 사고
	
	@NotNull(message="Not Null")
	@Min(value=0, message="0보다 작을 수 없습니다.")
	@Max(value=100, message="100을 초과할 수 없습니다.")
	private Integer feeling;									// 감정
	
	@NotNull(message="Not Null")
	@Min(value=0, message="0보다 작을 수 없습니다.")
	@Max(value=100, message="100을 초과할 수 없습니다.")
	private Integer judging;								// 판단
	
	@NotNull(message="Not Null")
	@Min(value=0, message="0보다 작을 수 없습니다.")
	@Max(value=100, message="100을 초과할 수 없습니다.")
	private Integer perceiving;							// 인식
	
	@Size(min=1, max=32, message="1~32개의 문자열.")
	private String name;										// 이름
}
