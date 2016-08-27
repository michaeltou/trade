package com.trade.infrastructure.liveroomoffer;

import java.util.List;

import net.sf.json.JSONObject;

import org.apache.ibatis.session.SqlSession;

import com.trade.infrastructure.MyBatisOperator;

public class LiveRoomOfferOperator extends MyBatisOperator {

	public Long insertLiverRoomOffer(LiveRoomOfferDO liveroomOfferDO) {
		Long id = null;
		SqlSession session = mSessionFactory.openSession();
		try {
			LiveRoomOfferOperation oCInterface = session
					.getMapper(LiveRoomOfferOperation.class);
			oCInterface.insertLiverRoomOffer(liveroomOfferDO);
			session.commit();
		} catch (Exception e) {
			log.error("add live room offer  failed,args:"
					+ JSONObject.fromObject(liveroomOfferDO).toString(), e);
		} finally {
			session.close();
		}
		return 1l;
	}

	public List<LiveRoomOfferDO> selectOfferIDByLiveRoomId(Long liverRoomId) {
		SqlSession session = mSessionFactory.openSession();
		List<LiveRoomOfferDO> result = null;
		try {
			LiveRoomOfferOperation oCInterface = session
					.getMapper(LiveRoomOfferOperation.class);
			result = oCInterface.selectOfferIDByLiveRoomId(liverRoomId);

		} catch (Exception e) {
			log.error("getOffer by roomId  failed,args:" + liverRoomId, e);
		} finally {
			session.close();
		}

		return result;
	}

}
