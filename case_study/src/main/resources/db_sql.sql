insert into m4_furama.department (id, department_name) values (1, 'Sale-Marketing');
insert into m4_furama.department (id, department_name) values (2, 'Hành chính');
insert into m4_furama.department (id, department_name) values (3, 'Phục vụ');
insert into m4_furama.department (id, department_name) values (4, 'Quản lý');


insert into m4_furama.education_degree (id, education_degree_name) values (1, 'Trung Cấp');
insert into m4_furama.education_degree (id, education_degree_name) values (2, 'Cao Đẳng');
insert into m4_furama.education_degree (id, education_degree_name) values (3, 'Đại Học');
insert into m4_furama.education_degree (id, education_degree_name) values (4, 'Sau Đại Học');


insert into m4_furama.position (id, position_name) values (1, 'Quản Lý');
insert into m4_furama.position (id, position_name) values (2, 'Nhân Viên');

insert into m4_furama.employee (id, address, day_of_birth, email, name, national_id, phone_number, salary, department_id, education_degree_id, position_id, is_activated)
values  ('EM-0001', '295 Nguyễn Tất Thành', '1970-11-07', 'annguyen@gmail.com', 'Nguyễn Văn An', '456231786', '0901234121', 10000000, 1, 3, 1, true),
        ('EM-0010', '22 Yên Bái', '1997-04-09', 'binhlv@gmail.com', 'Lê Văn Bình', '654231234', '0934212314', 7000000, 2, 2, 1, true),
        ('EM-0101', 'K234/11 Điện Biên Phủ', '1995-12-12', 'thiyen@gmail.com', 'Hồ Thị Yến', '999231723', '0412352315', 14000000, 2, 3, 1, true),
        ('EM-0102', '77 Hoàng Diệu', '1980-04-04', 'toan0404@gmail.com', 'Võ Công Toản', '123231365', '0374443232', 17000000, 4, 4, 1, true),
        ('EM-0103', '43 Yên Bái', '1999-12-09', 'phatphat@gmail.com', 'Nguyễn Bỉnh Phát', '454363232', '0902341231', 6000000, 1, 1, 2, true),
        ('EM-0104', '294 Nguyễn Tất Thành', '2000-11-08', 'annghi20@gmail.com', 'Khúc Nguyễn An Nghi', '964542311', '0978653213', 7000000, 3, 2, 2, true),
        ('EM-0105', '4 Nguyễn Chí Thanh', '1993-01-01', 'nhh0101@gmail.com', 'Nguyễn Hữu Hà', '534323231', '0941234553', 8000000, 2, 3, 2, true),
        ('EM-0106', '111 Hùng Vương', '1989-09-03', 'donghanguyen@gmail.com', 'Nguyễn Hà Đông', '234414123', '0642123111', 9000000, 4, 4, 2, true),
        ('EM-0107', '213 Hàm Nghi', '1982-09-03', 'hoangtong@gmail.com', 'Tòng Hoang', '256781231', '0245144444', 6000000, 4, 4, 2, true),
        ('EM-0108', '6 Hoà Khánh', '1994-01-08', 'nguyencongdao12@gmail.com', 'Nguyễn Công Đạo', '755434343', '0988767111', 8000000, 2, 3, 2, true);

insert into m4_furama.customer_type (id, customer_type_name)
values  (1, 'Diamond'),
        (2, 'Platinium'),
        (3, 'Gold'),
        (4, 'Silver'),
        (5, 'Member');

