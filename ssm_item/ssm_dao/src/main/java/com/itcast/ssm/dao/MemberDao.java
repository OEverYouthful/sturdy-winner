package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: Administrator
 * @Date: 2018/11/14 0014 09:59
 * @Description:
 */
public interface MemberDao {

 @Select("select 8 from member where id= #{id}")
 Member findById(String id);
}
