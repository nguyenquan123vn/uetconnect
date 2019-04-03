
create database uetcourse;
USE uetcourse;

Create Table account(
    username varchar(50) not null,
    name varchar(50) not null,
    email varchar(55) not null,
    password varchar(50) not null,
    profession varchar(55) not null,
    primary key(username)
);
INSERT INTO account(username,name,email, password,profession) VALUES('17020229','Nguyen Viet An','17020229@vnu.edu.vn','An123','student');
INSERT INTO account(username,name,email, password,profession) VALUES('17020340','Nguyen Thanh Loc','17020340@vnu.edu.vn','l123','student');
INSERT INTO account(username,name,email, password,profession) VALUES('17020567','Bui Quoc Thang','17020567@vnu.edu.vn','18938','student');
INSERT INTO account(username,name,email, password,profession) VALUES('17021032','Nguyen Hoai Thu','17021032@vnu.edu.vn','12345','student');
INSERT INTO account(username,name,email, password,profession) VALUES('dolp','Le Phe Do','dolp@vnu.edu.vn','12345','teacher');
INSERT INTO account(username,name,email, password,profession) VALUES('tbt','Tran Binh Trong','tbt@vnu.edu.vn','12345','teacher');
create table students_subjects(
	studentsId varchar(50) not null,
    subjectId varchar(50) not null,
    subjectName varchar(50) not null,
    creditsNum int(10) not null,
    lecturerName varchar(50) not null
);
insert into students_subjects (studentsId, subjectId,subjectName, creditsNum,lecturerName) values('17020229', 'INT2209','Mang May Tinh',3,'Tran Binh Trong');
insert into students_subjects (studentsId, subjectId,subjectName, creditsNum,lecturerName) values('17020229', 'INT1002','Giai tich 1',3,'Le Phe Do');
insert into students_subjects (studentsId, subjectId,subjectName,creditsNum,lecturerName) values('17020229', 'INT1003','Giai tich 2',3,'Le Phe Do');
insert into students_subjects (studentsId, subjectId,subjectName,creditsNum,lecturerName) values('17020229', 'INT2002','Phuong phap tinh',2,'Le Phe Do');
insert into students_subjects (studentsId, subjectId,subjectName,creditsNum,lecturerName) values('17020229', 'INT3002','Toan Roi Rac',4,'Le Phe Do');
insert into students_subjects (studentsId, subjectId,subjectName,creditsNum,lecturerName) values('17020229', 'INT4002','Nhap Mon An Toan Thong Tin',3,'Le Phe Do');
create Table lecturers_subject(
	lecturerId varchar(20) not null,
    lecturerName varchar(50) not null,
    subjectId varchar(50) not null,
    subjectName varchar(50) not null
);
insert into lecturers_subject (lecturerId, lecturerName, subjectId, subjectName) values('dolp', 'Le Phe Do', 'INT1002', 'Giai tich 1');
insert into lecturers_subject (lecturerId, lecturerName, subjectId, subjectName) values('dolp', 'Le Phe Do', 'INT1003', 'Giai tich 2');
insert into lecturers_subject (lecturerId, lecturerName, subjectId, subjectName) values('dolp', 'Le Phe Do', 'INT2002', 'Phuong phap tinh');
insert into lecturers_subject (lecturerId, lecturerName, subjectId, subjectName) values('dolp', 'Le Phe Do', 'INT3002', 'Toan Roi Rac');
insert into lecturers_subject (lecturerId, lecturerName, subjectId, subjectName) values('dolp', 'Le Phe Do', 'INT1002', 'Nhap Mon An Toan Thong Tinlecturers_subject');