package com.trade.infrastructure.address;

import java.util.List;

import net.sf.json.JSONObject;

import org.apache.ibatis.session.SqlSession;

import com.trade.infrastructure.MyBatisOperator;
import com.trade.infrastructure.liveroomoffer.LiveRoomOfferDO;
import com.trade.infrastructure.liveroomoffer.LiveRoomOfferOperation;

public class AddressOperator extends MyBatisOperator {

	public boolean addAddress(AddressDO address) {
		SqlSession session = mSessionFactory.openSession();
		try {
			AddressOperation oCInterface = session
					.getMapper(AddressOperation.class);
			oCInterface.addAddress(address);
			session.commit();
		} catch (Exception e) {
			log.error("add live room offer  failed,args:"
					+ JSONObject.fromObject(address).toString(), e);
		} finally {
			session.close();
		}
		return true;
	}

	public AddressDO getDefaultAddressByUserAndType(Long userId, int addressType) {
		return null;
	}

	public List<AddressDO> selectUserAddressByUserAndType(long userId,
			int addressType) {
		SqlSession session = mSessionFactory.openSession();
		List<AddressDO> result = null;
		try {
			AddressOperation oCInterface = session
					.getMapper(AddressOperation.class);
			AddressDO queryAddress = new AddressDO();
			queryAddress.setUser_id(userId);
			queryAddress.setType(addressType);
			result = oCInterface.selectUserAddressByUserAndType(queryAddress);
            log.info("address info:"+JSONObject.fromObject(result).toString());
		} catch (Exception e) {
			log.error("getOffer by roomId  failed,args:userId:" + userId+";addressType:"+addressType, e);
		} finally {
			session.close();
		}

		return result;
	}

	public boolean deleteAddressByAddressId(Long addressId){
		return true;
	}
}
