package o.study.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * 식당
 * @author jsw
 */
@Data
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode(of="id")
@Table(name="O_STUDY_RESTAURANT")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;																					// ID
	
	@Column(length=30)
	private String name;				 															// 식당명

	@Column(length=1000)
	private String address;																		// 주소
	
	@OneToMany
	@JoinColumn(name = "RESTAURANT_ID")
	private List<Food> food = new ArrayList<>();									// 음식 메뉴
	
	@Column()
	@CreatedDate
	private LocalDateTime createdDate;												// 등록시각
	
	@Column()
	@LastModifiedDate
	private LocalDateTime updatedDate;												// 수정시각
	
	@Column()
	private long visits;																				// 방문 횟수
}


