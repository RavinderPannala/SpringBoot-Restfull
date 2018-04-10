package com.example.webService.RestFullService.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

	// URI Versioning
	@GetMapping("/getUser1")
	public UserV1 getUser1() {
		return new UserV1("Ravinder");

	}

	@GetMapping("/getUser2")
	public UserV2 getUser2() {
		return new UserV2(new Name("Ravinder", "Reddy"));
	}

	// Parameter Versioning
	@GetMapping(value = "/user/param", params = "version=1")
	public UserV1 getParameterVersioningV1() {
		return new UserV1("Ravinder");
	}

	@GetMapping(value = "/user/param", params = "version=2")
	public UserV2 getParameterVersioningV2() {
		return new UserV2(new Name("Ravinder", "Reddy"));
	}

	// Header Versioning
	@GetMapping(value = "/user/header", headers = "X-API-VERSION=1")
	public UserV1 getHeaderVersioningV1() {
		return new UserV1("Ravinder");
	}

	@GetMapping(value = "/user/header", headers = "X-API-VERSION=2")
	public UserV2 getHeaderVersioningV2() {
		return new UserV2(new Name("Ravinder", "Reddy"));
	}

	// Mimetype Versioning
	@GetMapping(value = "/user/mimetype", produces = "application/vnd.company.app-V1+json")
	public UserV1 getMimeTypeVersioningV1() {
		return new UserV1("Ravinder");
	}

	@GetMapping(value = "/user/mimetype", produces = "application/vnd.company.app-V2+json")
	public UserV2 getMimeTypeVersioningV2() {
		return new UserV2(new Name("Ravinder", "Reddy"));
	}

}
