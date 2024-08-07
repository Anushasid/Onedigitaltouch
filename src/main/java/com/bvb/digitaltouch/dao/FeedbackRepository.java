package com.bvb.digitaltouch.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bvb.digitaltouch.modules.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{

}
