package com.weyoung.wxapp.system.service;

import com.weyoung.wxapp.system.domain.UserOnline;

import java.util.List;

public interface SessionService {

	List<UserOnline> list();

	boolean forceLogout(String sessionId);
}
