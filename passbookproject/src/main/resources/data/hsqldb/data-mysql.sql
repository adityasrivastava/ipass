INSERT INTO `passbook`.`golf_course` (`added`,`course_name`,`modified`) VALUES (now(),'Golf Course 1',now());
INSERT INTO `passbook`.`golf_course` (`added`,`course_name`,`modified`) VALUES (now(),'Golf Course 2',now());
INSERT INTO `passbook`.`golf_course` (`added`,`course_name`,`modified`) VALUES (now(),'Golf Course 3',now());
INSERT INTO `passbook`.`golf_course` (`added`,`course_name`,`modified`) VALUES (now(),'Golf Course 4',now());

INSERT INTO `passbook`.`golf_holes` (`added`,`holes`,`modified`) VALUES (now(),9,now());
INSERT INTO `passbook`.`golf_holes` (`added`,`holes`,`modified`) VALUES (now(),18,now());

INSERT INTO `passbook`.`golf_tee` (`added`,`color`,`modified`,`par`,`yards`) VALUES (now(),'RED',now(),3,100);
INSERT INTO `passbook`.`golf_tee` (`added`,`color`,`modified`,`par`,`yards`) VALUES (now(),'GREEN',now(),3,100);
INSERT INTO `passbook`.`golf_tee` (`added`,`color`,`modified`,`par`,`yards`) VALUES (now(),'BLUE',now(),3,100);
INSERT INTO `passbook`.`golf_tee` (`added`,`color`,`modified`,`par`,`yards`) VALUES (now(),'BLACK',now(),3,100);

INSERT INTO `passbook`.`golf_pass` (`added`,`modified`,`pass_added`,`token`) VALUES (now(), now(),1,'XYZ');
INSERT INTO `passbook`.`golf_pass` (`added`,`modified`,`pass_added`,`token`) VALUES (now(), now(),1,'ABC');


INSERT INTO `passbook`.`golf_user` (`added`,`modified`,`age`,`gender`,`handicap`,`name`,`pass_id`) VALUES (now(),now(),12,'MALE',20,'ADITYA',1);
INSERT INTO `passbook`.`golf_user` (`added`,`modified`,`age`,`gender`,`handicap`,`name`,`pass_id`) VALUES (now(),now(),12,'MALE',20,'XYZ',1);
INSERT INTO `passbook`.`golf_user` (`added`,`modified`,`age`,`gender`,`handicap`,`name`,`pass_id`) VALUES (now(),now(),12,'MALE',20,'TRE',1);
INSERT INTO `passbook`.`golf_user` (`added`,`modified`,`age`,`gender`,`handicap`,`name`,`pass_id`) VALUES (now(),now(),12,'MALE',20,'FLOWER',1);



INSERT INTO `passbook`.`golf` (`added`,`modified`,`golf_course_id`, `golf_hole_type_id`, `golf_tee_type_id`, `golf_user_id`) VALUES (now(),now(),1,1,1,1);
INSERT INTO `passbook`.`golf` (`added`,`modified`,`golf_course_id`, `golf_hole_type_id`, `golf_tee_type_id`, `golf_user_id`) VALUES (now(),now(),2,2,2,2);
INSERT INTO `passbook`.`golf` (`added`,`modified`,`golf_course_id`, `golf_hole_type_id`, `golf_tee_type_id`, `golf_user_id`) VALUES (now(),now(),3,1,3,3);
INSERT INTO `passbook`.`golf` (`added`,`modified`,`golf_course_id`, `golf_hole_type_id`, `golf_tee_type_id`, `golf_user_id`) VALUES (now(),now(),4,2,4,4);

INSERT INTO `passbook`.`golf_score` (`added`,`game_id`,`hole_number`,`modified`,`score`) VALUES (now(),1,1,now(),4);
INSERT INTO `passbook`.`golf_score` (`added`,`game_id`,`hole_number`,`modified`,`score`) VALUES (now(),2,2,now(),10);
INSERT INTO `passbook`.`golf_score` (`added`,`game_id`,`hole_number`,`modified`,`score`) VALUES (now(),3,3,now(),7);
INSERT INTO `passbook`.`golf_score` (`added`,`game_id`,`hole_number`,`modified`,`score`) VALUES (now(),4,4,now(),9);


