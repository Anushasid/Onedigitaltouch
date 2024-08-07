package com.bvb.digitaltouch.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bvb.Exception.BvbMcaException;
import com.bvb.digitaltouch.dao.BillRepository;
import com.bvb.digitaltouch.dao.UserRepository;
import com.bvb.digitaltouch.dto.BillDto;
import com.bvb.digitaltouch.modules.Bill;
import com.bvb.digitaltouch.modules.User;
import com.bvb.digitaltouch.service.BillService;
import com.bvb.digitaltouch.util.BillUtil;

@Service
public class BillServiceImpl implements BillService {

	Logger logger = LoggerFactory.getLogger(BillServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BillRepository billRepository;

	public List<BillDto> getAllBill() {
		List<BillDto> listOfDtos = billRepository.findAll().stream().map(BillUtil::convertBillEntityToDto)
				.collect(Collectors.toList());
		return listOfDtos;
	}

	public void createBill(BillDto billDto, Integer userId) throws BvbMcaException {
		Optional<User> user = userRepository.findById(userId);

		if (user.isPresent()) {
			logger.info("User is present");

			Optional<Bill> existingBill = billRepository.findByUserIdAndServiceType(userId, billDto.getServiceType());

			if (existingBill.isPresent()) {
				logger.info("Bill already exists for user ID {} and service type {}", userId, billDto.getServiceType());
			} else {
				Bill newBill = BillUtil.convertBillDtoToEntity(billDto);
				logger.info("Bill created successfully");
				newBill.setUser(user.get());
				billRepository.save(newBill);
			}
		} else {
			logger.info("User with user Id {} is not present",userId);
			throw new BvbMcaException("User not found");
			
		}

	}

}
