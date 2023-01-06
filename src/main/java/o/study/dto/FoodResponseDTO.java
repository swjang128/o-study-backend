package o.study.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
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
public class FoodResponseDTO {
	private long foodId;									// 음식 ID
	private long restaurantId;							// 식당 ID
	private String name;									// 음식명
	private String restaurantName;				// 식당명
	private String type;										// 음식 종목
	private String address;								// 식당 주소
	private long picks;										// 음식 선택횟수
	private long visits;										// 식당 방문횟수
}
