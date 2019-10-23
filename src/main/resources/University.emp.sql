-- ����M
CREATE TABLE `problemm` (
	`no`        VARCHAR(50) NOT NULL COMMENT '�Ϸù�ȣ', -- �Ϸù�ȣ
	`grade`     VARCHAR(50) NULL     COMMENT '�г�', -- �г�
	`subject`   VARCHAR(50) NULL     COMMENT '�����', -- �����
	`professor` VARCHAR(50) NULL     COMMENT '�����ڸ�', -- �����ڸ�
	`year`      VARCHAR(50) NULL     COMMENT '�⵵', -- �⵵
	`semester`  VARCHAR(50) NULL     COMMENT '�б�', -- �б�
	`count`     VARCHAR(50) NULL     COMMENT '���׼�' -- ���׼�
)
COMMENT '����M';

-- ����M
ALTER TABLE `problemm`
	ADD CONSTRAINT `PK_problemm` -- ����M �⺻Ű
		PRIMARY KEY (
			`no` -- �Ϸù�ȣ
		);

-- ����D
CREATE TABLE `problemd` (
	`no`         VARCHAR(50) NOT NULL COMMENT '�Ϸù�ȣ', -- �Ϸù�ȣ
	`number`     VARCHAR(50) NULL     COMMENT '������ȣ', -- ������ȣ
	`contents`   VARCHAR(50) NULL     COMMENT '��������', -- ��������
	`exno`       VARCHAR(50) NULL     COMMENT '�����ȣ', -- �����ȣ
	`excontents` VARCHAR(50) NULL     COMMENT '���⳻��' -- ���⳻��
)
COMMENT '����D';

-- ����D
ALTER TABLE `problemd`
	ADD CONSTRAINT `PK_problemd` -- ����D �⺻Ű
		PRIMARY KEY (
			`no` -- �Ϸù�ȣ
		);

-- ����D
ALTER TABLE `problemd`
	ADD CONSTRAINT `FK_problemm_TO_problemd` -- ����M -> ����D
		FOREIGN KEY (
			`no` -- �Ϸù�ȣ
		)
		REFERENCES `problemm` ( -- ����M
			`no` -- �Ϸù�ȣ
		);