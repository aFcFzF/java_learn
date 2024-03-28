# java_learn

java学习
- 算法

## 初始化mariadb
设置密码
``` bash
mysql -u root;
use mysql;
ALTER USER 'root'@'localhost' IDENTIFIED BY 'password' PASSWORD EXPIRE NEVER;
# 允许外网登录
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
# skip-name-resolve
FLUSH PRIVILEGES;
```
