package mingshu.librarian.service;

import com.axelor.auth.db.*;
import com.axelor.auth.db.repo.*;
import com.google.inject.persist.Transactional;
import mingshu.librarian.db.*;
import mingshu.librarian.db.repo.ReaderRepository;

import javax.inject.Inject;

public class ReaderServiceImpl implements ReaderService {

    @Inject
    private UserRepository _users;

    @Inject
    private ReaderRepository _readers;

    @Transactional
    public User assignNewUser(Reader reader) {
        User newUser = new User();
        newUser.setCode(reader.getMobile()); // 设置读者用户登录用户名为其手机号
        newUser.setName("读者 " + reader.getName()); // 设置用户信息的名称为读者的姓名
        newUser.setForcePasswordChange(true); // 要求读者用户登录时修改密码
        newUser.setPassword("123456"); // 读者用户密码默认为 `123456`
        newUser.setReader(reader);
        newUser = _users.save(newUser);
        reader.setUser(newUser);
        _readers.save(reader);
        return newUser;
    }


}
