package com.trade.infrastructure.liveroomoffer;

import java.util.List;

public interface LiveRoomOfferOperation {
      Long insertLiverRoomOffer(LiveRoomOfferDO liveroomOfferDO);
      
      List<LiveRoomOfferDO> selectOfferIDByLiveRoomId(Long liverRoomId);
}
