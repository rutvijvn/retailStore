INSERT INTO `retailstore`.`product_category` ( `CATEGORY_ID` ,`CATEGORY_NAME` ,`DISCOUNT` ,`SERVICE_TAX` )
VALUES ( '1' ,'A' ,'5' ,'10' )
	,( '2' ,'B' ,'12' ,'20' )
	,( '3' ,'C' ,'2' ,'0' );

INSERT INTO `retailstore`.`product` ( `PRODUCT_ID` ,`BARCODE` ,`BASE_PRICE` ,`DISCOUNT` ,`PRODUCT_NAME` ,`WEIGHT` ,`CATEGORY_ID` )
VALUES ( '1' ,'123' ,'100' ,'2' ,'PRODUCT1' ,'1000' ,'1' )
	,( '2' ,'234' ,'500' ,'10' ,'PRODUCT2' ,'0' ,'1' )
	,( '3' ,'345' ,'1000' ,'2' ,'PRODUCT3' ,'1000' ,'1' )
	,( '4' ,'456' ,'586' ,'9' ,'PRODUCT4' ,'1000' ,'2' )
	,( '5' ,'567' ,'899' ,'13' ,'PRODUCT5' ,'0' ,'3' );
