package com.example.client.service;

import java.net.URI;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;  
import com.example.client.dto.UserRequestDTO;


@Service
public class RestTemplateService {

	// http://localhost/api/server/hello
	// response
	public UserResponseDTO hello() {
		URI uri = UriComponentsBuilder.fromUriString("http://localhost:9191").path("/api/server/hello")
//					.queryParam("name", "doyeon")
//					.queryParam("age", 33)
				.encode().build().toUri();

		System.out.println(uri.toString());

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<UserResponseDTODTO> result = restTemplate.getForEntity(uri, UserResponseDTODTO.class);

		System.out.println(result.getStatusCodeValue());
		System.out.println(result.getBody());

		return result.getBody();
	}

	// server가 어떤식으로 내려줄지 모를때, 그냥 출력만 해서 확인하고자 할때
	public void post() {

		URI uri = UriComponentsBuilder.fromUriString("http://localhost:9191")
				.path("/api/server/user/{userId}/name/{userName}").encode().build().expand(100, "kanggamchan").toUri(); // uri로
																														// 변경해준다.

		System.out.println(uri);

		UserRequestDTO req = new UserRequestDTO();
		req.setName("gildong");
		req.setAge(22);

		RestTemplate restTemplate = new RestTemplate();
		// restTemplate.postForEntity(url, request, responseType)
		ResponseEntity<String> response = restTemplate.postForEntity(uri, req, String.class);

		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		System.out.println(response.getBody());
	}

	public UserResponseDTODTO exchange() {

		URI uri = UriComponentsBuilder.fromUriString("http://localhost:9191")
				.path("/api/server/user/{userId}/name/{userName}").encode().build().expand(100, "leesunsin").toUri(); // uri로
																														// 변경해준다.

		System.out.println(uri);

		UserRequestDTO req = new UserRequestDTO();
		req.setName("aaa");
		req.setAge(77);

		RequestEntity<UserRequestDTO> requestEntity = RequestEntity.post(uri)
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON).header("x-authorization", "abcd")
				.header("custom-header", "ffff").body(req);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserResponseDTODTO> response = restTemplate.exchange(requestEntity, UserResponseDTODTO.class);

		return response.getBody();
	}

	public Req<UserResponseDTODTO> genericExchange() {

		URI uri = UriComponentsBuilder.fromUriString("http://localhost:9191")
				.path("/api/server/user/{userId}/name/{userName}").encode().build().expand(100, "kanggamchan").toUri(); // uri로
																														// 변경해준다.

		System.out.println(uri);

		// http body -> object -> object mapper -> json -> rest template -> http body
		// json

		UserRequest userRequest = new UserRequest();
		userRequest.setName("smile");
		userRequest.setAge(33);

		Req<UserRequest> req = new Req<>();
		req.setHeader(new Req.Header());

		req.setHttpBody(userRequest);

		RequestEntity<Req<UserRequest>> requestEntity = RequestEntity.post(uri)
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON).header("x-authorization", "abcd")
				.header("custom-header", "ffff").body(req);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Req<UserResponseDTO>> response = restTemplate.exchange(requestEntity,
				new ParameterizedTypeReference<Req<UserResponseDTO>>() {
				});

		return response.getBody();
	}

}
