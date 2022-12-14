package o.study.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * 계정
 * @author jsw
 *
 */
@Getter
@AllArgsConstructor(access=AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@EqualsAndHashCode(of="id")
@Table(name="O_STUDY_ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;																					// 사번
	
	@Column(length=64)
	private String name;				 															// 이름

	@Column(length=64, unique=true)
    private String email;																			// 이메일
	
	@Column(length=64, insertable=true, updatable=false)
	private String password;																	// 비밀번호
	
	@Column(length=1, updatable=false)
	private int failCount;																			// 비밀번호 틀린 횟수
	
	@Column(length=8, insertable=true, updatable=false)
	@Enumerated(EnumType.STRING)
	private Status status;																			// 상태 (계정)
	
	@Column(length=8, insertable=true, updatable=false)
	@Enumerated(EnumType.STRING)
	private UserStatus userStatus;														// 상태 (사용자)
	
	@Column(length=8, insertable=true)
	@Enumerated(EnumType.STRING)
	private Role role;																				// 권한
	
	@Column()
	private LocalDate birthday;																// 생일
	
	@Column(updatable=false)
	private LocalDateTime lastLoginTime;											// 마지막 로그인 시간
	
	/**
	 * Account 테이블의 계정 상태(status)에 대한 정의
	 * @author jsw
	 *
	 */
	@Getter
	@RequiredArgsConstructor
	public enum Status {
		ACTIVE("ACTIVE", "활성화"),
		BLOCKED("BLOCKED", "잠김"),
		EXPIRED("EXPIRED", "만료됨");
		
		private final String key;
		private final String value;
	}
	
	/**
	 * Account 테이블의 사용자의 상태(userStatus)에 대한 정의
	 * @author jsw
	 *
	 */
	@Getter
	@RequiredArgsConstructor
	public enum UserStatus {
		ONLINE("ONLINE", "온라인"),
		OFFLINE("OFFLINE", "오프라인"),
		AFK("AFK", "자리비움"),
		BUSY("BUSY", "다른용무중");
		
		private final String key;
		private final String value;
	}
	
	/**
	 * Account 테이블의 권한(role)에 대한 정의
	 * @author jsw
	 *
	 */
	@Getter
	@RequiredArgsConstructor
	public enum Role {
		USER("USER", "직원"),
		MANAGER("MANAGER", "팀장"),
		ADMIN("ADMIN", "관리자");
		
		private final String key;
		private final String value;
	}
}


