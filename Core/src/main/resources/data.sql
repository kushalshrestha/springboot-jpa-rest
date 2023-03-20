
INSERT INTO [dbo].[Role] (name)
VALUES ('Student'),('Faculty'),('Staff');


INSERT INTO [dbo].[Member] (first_name, last_name, password, user_name)
values
    ('Kushal','Shrestha', 'test123','kushal.shrestha'),
    ('Jane', 'Andersen', 'bruce.lester', 'jane.andersen'),
    ('Peter', 'Adley', 'peter.adley', 'peter.adley');


insert into [dbo].[planInfo] (description, name)
values
    ('Meal plan', 'Meals'),
    ('Gymnasium', 'Gym'),
    ('Library', 'Library'),
    ('Dorm for Home', 'Dorm');


insert into [dbo].[membership] (end_date, start_date, type, plan_id, member_id)
values
    ('2023-07-15 23:59:59','2022-10-29 00:00:00', 'LIMITED', 1, 1),
    ('2023-12-31 23:59:59','2023-01-15 04:30:00', 'UNLIMITED', 2, 1),
    ('2025-07-15 23:59:59','2023-10-29 00:00:00', 'UNLIMITED', 3, 1),
    ('2023-07-15 23:59:59','2022-10-29 00:00:00', 'UNLIMITED', 4, 1),
    ('2023-12-31 23:59:59','2023-01-01 00:00:00', 'LIMITED', 1, 2),
    ('2023-12-31 23:59:59','2023-01-01 00:00:00', 'UNLIMITED', 2, 2),
    ('2023-12-31 23:59:59','2023-01-31 00:00:00', 'LIMITED', 1, 3),
    ('2023-12-31 23:59:59','2023-01-15 00:00:00', 'UNLIMITED', 2, 3),
    ('2025-07-15 23:59:59','2023-10-29 00:00:00', 'UNLIMITED', 3, 3);

insert into [dbo].[Badge] (expiry_date, status, member_id, badge_number)
values
    ('2023-07-15 23:59:59', 'INACTIVE', 1, 'CMDAELJGJEHONLDJL87C'),
    ('2023-07-15 23:59:59', 'ACTIVE', 1, 'CMDAELJGJEHONLDJL87C'),
    ('2023-12-31 23:59:59', 'ACTIVE', 2, 'V2DAO2KB95MTJ34IHSVQ'),
    ('2023-12-31 23:59:59', 'ACTIVE', 3, 'PF4SL5UYZ0OZYL11PH1A');


insert into [dbo].[RolePlanLimit](limit_by, limit_value, role_id, plan_id)
values
    ('weeks',20, 1, 1),
    ('weeks', 50, 2, 1),
    ('weeks', 30, 3, 1);


insert into [dbo].[Location](capacity, description, name, type, plan_id)
values
    (100, 'Meal Plan for Argiro', 'Argiro','DINING_HALL', 1),
    (25, 'Meal Plan for Golden Dome Market Place', 'Golden Dome' , 'DINING_HALL' , 1),
    (30, 'Fit for Life', 'Rec Centre', 'GYMNASIUM', 2),
    (15, 'Get Ready for US Open', 'Rec Centre', 'LAWN_TENNIS', 2),
    (20, 'Get Ready for outdoor tennis', 'Brooklyn Avenue', 'LAWN_TENNIS', 2),
    (200, 'Look a Book', 'XYZ Avenue', 'LIBRARY', 3),
    (80, 'H3', 'ABC Avenue', 'DORMITORY', 4),
    (50, 'R16', '123 Avenue', 'DORMITORY', 4);

