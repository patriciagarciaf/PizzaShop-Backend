package com.example.demo.Domain.UserDomain;

import java.util.UUID;

import com.example.demo.core.ExistsByField;
import com.example.demo.core.FindById;

public interface UserRepositoryWrite  extends FindById<User, UUID>, ExistsByField  {

    public void add(User user);

    public void update(User user);

}
