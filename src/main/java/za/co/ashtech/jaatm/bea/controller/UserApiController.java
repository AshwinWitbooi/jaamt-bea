package za.co.ashtech.jaatm.bea.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import za.co.ashtech.jaatm.bea.dto.User;
import za.co.ashtech.jaatm.bea.service.UpdateUserDetails;
import za.co.ashtech.jaatm.bea.service.ViewUserAccountDetails;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-08T20:28:19.081308300+02:00[Africa/Johannesburg]")
@Controller
@RequestMapping("/api/v1")
public class UserApiController implements UserApi {

    private final NativeWebRequest request;
    private final ViewUserAccountDetails userAccountDetails;
    private final UpdateUserDetails updateUserDetails;

    public UserApiController(NativeWebRequest request, ViewUserAccountDetails service, UpdateUserDetails updateUserDetails) {
        this.request = request;
        this.userAccountDetails = service;
        this.updateUserDetails = updateUserDetails;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
    
    @Override
    public ResponseEntity<User> userJuidGet(String juid) {    	
    	
    	return ResponseEntity.ok(userAccountDetails.getUserAccount(juid));
    }

	@Override
	public ResponseEntity<Void> userJuidPut(String juid, @Valid User user) {

		updateUserDetails.updateAccount(juid, user);
	    return ResponseEntity.ok().build();
		
	}

}
