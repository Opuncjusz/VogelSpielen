package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import common.CommonTO;
import service.FinderService;
import starter.DevelopmentConfiguration;

@Service
public class FinderServiceImpl implements FinderService {

    private static final Logger LOG = LoggerFactory.getLogger(DevelopmentConfiguration.class);

	@Override
	public long getStatus() {
		return CommonTO.STATUS_SEARCH;
	}

	@Override
	public List<String> getCurrentStakeholders() {
		List<String> stakeholders = new ArrayList<String>();
		
		stakeholders.add("123_QWE");
		stakeholders.add("456_GHJ");
		stakeholders.add("789_ZXC");
		stakeholders.add("000_IOP");
		
		return stakeholders;
	}

}
