package com.thinkhub.component.auth.authentication.provider;

import com.thinkhub.component.common.core.entity.vo.Result;
import com.thinkhub.service.organization.entity.po.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(name = "organization", fallback = ResourceProviderFallback.class)
public interface ResourceProvider {

    @GetMapping(value = "/resource/all")
    Result<Set<Resource>> resources();

    @GetMapping(value = "/resource/user/{username}")
    Result<Set<Resource>> resources(@PathVariable("username") String username);
}
