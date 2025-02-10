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
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'password';
# skip-name-resolve
FLUSH PRIVILEGES;
```

## 设置storage存储
1. mariadb 先以默认配置启动，再复制my.cnf文件到-v
2. skip-networking 无法用-P访问，gpt没回答出来
