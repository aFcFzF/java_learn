# java_learn

java学习
- 算法

## 初始化mariadb
设置密码
``` bash
mysql -u root;
use mysql;
UPDATE mysql.user SET password = PASSWORD('you pass') WHERE user = 'root';
# 允许外网登录
GRANT ALL PRIVILEGES ON *.* TO root@% WITH GRANT OPTION;
FLUSH PRIVILEGES;
```
