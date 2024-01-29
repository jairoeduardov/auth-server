INSERT INTO auth_db.`role` (`role`) VALUES ('ROLE_ADMIN');
INSERT INTO auth_db.`role` (`role`) VALUES ('ROLE_QUERY');
INSERT INTO auth_db.`role` (`role`) VALUES ('ROLE_WRITER');
INSERT INTO auth_db.`role` (`role`) VALUES ('ROLE_MANAGER');
INSERT INTO auth_db.`role` (`role`) VALUES ('ROLE_USER');


INSERT INTO auth_db.account (credentials_expired,disabled,expired,locked,password,username, uuid) VALUES (0,0,0,0,'$2a$10$7nC7ZkGcNIJjElYEd1D2S.QGwqnrK0mgBYlaRHPnYw.q1BvI.GtXW','admin', 'fd932aa4-bf7e-4569-b9c4-a669e444cda0');
INSERT INTO auth_db.account (credentials_expired,disabled,expired,locked,password,username,uuid) VALUES (0,0,0,0,'$2a$10$YmY87Qd5zWdnoTnWq8mydOACg.jydsbeO15w/slqTadgOiDWaf5CK','digitador','e94f0ca8-ced8-4a51-a746-b33cd545d8a4');

INSERT INTO auth_db.account_roles (account_id, role_id) VALUES(1, 1);
INSERT INTO auth_db.account_roles (account_id, role_id) VALUES(1, 5);
INSERT INTO auth_db.account_roles (account_id, role_id) VALUES(2, 3);
INSERT INTO auth_db.account_roles (account_id, role_id) VALUES(2, 5);
