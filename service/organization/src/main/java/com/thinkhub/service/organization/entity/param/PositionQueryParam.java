package com.thinkhub.service.organization.entity.param;

import com.thinkhub.service.organization.entity.po.Position;
import com.thinkhub.component.common.web.entity.param.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionQueryParam extends BaseParam<Position> {
    private String name;
}
