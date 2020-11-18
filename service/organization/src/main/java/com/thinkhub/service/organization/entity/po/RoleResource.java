package com.thinkhub.service.organization.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.thinkhub.component.common.web.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("role_resource_relation")
public class RoleResource extends BasePo {
    private String roleId;
    private String resourceId;
}