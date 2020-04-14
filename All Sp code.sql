use bootproj01
go

create proc getEmployees
as 
begin
	select * from employee;
end
go

exec getEmployees
go



create proc getEmployeeById
@id as varchar(20)
as
begin
	select * from employee where id = @id
end
go

exec getEmployeeById '001';
go


create proc addEmployee
@name varchar(30),
@dept varchar(30)
as
begin
	insert into employee(name, dept) values(@name, @dept);
end
go

exec addEmployee 'masud islam', 'frontend'
go

create proc updateEmployee
@id as int,
@name as varchar(30),
@dept as varchar(30)
as
begin
	update employee set name = @name, dept = @dept where id = @id
end
go

exec updateEmployee 4, 'Masud Ahmed', 'backend'
go

create proc deleteEmployee
@id as int
as 
begin
	delete from employee where id = @id
end
go

exec deleteEmployee 10