insert into m4_furama.customer (id, address, day_of_birth, gender, mail, name, national_id, phone, customer_type_id, is_activated)
values  ('CS-0001', 'K323/12 Ông Ích Khiêm, Vinh', '1970-11-07', 0, 'thihao07@gmail.com', 'Nguyễn Thị Hào', '643431213', '0945423362', 5, true),
        ('CS-0002', 'K453/12 Lê Lợi, Đà Nẵng', '1992-08-08', 1, 'xuandieu92@gmail.com', 'Phạm Xuân Diệu', '865342123', '0954333333', 3, true),
        ('CS-0003', '224 Lý Thái Tổ, Gia Lai', '1990-02-27', 1, 'nghenhan2702@gmail.com', 'Trương Đình Nghệ', '488645199', '0373213122', 1, true),
        ('CS-0004', '37 Yên Thế, Đà Nẵng', '1981-07-08', 1, 'duongquan@gmail.com', 'Dương Văn Quan', '543432111', '0490039241', 1, true),
        ('CS-0005', 'K123/45 Lê Lợi, Hồ Chí Minh', '1995-12-09', 0, 'nhinhi123@gmail.com', 'Hoàng Trần Nhi Nhi', '795453345', '0312345678', 4, true),
        ('CS-0006', '55 Nguyễn Văn Linh, Kon Tum', '2005-12-06', 0, 'tonnuchau@gmail.com', 'Tôn Nữ Mộc Châu', '732434215', '0988888844', 4, true),
        ('CS-0007', '24 Lý Thường Kiệt, Quảng Ngãi', '1984-04-08', 0, 'kimcuong84@gmail.com', 'Nguyễn Mỹ Kim', '856453123', '0912345698', 1, true),
        ('CS-0008', '22 Ngô Quyền, Đà Nẵng', '1999-04-08', 0, 'haohao99@gmail.com', 'Nguyễn Thị Hào', '965656433', '0763212345', 3, true),
        ('CS-0009', '24 Lý Thường Kiệt, Quảng Ngãi
', '1994-07-01', 1, 'danhhai99@gmail.com', 'Trần Đại Danh', '432341235', '0643343433', 1, true),
        ('CS-0010', '22 Ngô Quyền, Đà Nẵng
', '1989-07-01', 1, 'dactam@gmail.com', 'Nguyễn Tâm Đắc', '344343432', '0987654321', 2, true);


insert into m4_furama.facility_type (id, facility_type_name)
values  (1, 'Villa'),
        (2, 'House'),
        (3, 'Room');

insert into m4_furama.rent_type (id, rent_type_name)
values  (1, 'year'),
        (2, 'month'),
        (3, 'day'),
        (4, 'hour');




insert into m4_furama.facility (id, name, area, cost, max_people, number_of_floors, other_convenience, pool_area, standard_room, facility_type_id, rent_type_id, free_service)
values  ('DV-0004', 'Villa No Beach Front', 22000, 9000000, 8, 3, 'Có hồ bơi', 300, 'normal', 1, 3, null),
        ('DV-0001', 'Villa Beach Front', 25000, 10000000, 10, 4, 'Có hồ bơi', 500, 'vip', 1, 3, null),
        ('DV-0006', 'Room Twin 02', 3000, 900000, 2, null, 'Có tivi', null, 'normal', 3, 4, null),
        ('DV-0002', 'Room Twin 01', 5000, 1000000, 2, null, 'Có tivi', null, 'normal', 3, 4, null),
        ('DV-0005', 'House Princess 02', 10000, 4000000, 5, 2, 'Có thêm bếp nướng', null, 'normal', 2, 3, null),
        ('DV-0003', 'House Princess 01', 14000, 5000000, 7, 3, 'Có thêm bếp nướng', null, 'vip', 2, 2, 'bu cu');

insert into m4_furama.attach_service (id, name, cost, status, unit)
values  (1, 'Karaoke', 10000, 'tiện nghi', 'giờ'),
        (2, 'Thuê xe máy', 10000, 'hỏng 1 xe', 'chiếc'),
        (3, 'Thuê xe đạp', 20000, 'tốt', 'chiếc'),
        (4, 'Buffet buổi sáng', 15000, 'đầy đủ đồ ăn', 'suất'),
        (5, 'Buffet buổi trưa', 90000, 'đầy đủ đồ ăn', 'suất'),
        (6, 'Buffet buổi tối', 16000, 'đầy đủ đồ ăn', 'suất');

insert into m4_furama.contract (id, deposit, end_date, start_date, total_money, customer_id, employee_id, facility_id)
values  ('HD-0001', 0, '2020-12-08', '2020-12-08', null, 'CS-0001', 'EM-0101', 'DV-0003'),
        ('HD-0002', 200000, '2020-07-21', '2020-07-14', null, 'CS-0003', 'EM-0105', 'DV-0001'),
        ('HD-0003', 50000, '2021-03-17', '2021-03-15', null, 'CS-0004', 'EM-0101', 'DV-0002'),
        ('HD-0004', 100000, '2021-01-18', '2021-01-14', null, 'CS-0005', 'EM-0105', 'DV-0005'),
        ('HD-0005', 0, '2021-07-15', '2021-07-14', null, 'CS-0002', 'EM-0105', 'DV-0006'),
        ('HD-0006', 0, '2021-06-03', '2021-06-01', null, 'CS-0007', 'EM-0105', 'DV-0006'),
        ('HD-0007', 100000, '2021-09-05', '2021-09-02', null, 'CS-0004', 'EM-0105', 'DV-0004'),
        ('HD-0008', 150000, '2021-06-18', '2021-06-17', null, 'CS-0004', 'EM-0101', 'DV-0001'),
        ('HD-0009', 0, '2020-11-19', '2020-11-19', null, 'CS-0004', 'EM-0101', 'DV-0003'),
        ('HD-0010', 0, '2021-04-14', '2021-04-12', null, 'CS-0003', 'EM-0108', 'DV-0005'),
        ('HD-0011', 0, '2021-04-25', '2021-04-25', null, 'CS-0002', 'EM-0010', 'DV-0001'),
        ('HD-0012', 0, '2021-05-27', '2021-05-25', null, 'CS-0010', 'EM-0105', 'DV-0001');


insert into m4_furama.contract_detail (id, quantity, attach_service_id, contract_id)
values  ('HDCT-0001', 5, 4, 'HD-0004'),
        ('HDCT-0002', 8, 5, 'HD-0005'),
        ('HDCT-0003', 15, 6, 'HD-0006'),
        ('HDCT-0004', 1, 1, 'HD-0001'),
        ('HDCT-0005', 11, 2, 'HD-0002'),
        ('HDCT-0006', 1, 3, 'HD-0003'),
        ('HDCT-0007', 2, 2, 'HD-0002'),
        ('HDCT-0008', 2, 2, 'HD-0002');