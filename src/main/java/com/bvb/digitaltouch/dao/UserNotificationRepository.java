package com.bvb.digitaltouch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bvb.digitaltouch.modules.UserNotification;
public interface UserNotificationRepository extends JpaRepository<UserNotification,Integer> {

}
