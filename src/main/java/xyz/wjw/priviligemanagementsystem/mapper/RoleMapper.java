package xyz.wjw.priviligemanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xyz.wjw.priviligemanagementsystem.dto.RoleSelectQuery;
import xyz.wjw.priviligemanagementsystem.entity.Role;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<Object> roleSelect(RoleSelectQuery roleSelectQuery);

    int roleDelete(List<String> ids);
}
