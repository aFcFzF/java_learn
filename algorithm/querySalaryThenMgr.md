m1:

``` sql
    select Name as Emplayee from User as U1, User as U2 where U1.ManagerId = U2.Id and U1.Salary > U2.Salary;
```

m2:
``` sql
    select Name as Employee from User as U1 join on User as U2 where U1.ManagerId = U2.Id and U1.Salary > U2.Salary;
```