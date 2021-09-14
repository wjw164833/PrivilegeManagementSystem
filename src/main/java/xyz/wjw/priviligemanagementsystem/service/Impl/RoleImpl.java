package xyz.wjw.priviligemanagementsystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wjw.priviligemanagementsystem.bo.RoleDeleteBo;
import xyz.wjw.priviligemanagementsystem.bo.RoleSelectBo;
import xyz.wjw.priviligemanagementsystem.dto.RoleSelectQuery;
import xyz.wjw.priviligemanagementsystem.entity.Role;
import xyz.wjw.priviligemanagementsystem.entity.User;
import xyz.wjw.priviligemanagementsystem.mapper.RoleMapper;
import xyz.wjw.priviligemanagementsystem.service.RoleService;
import xyz.wjw.priviligemanagementsystem.util.DataCheckUtils;
import xyz.wjw.priviligemanagementsystem.util.PaginationUtils;
import xyz.wjw.priviligemanagementsystem.vo.*;

import java.util.List;


@Service
public class RoleImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    

    @Override
    public Result roleSelect(RoleSelectBo roleSelectBo, String id) {
        int number = 1;
        int page = 1;
        if(id==null){
            number = roleSelectBo.getNumber();
            page = roleSelectBo.getPage();
            //分页参数是否正确
            DataCheckUtils.isValid(PaginationUtils.isPagingParameters(number, page), "分页参数错误!");
        }
        //查询项目组评分 mybatis
        List<Object> result = roleMapper.roleSelect(new RoleSelectQuery(PaginationUtils.getPageIndex(page, number),number, id,roleSelectBo.getName(),
                roleSelectBo.getRemark(),roleSelectBo.getIsdeleted(),roleSelectBo.getStatus()));
        if(id!=null) {
            int sum = ((List<Integer>) result.get(1)).get(0);
            if(sum==0){
                return xyz.wjw.priviligemanagementsystem.vo.Result.error("角色不存在");
            }
            return  xyz.wjw.priviligemanagementsystem.vo.Result.success(((List<SelectRoleVo>) result.get(0)).get(0));
        }
        int sum = ((List<Integer>) result.get(1)).get(0);
        List<SelectRoleVo> ClassVos = (List<SelectRoleVo>) result.get(0);
        PaginationDate paginationDate = PaginationUtils.getPaginationDate(number, page, sum);
        //记录总数为0
        if (sum == 0) {
            SelectRoleVo selectRoleVo = new SelectRoleVo();
            ClassVos.add(selectRoleVo);
            return xyz.wjw.priviligemanagementsystem.vo.Result.success(new QueryReturnDate(paginationDate, ClassVos));
        }
        //当前页大于总页数
        if (PaginationUtils.isValid(paginationDate)) {
            return xyz.wjw.priviligemanagementsystem.vo.Result.error("当前页大于总页数");
        }
        return xyz.wjw.priviligemanagementsystem.vo.Result.success(new QueryReturnDate(paginationDate, ClassVos));
    }

    @Override
    public Result roleAdd(RoleSelectBo roleSelectBo) {
        Role role = new Role();
        role.setId(roleSelectBo.getId());
        role.setName(roleSelectBo.getName());
        role.setRemark(roleSelectBo.getRemark());
        role.setStatus(roleSelectBo.getStatus());
        int row =roleMapper.insert(role);
        //判断插入结果
        if (row == 0) {
            return Result.error("添加角色失败");
        }
        return Result.success();
    }


    @Override
    public Result roleUpdate(RoleSelectBo roleSelectBo) {

        Role role = new Role();
        role.setId(roleSelectBo.getId());
        role.setName(roleSelectBo.getName());
        role.setRemark(roleSelectBo.getRemark());
        role.setStatus(roleSelectBo.getStatus());
        UpdateWrapper<Role> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(Role::getId, roleSelectBo.getId());
        int row =roleMapper.update(role, updateWrapper);
        //判断插入结果
        if (row == 0) {
            return Result.error("修改角色失败");
        }
        return Result.success();
    }

    @Override
    public Result roleDelete(@NonNull List<String> ids) {
        int row =roleMapper.roleDelete(ids);
        //判断插入结果
        if (row == 0) {
            return Result.error("删除角色失败");
        }
        return Result.success();
    }
}
