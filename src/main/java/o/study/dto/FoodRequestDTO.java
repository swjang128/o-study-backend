package o.study.dto;

import javax.validation.constraints.Max;
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
public class FoodRequestDTO {
	private long id;												// ID
	
	@Max(value=30, message="음식명이 너무 깁니다")	
	private String name;									// 음식명
	
	@Max(value=10, message="올바른 음식 종류를 선택하세요")
	private String type;										// 종목 (한식, 일식, 중식 등)

	private long picks;										// 선택 횟수
}
