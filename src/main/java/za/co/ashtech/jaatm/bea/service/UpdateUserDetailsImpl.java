package za.co.ashtech.jaatm.bea.service;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.stereotype.Service;
import za.co.ashtech.jaatm.bea.dto.Address;
import za.co.ashtech.jaatm.bea.dto.User;
import za.co.ashtech.jaatm.bea.model.JaatmUser;
import za.co.ashtech.jaatm.bea.repository.JaatmUserRepository;
import za.co.ashtech.jaatm.bea.util.JaatmConstants;
import za.co.ashtech.jaatm.bea.util.JaatmOperationException;

@Service
public class UpdateUserDetailsImpl extends BaseService implements UpdateUserDetails {
	

	public UpdateUserDetailsImpl(JaatmUserRepository jaatmUserRepository) {
		super(jaatmUserRepository);
	}

	@Override
	public void updateAccount(String juid, User user) {
		try {

			JaatmUser jaatmUser = getJaatmUser(juid);
			
			// Convert to Optional to check if value was updated
			Optional<String> optFirstname = Optional.ofNullable(user.getFirstname());
			optFirstname.ifPresent(jaatmUser::setFirstName);
			Optional<String> optLastname = Optional.ofNullable(user.getLastname());
			optLastname.ifPresent(jaatmUser::setLastName);
			Optional<LocalDate> optDob = Optional.ofNullable(user.getDob());
			optDob.ifPresent(jaatmUser::setDob);
			
			Optional<Address> optAddress = Optional.ofNullable(user.getAddress());
			optAddress.ifPresent(optad -> {
				Optional<String> optStreetNumber = Optional.ofNullable(optad.getStreetNumber());
				optStreetNumber.ifPresent(jaatmUser.getAddress()::setStreetNumber);
				Optional<String> optStreetName = Optional.ofNullable(optad.getStreetName());
				optStreetName.ifPresent(jaatmUser.getAddress()::setStreetName);
				Optional<String> optTown = Optional.ofNullable(optad.getTown());
				optTown.ifPresent(jaatmUser.getAddress()::setTown);
				Optional<String> optCity = Optional.ofNullable(optad.getCity());
				optCity.ifPresent(jaatmUser.getAddress()::setCity);
				Optional<String> optProvince = Optional.ofNullable(optad.getProvince());
				optProvince.ifPresent(jaatmUser.getAddress()::setProvince);
				Optional<String> optPostalCode = Optional.ofNullable(optad.getPostalCode());
				optPostalCode.ifPresent(jaatmUser.getAddress()::setPostalCode);				
			});
			
			//Update user details
			getJaatmUserRepository().save(jaatmUser);

		}catch (Exception e) {
			throw new JaatmOperationException(JaatmConstants.ERROR_CODE_100);
		}
	}

}
