package com.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.registration.dto.UserDto;
import com.registration.dto.UserDto1;
import com.registration.dto.UserDto2;
import com.registration.model.User;
import com.registration.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public void saveUser(UserDto userDTO) throws Exception {
		User user = new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setMobileNo(userDTO.getMobileNo());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		// user.setPassword(userDTO.getPassword());

		MultipartFile document = userDTO.getDocument();
		if (document != null && !document.isEmpty()) {
			user.setDocumentName(document.getOriginalFilename());
			user.setDocumentType(document.getContentType());
			user.setDocumentData(document.getBytes());
		}

		userRepository.save(user);
	}

	public void saveUser(UserDto1 userDto) throws Exception {
		User user = new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setMobileNo(userDto.getMobileNo());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		// user.setPassword(userDto.getPassword());

		MultipartFile document = userDto.getDocument();
		if (document != null && !document.isEmpty()) {
			user.setDocumentName(document.getOriginalFilename());
			user.setDocumentType(document.getContentType());
			user.setDocumentData(document.getBytes());
		}
		userRepository.save(user);
	}

	public void saveUser(UserDto2 userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setMobileNo(userDto.getMobileNo());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setPassword(userDto.getPassword());

		userRepository.save(user);
	}
}