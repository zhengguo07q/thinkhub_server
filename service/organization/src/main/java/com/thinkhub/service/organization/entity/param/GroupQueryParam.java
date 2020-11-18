package com.thinkhub.service.organization.entity.param;

import com.thinkhub.service.organization.entity.po.Group;
import com.thinkhub.component.common.web.entity.param.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupQueryParam extends BaseParam<Group> {
    private String name;
}
