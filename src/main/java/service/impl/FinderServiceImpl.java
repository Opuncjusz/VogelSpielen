package service.impl;

import org.springframework.stereotype.Service;

import common.CommonTO;
import service.FinderService;

@Service
public class FinderServiceImpl implements FinderService {

	@Override
	public long getStatus() {
		return CommonTO.STATUS_SEARCH;
	}

}
