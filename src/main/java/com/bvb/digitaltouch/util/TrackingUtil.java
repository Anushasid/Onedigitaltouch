package com.bvb.digitaltouch.util;

import org.springframework.beans.BeanUtils;

import com.bvb.digitaltouch.dto.TrackingDto;

import com.bvb.digitaltouch.modules.Tracking;


public class TrackingUtil {
	
	public static TrackingDto convertTrackingEntityToDto(Tracking tracking) {
		TrackingDto dto=new TrackingDto();
		BeanUtils.copyProperties(tracking, dto);
		
		return dto;
    }

	
	
	public static Tracking convertTrackingDtoToEntity(TrackingDto dto)
	{
		Tracking Tracking=new Tracking();
		BeanUtils.copyProperties(dto,Tracking);
		
		return Tracking;
	}

}
