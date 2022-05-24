package com.example.client.service;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.client.dto.UserResponseDTO;

@Service
public class RestTemplateService {
	
//	public String hello() {
	public UserResponseDTO hello() {
//		return "service hello";
		URI uri = UriComponentsBuilder.fromUriString("")
	}
}
