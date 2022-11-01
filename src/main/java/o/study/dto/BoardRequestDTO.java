package o.study.dto;

import java.time.LocalDateTime;

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
public class BoardRequestDTO {
	private long id;												// 글번호
	
	@Max(value=1000, message="title이 너무 깁니다")	
	private String title;										// 제목
	
	@Max(value=10000, message="content가 너무 깁니다")
	private String content;								// 내용
	
	@Max(value=60, message="author가 너무 깁니다")
	private String author;									// 작성자

	private LocalDateTime createdDate	;		// 등록시각
	private LocalDateTime updatedDate;		// 수정시각
	private long views;										// 조회수
}
