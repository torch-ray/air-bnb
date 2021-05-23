INSERT INTO `airbnb`.`room` (`id`, `location`, `title`, `image`, `description`, `x_pos`, `y_pos`, `ratings`, `reviews`,
                             `charge`, `cleaning_fee`, `service_fee`)
VALUES ('1', '서울', 'Spacious and Comfortable cozy house #4',
        'https://www.airbnb.com/rooms/29556662/photos/604588770?federated_search_id=6422bc81-ecb8-4381-a7b0-758e46144cbe&source_impression_id=p3_1621340285_vHikcFrealdXlffU&guests=1&adults=1',
        '최대 인원 3명 ・ 원룸 ・ 침대 1개 ・ 욕실 1개・ 주방 ・ 무선 인터넷・ 에어컨 ・ 헤어드라이어', '35.97664845766847', '126.99597295767953', '4.5',
        '272', '82953', '25996', '1822468');

INSERT INTO `airbnb`.`user` (`id`, `password`, `nickname`, `email`) VALUES ('team10', '1010', 'Ship', 'ship@codesquad.com');
INSERT INTO `airbnb`.`user` (`id`, `password`, `nickname`, `email`) VALUES ('august', '1234', 'Augboot', 'august@gmail.com');
INSERT INTO `airbnb`.`user` (`id`, `password`, `nickname`, `email`) VALUES ('luke', '1234', 'Luke', 'luke@gmail.com');
INSERT INTO `airbnb`.`user` (`id`, `password`, `nickname`) VALUES ('ray', '1234', 'Ray');
