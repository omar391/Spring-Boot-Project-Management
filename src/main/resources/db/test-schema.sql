DROP TABLE IF EXISTS `test_data`;
CREATE TABLE `test_data`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `test_int`    int(11) NULL DEFAULT NULL,
    `test_str`    varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `create_time` datetime(0) NULL DEFAULT NULL,
    `update_time` datetime(0) NULL DEFAULT NULL,
    `version`     int(11) NULL DEFAULT 0,
    `test_enum`   int(11) NULL DEFAULT NULL,
    `tenant_id`   bigint(20) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8;

SET
FOREIGN_KEY_CHECKS = 1;

