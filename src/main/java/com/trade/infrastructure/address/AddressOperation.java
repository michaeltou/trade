package com.trade.infrastructure.address;

import java.util.List;

public interface AddressOperation {

	
	boolean addAddress(AddressDO address);
	AddressDO getDefaultAddressByUserAndType(AddressDO address);
	List<AddressDO> selectUserAddressByUserAndType(AddressDO address);
	boolean deleteAddressByAddressId(Long addressId);
}
