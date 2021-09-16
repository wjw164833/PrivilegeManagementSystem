package xyz.wjw.priviligemanagementsystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import xyz.wjw.priviligemanagementsystem.bo.UserDeleteBo;
import xyz.wjw.priviligemanagementsystem.bo.UserSelectBo;
import xyz.wjw.priviligemanagementsystem.dto.UserSelectQuery;
import xyz.wjw.priviligemanagementsystem.entity.User;
import xyz.wjw.priviligemanagementsystem.entity.UserDeleteEntity;
import xyz.wjw.priviligemanagementsystem.enums.ValidEnum;
import xyz.wjw.priviligemanagementsystem.mapper.UserMapper;
import xyz.wjw.priviligemanagementsystem.service.UserService;
import xyz.wjw.priviligemanagementsystem.util.DataCheckUtils;
import xyz.wjw.priviligemanagementsystem.util.PaginationUtils;
import xyz.wjw.priviligemanagementsystem.util.TokenUtils;
import xyz.wjw.priviligemanagementsystem.vo.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(
            UserSelectBo userSelectBo) {
        //数据校验
//        DataCheckUtils.isNotBlank(userSelectBo.getAccount(), "用户账号不能为空!");
//        DataCheckUtils.isNotBlank(userSelectBo.getPassword(), "密码不能为空!");
        //以用户类型与账号查询用户信息
        QueryWrapper<User> sectionQueryWrapper = new QueryWrapper<>();
        sectionQueryWrapper.lambda().eq(User::getAccount, userSelectBo.getAccount());
        User user = userMapper.selectOne(sectionQueryWrapper);
        //查询结果校验
        if (user == null) {
            return Result.error("账号不存在！");
        }
        if (!user.getIsdeleted().equals(ValidEnum.EFFECTIVE.getKey())) {
            return Result.error("用户已停用！");
        }
        System.out.println(DigestUtils.md5DigestAsHex(userSelectBo.getPassword().getBytes(StandardCharsets.UTF_8)));
        if (!user.getPassword().equals(userSelectBo.getPassword())) {
            return Result.error("密码错误！");
        }

        //生成token
        String token = TokenUtils.getJwtToken(user.getId(),user.getPassword());
        //修改登录Token
        User user1 = new User();
        user1.setLoginToken(token);
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(User::getAccount, userSelectBo.getAccount());
        // 2.根据条件修改对应的参数属性值
        int row = userMapper.update(user1, updateWrapper);
        //判断修改结果
        if (row == 0) {
            return Result.error("token保存失败，请联系管理员！");
        }

        return Result.success(new UserLoginVo(token));
    }

    @Override
    public Result userSelect(UserSelectBo userSelectBo, String id) {
        int number = 1;
        int page = 1;
        if(id==null){
            number = userSelectBo.getNumber();
            page = userSelectBo.getPage();
            //分页参数是否正确
            DataCheckUtils.isValid(PaginationUtils.isPagingParameters(number, page), "分页参数错误!");
        }
        //查询项目组评分 mybatis
        List<Object> result = userMapper.userSelect(new UserSelectQuery(PaginationUtils.getPageIndex(page, number),number, id,userSelectBo.getName(),
                userSelectBo.getPassword(), userSelectBo.getAccount(),userSelectBo.getSex(),userSelectBo.getMobile(),userSelectBo.getEmail(),
                userSelectBo.getDepId(),userSelectBo.getIsdeleted(),userSelectBo.getStatus()));
        if(id!=null) {
            int sum = ((List<Integer>) result.get(1)).get(0);
            if(sum==0){
                return Result.error("用户不存在");
            }
            return  Result.success(((List<SelectUserVo>) result.get(0)).get(0));
        }
        int sum = ((List<Integer>) result.get(1)).get(0);
        List<SelectUserVo> ClassVos = (List<SelectUserVo>) result.get(0);
        PaginationDate paginationDate = PaginationUtils.getPaginationDate(number, page, sum);
        //记录总数为0
        if (sum == 0) {
            SelectUserVo selectClassVo = new SelectUserVo();
            ClassVos.add(selectClassVo);
            return Result.success(new QueryReturnDate(paginationDate, ClassVos));
        }
        //当前页大于总页数
        if (PaginationUtils.isValid(paginationDate)) {
            return Result.error("当前页大于总页数");
        }
        return Result.success(new QueryReturnDate(paginationDate, ClassVos));
    }


    @Override
    public Result userAdd(UserSelectBo userSelectBo) {
        User user = new User();
        user.setId(userSelectBo.getId());
        user.setAccount(userSelectBo.getAccount());
        user.setName(userSelectBo.getName());
        user.setPassword(userSelectBo.getPassword());
        user.setEmail(userSelectBo.getEmail());
        user.setMobile(userSelectBo.getMobile());
        user.setDepId(userSelectBo.getDepId());
        user.setSex(userSelectBo.getSex());
        user.setStatus(userSelectBo.getStatus());
        int row =userMapper.insert(user);
        //判断插入结果
        if (row == 0) {
            return Result.error("添加用户失败");
        }
        return Result.success();
    }

    @Override
    public Result userUpdate(UserSelectBo userSelectBo) {
        User user = new User();
        user.setId(userSelectBo.getId());
        user.setAccount(userSelectBo.getAccount());
        user.setName(userSelectBo.getName());
        user.setPassword(userSelectBo.getPassword());
        user.setEmail(userSelectBo.getEmail());
        user.setMobile(userSelectBo.getMobile());
        user.setDepId(userSelectBo.getDepId());
        user.setSex(userSelectBo.getSex());
        user.setStatus(userSelectBo.getStatus());
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(User::getId, userSelectBo.getId());
        int row =userMapper.update(user, updateWrapper);
        //判断插入结果
        if (row == 0) {
            return Result.error("修改用户失败");
        }
        return Result.success();
    }

    @Override
    public Result userDelete(@NonNull List<String> ids) {
        int row =userMapper.userDelete(ids);
        //判断插入结果
        if (row == 0) {
            return Result.error("删除用户失败");
        }
        return Result.success();
    }

    @Override
    public User findByUserName(String username) {
        return this.userMapper.selectByUserName(username);
    }

    //获取用户信息
    @Override
    public Result getUserDate(String id) {
        //查询指定id的用户
        QueryWrapper<User> sectionQueryWrapper = new QueryWrapper<>();
        sectionQueryWrapper.lambda().eq(User::getId, id);
        User user = userMapper.selectOne(sectionQueryWrapper);
        //判断查询结果
        if (user == null) {
            return Result.error("用户不存在!");
        }
        return Result.success(user);
    }

    //登出
    @Override
    public Result loginout(String id) {
        //修改指定id的用户的Token为空值
        User user = new User();
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(User::getId, id).set(User::getLoginToken, null);
        int row = userMapper.update(user, updateWrapper);
        //判断修改结果
        if (row == 0) {
            return Result.error("登出失败!");
        }
        return Result.success();
    }
}
