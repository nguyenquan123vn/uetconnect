USE uetcourse;
Create Table account(
    username varchar(50) not null,
    name varchar(50) not null,
    email varchar(55) not null,
    password varchar(16) not null,
    profession varchar(55) not null,
    primary key(username)
);
INSERT INTO account(username,name,email, password,profession) VALUES('17020229','Nguyen Viet An','17020229@vnu.edu.vn','An123','student');
INSERT INTO account(username,name,email, password,profession) VALUES('17020340','Nguyen Thanh Loc','17020340@vnu.edu.vn','l123','student');
INSERT INTO account(username,name,email, password,profession) VALUES('17020567','Bui Quoc Thang','17020567@vnu.edu.vn','18938','student');
INSERT INTO account(username,name,email, password,profession) VALUES('17021032','Nguyen Hoai Thu','17021032@vnu.edu.vn','12345','student');
INSERT INTO account(username,name,email, password,profession) VALUES('dolp','Le Phe Do','dolp@vnu.edu.vn','12345','teacher');
INSERT INTO account(username,name,email, password,profession) VALUES('tbt','Tran Binh Trong','tbt@vnu.edu.vn','12345','teacher');

create Table studentsInfo(
	studentId varchar(50) not null,
    studentName varchar(50) not null,
    sex varchar(50) not null,
    birthDate date,
    primary key(studentId)
);
insert into studentsInfo (studentId,studentName,sex,birthDate) values('17020229', 'Nguyen Viet An','Nam','1999-3-12');
insert into studentsInfo (studentId,studentName,sex,birthDate) VALUES('17020340','Nguyen Thanh Loc','Nam','1999-1-20');
insert into studentsInfo (studentId,studentName,sex,birthDate) VALUES('17020567','Bui Quoc Thang','Nam','1999-5-2');
insert into studentsInfo (studentId,studentName,sex,birthDate) VALUES('17021032','Nguyen Hoai Thu','Nu','1999-1-3');

create Table Subjects(
	subjectId varchar(50) not null,
    subjectName varchar(50) not null,
    creditsNum int(10) not null,
    primary key(subjectId)
);
insert into Subjects (subjectId, subjectName, creditsNum) values('INT2209','Mang May Tinh', 3);
insert into Subjects (subjectId, subjectName, creditsNum) values('INT1002','Giai Tich 1', 4);
insert into Subjects (subjectId, subjectName, creditsNum) values('INT1003','Giai tich 2', 3);
insert into Subjects (subjectId, subjectName, creditsNum) values('INT2002','Phuong phap tinh', 2);
insert into Subjects (subjectId, subjectName, creditsNum) values('INT3002','Toan Roi Rac', 4);
insert into Subjects (subjectId, subjectName, creditsNum) values('INT4002','Nhap Mon An Toan Thong Tin', 2);

create Table Lecturers(
	lecturerId varchar(50) not null,
    lecturerName varchar(50) not null,
    degree varchar(50) not null,
    phoneNumber varchar(30) not null,
    primary key(lecturerId)
);
insert into Lecturers (lecturerId, lecturerName, degree, phoneNumber) values('dolp', 'Le Phe Do', 'PGS.TS', '0123456789');
insert into Lecturers (lecturerId, lecturerName, degree, phoneNumber) values('tbt', 'Tran Binh Trong', 'TS', '012344359');

create Table classes(
	classId varchar(50) not null,
    lecturerId varchar(50) not null,
    semester varchar(9) not null,
    primary key (classId)
);
insert into classes (classId, lecturerId, semester) values( 'INT1002-23', 'dolp', '2018-2019');
insert into classes (classId, lecturerId, semester) values( 'INT1003-3', 'dolp', '2018-2019');
insert into classes (classId, lecturerId, semester) values( 'INT1003-23', 'dolp', '2018-2019');
insert into classes (classId, lecturerId, semester) values( 'INT2002-2', 'dolp', '2018-2019');
insert into classes (classId, lecturerId, semester) values( 'INT1002-5', 'dolp', '2018-2019');


create table grade(
	studentsId varchar(50) not null,
    classId varchar(50) not null,
    grade int default null,
	primary key(studentsId, classId)
);
insert into students_subjects (studentsId, classId, grade) values('17020229', 'INT1003-23', null);
insert into students_subjects (studentsId, classId, grade) values('17020229', 'INT1002-23', null);



