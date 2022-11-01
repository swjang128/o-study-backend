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
public class BoardResponseDTO {	
	private long id;												// 글번호
	private String title;										// 제목
	private String content;								// 내용
	private String author;									// 작성자
	private LocalDateTime createdDate	;		// 등록시각
	private LocalDateTime updatedDate;		// 수정시각
	private long views;										// 조회수
}
