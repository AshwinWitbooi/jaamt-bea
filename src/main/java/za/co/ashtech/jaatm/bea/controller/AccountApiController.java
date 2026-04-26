package za.co.ashtech.jaatm.bea.controller;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import za.co.ashtech.jaatm.bea.dto.Account;
import za.co.ashtech.jaatm.bea.dto.AccountOpRequest;
import za.co.ashtech.jaatm.bea.service.AccountOperation;
import za.co.ashtech.jaatm.bea.service.ViewAccountBalance;
import za.co.ashtech.jaatm.bea.util.JaatmOperationException;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-26T15:33:20.126202100+02:00[Africa/Johannesburg]")
@Controller
@RequestMapping("/api/v1")
public class AccountApiController implements AccountApi {

    private final NativeWebRequest request;    
    private  final ViewAccountBalance viewAccountBalance;    
    private  final AccountOperation accountOperation;
    

    public AccountApiController(NativeWebRequest request, ViewAccountBalance viewAccountBalance,AccountOperation accountOperation) {
        this.request = request;
        this.viewAccountBalance = viewAccountBalance;
        this.accountOperation = accountOperation;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

	@Override
	public ResponseEntity<Account> getAccountBalance(String juid) throws JaatmOperationException {
				
		return ResponseEntity.ok(viewAccountBalance.getAccountBalance(juid));
	}

	@Override
	public ResponseEntity<Void> postAccountOperation(String juid, @Valid AccountOpRequest accountOpRequest) {
			
			accountOperation.performAccountOperation(juid, accountOpRequest);
		    return ResponseEntity.ok().build();
	}

}
