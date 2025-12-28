package za.co.ashtech.jaatm.bea.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import jakarta.annotation.Generated;
import za.co.ashtech.jaatm.bea.dto.GetAccountResponse;
import za.co.ashtech.jaatm.bea.dto.Result;
import za.co.ashtech.jaatm.bea.service.IViewAccountBalance;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-26T15:33:20.126202100+02:00[Africa/Johannesburg]")
@Controller
@RequestMapping("/api/v1")
public class AccountApiController implements AccountApi {

    private final NativeWebRequest request;
    
    @Autowired
    private IViewAccountBalance viewAccountBalance;

    public AccountApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

	@Override
	public ResponseEntity<GetAccountResponse> getAccountBalance(String juid) {
				
		return ResponseEntity.ok(viewAccountBalance.getAccountBalance(juid));
	}

}
