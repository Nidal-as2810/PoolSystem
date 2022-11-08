CREATE TABLE questionTBL(
    id int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    question VARCHAR(100) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);

CREATE TABLE answerTBL(
    id int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    answer VARCHAR(100) NOT NULL DEFAULT '',
    question_id int(11) UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (question_id) REFERENCES questionTBL(id)
);

CREATE TABLE userAnswerTBL(
    id int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id int(11) NOT NULL,
    question_id int(11) NOT NULL,
    answer_id int(11) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (question_id) REFERENCES questionTBL(id),
    FOREIGN KEY (answer_id) REFERENCES answerTBL(id)
);