package com.example.demo.Domain.UserDomain;

import com.example.demo.core.ExistsByField;

public interface UserRepositoryWrite extends ExistsByField{

    public void add(User user);

}
