package cn.geekhall.sbdemo.service.impl;

import cn.geekhall.sbdemo.bean.User;
import cn.geekhall.sbdemo.mapper.UserMapper;
import cn.geekhall.sbdemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @author yiny
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
