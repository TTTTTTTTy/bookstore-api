package com.tangyechun.service.Impl;

import com.tangyechun.common.StateCode;
import com.tangyechun.mapper.UserMapper;
import com.tangyechun.model.User;
import com.tangyechun.model.UserExample;
import com.tangyechun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author Administrator
 * @since 2019/6/15 22:23
 */

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserMapper userMapper;

    /**
     * 创建用户
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        if(users != null && !users.isEmpty()){
            return StateCode.USERNAME_EXISTS.value();
        }
        userExample.createCriteria().andEmailEqualTo(user.getEmail());
        users = userMapper.selectByExample(userExample);
        if(users != null && !users.isEmpty()){
            return StateCode.EMAIL_EXISTS.value();
        }
        userMapper.insert(user);
        return StateCode.SUCCESS.value();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserExample userExample = new UserExample();
        if (s != null && !s.isEmpty()) {
            userExample.createCriteria().andUsernameEqualTo(s);
        }
        List<User> users = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(users)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return users.get(0);
    }
}
