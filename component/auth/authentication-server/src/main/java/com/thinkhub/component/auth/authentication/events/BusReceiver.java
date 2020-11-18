package com.thinkhub.component.auth.authentication.events;

import com.thinkhub.component.auth.authentication.service.impl.ResourceService;
import com.thinkhub.service.organization.entity.po.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BusReceiver {

    @Autowired
    private ResourceService resourceService;

    public void handleMessage(Resource resource) {
        log.info("Received Message:<{}>", resource);
        resourceService.saveResource(resource);
    }
}
