package o.study.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * 게시판
 * @author jsw
 */
@Data
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode(of="id")
@Table(name="O_STUDY_BOARD")
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;																					// 글번호
	
	@Column(length=1000)
	private String title;				 																// 제목

	@Column(length=10000, unique=true)
    private String content;																		// 내용
	
	@Column(length=100)
	private String author;																			// 작성자
	
	@Column()
	@CreatedDate
	private LocalDateTime createdDate;												// 등록시각
	
	@Column()
	@LastModifiedDate
	private LocalDateTime updatedDate;												// 수정시각
	
	@Column()
	private long views;																				// 조회수
}


