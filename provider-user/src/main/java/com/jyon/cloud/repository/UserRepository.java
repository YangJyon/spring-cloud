package com.jyon.cloud.repository;


import com.jyon.cloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
