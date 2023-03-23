
INSERT INTO [dbo].[Role] (name)
VALUES ('Student'),('Faculty'),('Staff');


INSERT INTO [dbo].[Member] (first_name, last_name, member_number, password, user_name, role_id)
values
    ('Kushal','Shrestha', 'DFKLSDJFS', 'test123','kushal.shrestha', 1),
    ('Jane', 'Andersen', 'FSJDKDSL','bruce.lester', 'jane.andersen', 2),
    ('Peter', 'Adley', 'FJDSLKJWE','peter.adley', 'peter.adley', 3);


insert into [dbo].[Badge] (expiry_date, status, member_id, badge_number)
values
    ('2023-07-15 23:59:59', 'INACTIVE', 1, 'CMDAELJGJEHONLDJL87C'),
    ('2023-07-15 23:59:59', 'ACTIVE', 1, 'CMDAELDJKSGJEHONLDJL87C'),
    ('2023-12-31 23:59:59', 'ACTIVE', 2, 'V2DAO2KB95MTJ34IHSVQ'),
    ('2023-12-31 23:59:59', 'ACTIVE', 3, 'PF4SL5UYZ0OZYL11PH1A');


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



insert into [dbo].[LocationTimeSlot](day_of_week,end_time,start_time,location_id)
values
    (1, '13:00', '11:30',1),
    (1, '19:30', '18:00',1),
    (2, '10:00', '8:30',1),
    (2, '13:30', '12:00',1),
    (2, '19:30', '18:00',1),
    (3, '10:00', '8:30',1),
    (3, '13:30', '12:00',1),
    (3, '19:30', '18:00',1),
    (4, '10:00', '8:30',1),
    (4, '13:30', '12:00',1),
    (4, '19:30', '18:00',1),
    (5, '10:00', '8:30',1),
    (5, '13:30', '12:00',1),
    (5, '19:30', '18:00',1),
    (6, '10:00', '8:30',1),
    (6, '13:30', '12:00',1),
    (6, '19:30', '18:00',1),
    (7, '10:00', '8:30',1),
    (7, '13:30', '12:00',1),
    (7, '19:30', '18:00',1),
    (2, '21:00', '10:00',2),
    (3, '21:00', '10:00',2),
    (4, '21:00', '10:00',2),
    (5, '21:00', '10:00',2),
    (6, '21:00', '10:00',2),
    (7, '21:00', '10:00',2),
    (2, '19:00', '9:00',3),
    (3, '19:00', '9:00',3),
    (4, '19:00', '9:00',3),
    (5, '19:00', '9:00',3),
    (6, '19:00', '9:00',3),
    (7, '19:00', '9:00',3),
    (2, '19:00', '9:00',4),
    (3, '19:00', '9:00',4),
    (4, '19:00', '9:00',4),
    (5, '19:00', '9:00',4),
    (6, '19:00', '9:00',4),
    (7, '19:00', '9:00',4),
    (2, '19:00', '9:00',5),
    (3, '19:00', '9:00',5),
    (4, '19:00', '9:00',5),
    (5, '19:00', '9:00',5),
    (6, '19:00', '9:00',5),
    (7, '19:00', '9:00',5),
    (1, '16:00', '9:00',6),
    (2, '21:00', '9:00',6),
    (3, '21:00', '9:00',6),
    (4, '21:00', '9:00',6),
    (5, '21:00', '9:00',6),
    (6, '21:00', '9:00',6),
    (7, '21:00', '9:00',6),
    (1, '23:59:59', '00:00',7),
    (2, '23:59:59', '00:00',7),
    (3, '23:59:59', '00:00',7),
    (4, '23:59:59', '00:00',7),
    (5, '23:59:59', '00:00',7),
    (6, '23:59:59', '00:00',7),
    (7, '23:59:59', '00:00',7),
    (1, '23:59:59', '00:00',8),
    (2, '23:59:59', '00:00',8),
    (3, '23:59:59', '00:00',8),
    (4, '23:59:59', '00:00',8),
    (5, '23:59:59', '00:00',8),
    (6, '23:59:59', '00:00',8),
    (7, '23:59:59', '00:00',8);



INSERT INTO [dbo].[CheckinInformation] (transaction_type, dateTime, location_id, plan_id, badge_id)
values
    ('ACCEPTED','2022-11-29 00:00:00.0000000',1 , 1, 2),
    ('ACCEPTED','2022-12-01 08:00:00.0000000',1 , 1, 2),
    ('ACCEPTED','2022-12-02 08:00:00.0000000',1 , 1, 2),
    ('ACCEPTED','2022-12-03 08:00:00.0000000',1 , 1, 2),
    ('ACCEPTED','2022-12-04 08:00:00.0000000',1 , 1, 2),
    ('ACCEPTED','2022-12-05 08:00:00.0000000',1 , 1, 2),
    ('ACCEPTED','2022-12-06 08:00:00.0000000',1 , 1, 2);



insert into [dbo].checkInRecord (count, plans_id, roles_id, member_id)
values
    (12, 1, 1, 1),
    (29, 1, 2, 2),
    (32, 1, 3, 3);
