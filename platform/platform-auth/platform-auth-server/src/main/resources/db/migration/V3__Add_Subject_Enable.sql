-- 判断字段是否存在，不存在则增加
DROP PROCEDURE IF EXISTS add_subject_enable_column;
DELIMITER //
CREATE PROCEDURE add_subject_enable_column()
BEGIN
    DECLARE target_database VARCHAR(100);
    DECLARE target_table_name VARCHAR(100);
    DECLARE target_column_name VARCHAR(100);
    DECLARE target_index_name VARCHAR(100);
    set target_table_name = 'subject';
    set target_column_name = 'enable';
    SELECT DATABASE() INTO target_database;
    IF NOT EXISTS(SELECT *
                  FROM information_schema.columns
                  WHERE table_schema = target_database
                    AND table_name = target_table_name
                    AND column_name = target_column_name) THEN
        set @statement =
                CONCAT("ALTER TABLE ", target_table_name, " ADD COLUMN ", target_column_name, " TINYINT(1) NULL");
        PREPARE STMT FROM @statement;
        EXECUTE STMT;
    END IF;
END
//
DELIMITER ; -- 注意 DELIMITER 与分号之间有空格
CALL add_subject_enable_column();
