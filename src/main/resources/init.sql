CREATE TABLE OAUTH_CLIENT_DETAILS (
CLIENT_ID VARCHAR(255) NOT NULL PRIMARY KEY,
CLIENT_SECRET VARCHAR(255) NOT NULL,
RESOURCE_IDS VARCHAR(255) DEFAULT NULL,
SCOPE VARCHAR(255) DEFAULT NULL,
AUTHORIZED_GRANT_TYPES VARCHAR(255) DEFAULT NULL,
WEB_SERVER_REDIRECT_URI VARCHAR(255) DEFAULT NULL,
AUTHORITIES VARCHAR(255) DEFAULT NULL,
ACCESS_TOKEN_VALIDITY DECIMAL(11) DEFAULT NULL,
REFRESH_TOKEN_VALIDITY DECIMAL(11) DEFAULT NULL,
ADDITIONAL_INFORMATION VARCHAR(4096) DEFAULT NULL,
AUTOAPPROVE VARCHAR(255) DEFAULT NULL);
 
INSERT INTO OAUTH_CLIENT_DETAILS (
	CLIENT_ID,
	CLIENT_SECRET,
	RESOURCE_IDS,
	SCOPE,
	AUTHORIZED_GRANT_TYPES,
	WEB_SERVER_REDIRECT_URI,
	AUTHORITIES,
	ACCESS_TOKEN_VALIDITY,
	REFRESH_TOKEN_VALIDITY,
	ADDITIONAL_INFORMATION,
	AUTOAPPROVE
) VALUES (
	'dms_frontend_client_id',
	'{bcrypt}$2a$10$QhyCOcQpkhHaMtgTtJc6XO3f866Mfd6homOq30qNsDiyGHH.F7jue',
	'USER_CLIENT_RESOURCE,USER_ADMIN_RESOURCE',
	'role_admin,role_user',
	'authorization_code,password,refresh_token,implicit',
	NULL,
	NULL,
	900,
	3600,
	'{}',
	NULL
);

INSERT INTO T_USER (
	USERNAME,PASSWORD,
	EMAIL,ENABLED,ACCOUNT_EXPIRED,CREDENTIALS_EXPIRED,ACCOUNT_LOCKED
) 
VALUES 
(
	'admin','{bcrypt}$2a$10$0AoLlR7Af1E1T5dV/0JpVeUtclqZBqtXqDsTWeIOizAySJAhCJwN.',
	'admin@examplemail.com','Y','N','N','N'
),
(
	'user','{bcrypt}$2a$10$0AoLlR7Af1E1T5dV/0JpVeUtclqZBqtXqDsTWeIOizAySJAhCJwN.',
	'user@examplemail.com','Y','N','N','N'
);

INSERT INTO T_ROLE
(NAME)
VALUES
('ADMIN'),
('USER');

INSERT INTO T_USER_ROLE (USER_FK, ROLE_FK) (SELECT DISTINCT USER_ID, ROLE_ID FROM T_USER, T_ROLE WHERE USERNAME = 'admin' AND NAME = 'ADMIN');
INSERT INTO T_USER_ROLE (USER_FK, ROLE_FK) (SELECT DISTINCT USER_ID, ROLE_ID FROM T_USER, T_ROLE WHERE USERNAME = 'user' AND NAME = 'USER');

INSERT INTO T_PERMISSION 
(NAME)
VALUES 
('USER_CREATE'),
('USER_UPDATE'),
('USER_READ'),
('USER_DELETE');

INSERT INTO T_ROLE_PERMISSION (ROLE_FK, PERMISSION_FK) 
(SELECT DISTINCT ROLE_ID, PERMISSION_ID FROM T_ROLE, T_PERMISSION WHERE T_ROLE.NAME = 'ADMIN' AND T_PERMISSION.NAME = 'USER_CREATE');
INSERT INTO T_ROLE_PERMISSION (ROLE_FK, PERMISSION_FK) 
(SELECT DISTINCT ROLE_ID, PERMISSION_ID FROM T_ROLE, T_PERMISSION WHERE T_ROLE.NAME = 'ADMIN' AND T_PERMISSION.NAME = 'USER_UPDATE');
INSERT INTO T_ROLE_PERMISSION (ROLE_FK, PERMISSION_FK) 
(SELECT DISTINCT ROLE_ID, PERMISSION_ID FROM T_ROLE, T_PERMISSION WHERE T_ROLE.NAME = 'ADMIN' AND T_PERMISSION.NAME = 'USER_READ');
INSERT INTO T_ROLE_PERMISSION (ROLE_FK, PERMISSION_FK) 
(SELECT DISTINCT ROLE_ID, PERMISSION_ID FROM T_ROLE, T_PERMISSION WHERE T_ROLE.NAME = 'ADMIN' AND T_PERMISSION.NAME = 'USER_DELETE');
INSERT INTO T_ROLE_PERMISSION (ROLE_FK, PERMISSION_FK) 
(SELECT DISTINCT ROLE_ID, PERMISSION_ID FROM T_ROLE, T_PERMISSION WHERE T_ROLE.NAME = 'USER' AND T_PERMISSION.NAME = 'USER_READ');