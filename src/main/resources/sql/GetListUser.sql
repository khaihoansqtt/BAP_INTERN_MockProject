SELECT DISTINCT
    id,
    user_name AS userName,
    email,
    first_name AS firstName,
    last_name AS lastName,
    password,
    phone,
    num_login_attempts AS numLoginAttempts,
    created_by_user AS createByUser,
    created_at AS createAtTime,
    modified_by_user AS updateByUser,
    modified_at AS updateAtTime,
    is_deleted AS isDeleted
FROM users u
WHERE (:name IS NULL OR u.user_name LIKE :name)
AND u.is_deleted = false