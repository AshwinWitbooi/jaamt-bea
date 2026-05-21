package za.co.ashtech.jaatm.bea.aop;

import java.time.LocalDateTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import za.co.ashtech.jaatm.bea.dto.Account;
import za.co.ashtech.jaatm.bea.dto.AccountOpRequest;
import za.co.ashtech.jaatm.bea.dto.TransferRequest;
import za.co.ashtech.jaatm.bea.model.JaatmTransaction;
import za.co.ashtech.jaatm.bea.repository.JaatmTransactionRepository;

@Slf4j
@Aspect
@Component
public class TransactionRecorderAdvice {
	
	private final JaatmTransactionRepository jaatmTransactionRepository;
		
	public TransactionRecorderAdvice(JaatmTransactionRepository jaatmTransactionRepository) {
		super();
		this.jaatmTransactionRepository = jaatmTransactionRepository;
	}


	@Pointcut("execution(* za.co.ashtech.jaatm.bea.service.*.*(..)) " +
	          "&& !execution(* za.co.ashtech.jaatm.bea.service.BaseService.*(..))")
	public void serviceLayerAroundExecution() {}
	
	
    // Advice that runs before any method matched by the pointcut
    @Around("execution(* za.co.ashtech.jaatm.bea.service.*.*(..))")
    public Object aroundTxRecorder(ProceedingJoinPoint joinPoint) throws Throwable {
    	log.debug("--->>>	:::	BEFORE ARROUND");
    	JaatmTransaction jaatmTransaction = new JaatmTransaction();
    	jaatmTransaction.setTransactionDate(LocalDateTime.now());
    	//JUID is always the first arg for service methods
    	jaatmTransaction.setJuid(joinPoint.getArgs()[0].toString());
    	//Check if args length more th 1
    	String signatureName = joinPoint.getSignature().getName();
    	String txAction = null;
    	String txAmount = null;
    
    	switch (signatureName) {
        case "performAccountOperation":
        	AccountOpRequest operationRequest = (AccountOpRequest) joinPoint.getArgs()[1];
        	txAction = operationRequest.getOperation().getValue().toUpperCase();
        	txAmount = operationRequest.getAmount().toString();
            break;
        case "transfer":
        	TransferRequest transferRequest = (TransferRequest) joinPoint.getArgs()[1];
        	txAction = "transfer".toUpperCase();
        	txAmount = transferRequest.getAmount();
            break;
        case "updateAccount":
        	txAction = "updateAccount".toUpperCase();
            break;
        case "getAccountBalance":
        	txAction = "getAccountBalance".toUpperCase();
            break;
        default:
        	txAction = "N/A";
    	}
    	
    	jaatmTransaction.setTransactionType(txAction);   	
    	
    	//Get and cast object to retrieve amount
    	Object result = joinPoint.proceed(); // Executes target method
    	log.debug("--->>>	:::	AFTER ARROUND");
    	
    	//Only overwrite amount when action is getBalance
    	if(txAction.equalsIgnoreCase("getAccountBalance")) {
    		Account account = (Account) result;    		
    		txAmount = account.getBalance();
    	}
    	
    	jaatmTransaction.setAmount(txAmount); 
    	jaatmTransaction.setStatus("STATUS");
    	
    	//Persist transaction
    	jaatmTransactionRepository.save(jaatmTransaction);

        return result;
    }

}
