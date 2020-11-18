package com.thinkhub.component.auth.authorization.provider;

import com.thinkhub.component.auth.authorization.entity.Role;
import com.thinkhub.component.auth.authorization.entity.User;
import com.thinkhub.component.common.core.entity.vo.Result;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class OrganizationProviderFallback implements OrganizationProvider {

    @Override
    public Result<User> getUserByUniqueId(String uniqueId) {
        return Result.success(new User());
    }

    @Override
    public Result<Set<Role>> queryRolesByUserId(String userId) {
        return Result.success(new HashSet<Role>());
    }
}
