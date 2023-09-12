package com.base.repository.custom.sandbox;

import com.base.entity.User;
import com.base.mapper.BaseRowAutoMapper;
import com.base.repository.query.GetListUser;
import com.base.repository.sqltemplate.SqlTemplater;
import com.base.request.UserRequest;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {
    @Autowired
    private SqlTemplater sqlTemplater;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<User> getListUsers(UserRequest userRequest){
        StringBuilder queryBuilder = new StringBuilder(sqlTemplater.getQuery(GetListUser.class));

        if (userRequest.getOrder() != null && userRequest.getOrder().size() > 0) {
            StringBuilder orderBy = new StringBuilder(" ORDER BY ");
            for(int i = 0; i < userRequest.getOrder().size(); i++){
                if(i != 0){
                    orderBy.append(", ");
                }
                Map<String, String> map = userRequest.getOrder().get(i);
                orderBy.append(map.get("column"));
                orderBy.append(" ");
                orderBy.append(map.get("direction"));
            }
            queryBuilder.append(orderBy);
        }

        if (userRequest.getPage() != null && userRequest.getSize() != null) {
            String limit = String.format(" LIMIT %s, %s",
                    (userRequest.getPage() - 1) * userRequest.getSize(), userRequest.getSize());
            queryBuilder.append(limit);
        }

        SqlParameterSource param = setParameter(userRequest);
        return jdbcTemplate.query(queryBuilder.toString(), param, new BaseRowAutoMapper<>(User.class));
    }

    private SqlParameterSource setParameter(UserRequest userRequest) {
        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("name", Strings.isNullOrEmpty(userRequest.getName()) ? null
                        : '%' + userRequest.getName() + '%');
        return param;
    }
}
