
``` sql
select P1.* from Person as P1, Person as P2 where P1.Email != P2.Email and P1.Id < P2.Id;
```

# 然而是让删除重复的

``` sql
delete P1 from Person as P1, Person as P2 where P1.Email != P2.Email and P1.Id < P2.Id;
```
