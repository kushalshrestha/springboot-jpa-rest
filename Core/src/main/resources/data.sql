
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

