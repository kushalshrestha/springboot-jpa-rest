
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
