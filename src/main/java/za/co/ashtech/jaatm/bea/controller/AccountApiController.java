package za.co.ashtech.jaatm.bea.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import jakarta.annotation.Generated;
import za.co.ashtech.jaatm.bea.dto.Account;
import za.co.ashtech.jaatm.bea.service.ViewAccountBalance;
import za.co.ashtech.jaatm.bea.util.JaatmOperationException;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-26T15:33:20.126202100+02:00[Africa/Johannesburg]")
@Controller
@RequestMapping("/api/v1")
public class AccountApiController implements AccountApi {

    private final NativeWebRequest request;
    
    @Autowired
    private  final ViewAccountBalance viewAccountBalance;

    public AccountApiController(NativeWebRequest request, ViewAccountBalance viewAccountBalance) {
        this.request = request;
        this.viewAccountBalance = viewAccountBalance;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

	@Override
	public ResponseEntity<Account> getAccountBalance(String juid) throws JaatmOperationException {
				
		return ResponseEntity.ok(viewAccountBalance.getAccountBalance(juid));
	}

}
