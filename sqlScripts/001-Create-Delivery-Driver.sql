DELIMITER $$
DROP PROCEDURE IF EXISTS my_transaction $$
CREATE PROCEDURE my_transaction ()
BEGIN
	START TRANSACTION;


INSERT INTO DeliveryEmployee (EmployeeID, EmployeeFirstName, EmployeeSurname, Salary, BankAccountNumber, NationalInsurance)
VALUES (Jonny', 'Evans', '100000', '01234', 'AB12345', 'NI12345');



	-- check the number of affected rows
	GET DIAGNOSTICS @rows = ROW_COUNT;
	IF @rows = 0 THEN
		-- if an error occurred rollback the transaction
		ROLLBACK;
		SELECT 'Transaction rolled back due to error.';
	ELSE
		--  If no error occurred, commit transaction
		COMMIT;
		SELECT 'Transaction committed successfully';
	 END IF;
END $$
DELIMITER ;
CALL my_transaction();