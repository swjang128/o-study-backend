package o.study.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import o.study.config.RestApiHeaderResponse;
import o.study.dto.AccountResponseDTO;
import o.study.dto.BoardRequestDTO;
import o.study.dto.AccountRequestDTO;
import o.study.dto.MailDTO;
import o.study.dto.RestApiResultDTO;
import o.study.entity.Account;
import o.study.entity.Account.Status;
import o.study.entity.Account.UserStatus;
import o.study.entity.Board;
import o.study.repository.AccountRepository;
import o.study.specification.AccountSpecification;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardService {
	@Autowired
	ModelMapper modelMapper;

	public RestApiResultDTO read(BoardRequestDTO boardRequestDTO) {
		return null;
	}
}

